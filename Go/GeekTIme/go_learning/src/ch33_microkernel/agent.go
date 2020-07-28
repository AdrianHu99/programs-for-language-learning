package microkernel

import (
	"context"
	"errors"
	"fmt"
	"strings"
	"sync"
)

type State int

const (
	Running State = iota
	Waiting
)

var WrongStateError = errors.New("can not take the operation in the current state")

type CollectorsError struct {
	CollectorErrors []error
}

func (ce CollectorsError) Error() string {
	var strs []string
	for _, err := range ce.CollectorErrors {
		strs = append(strs, err.Error())
	}
	return strings.Join(strs, ";")
}

type Event struct {
	Source  string
	Content string
}

type EventReceiver interface {
	OnEvent(evt Event)
}

type Collector interface {
	Init(evtReceiver EventReceiver) error
	Start(agtCtx context.Context) error
	Stop() error
	Destroy() error
}

type Agent struct {
	collectors map[string]Collector
	evtBuf     chan Event
	cancel     context.CancelFunc
	ctx        context.Context
	state      State
}

// Print out events in a batch of 10
func (agt *Agent) EventProcessGroutine() {
	var evtSeg [10]Event
	for {
		for i := 0; i < 10; i++ {
			select {
			case evtSeg[i] = <-agt.evtBuf:
			case <-agt.ctx.Done():
				fmt.Println("agent is done")
				return
			}
		}
		fmt.Println("event seg: ", evtSeg)
	}
}

func NewAgent(sizeEvtBuf int) *Agent {
	agent := Agent{
		collectors: map[string]Collector{},
		evtBuf:     make(chan Event, sizeEvtBuf),
		state:      Waiting,
	}

	return &agent
}

// Register collector to the agent
func (agent *Agent) RegisterCollector(name string, collector Collector) error {
	if agent.state != Waiting {
		return WrongStateError
	}
	agent.collectors[name] = collector
	return collector.Init(agent)
}

// Start all collectors one by one
func (agent *Agent) startCollectors() error {
	var err error
	var errs CollectorsError
	var mutex sync.Mutex
	for name, collector := range agent.collectors {
		go func(name string, collector Collector, ctx context.Context) {
			defer func() {
				mutex.Unlock()
			}()
			err = collector.Start(ctx)
			mutex.Lock()
			if err != nil {
				errs.CollectorErrors = append(errs.CollectorErrors, errors.New(name+":"+err.Error()))
			}
		}(name, collector, agent.ctx)
	}
	return errs
}

// Stop all collectors one by one
func (agent *Agent) stopCollectors() error {
	var err error
	var errs CollectorsError
	for name, collector := range agent.collectors {
		if err = collector.Stop(); err != nil {
			errs.CollectorErrors = append(errs.CollectorErrors, errors.New(name+":"+err.Error()))
		}
	}
	return errs
}

func (agent *Agent) destroyCollectors() error {
	var err error
	var errs CollectorsError
	for name, collector := range agent.collectors {
		if err = collector.Destroy(); err != nil {
			errs.CollectorErrors = append(errs.CollectorErrors, errors.New(name+":"+err.Error()))
		}
	}
	return errs
}

func (agent *Agent) Start() error {
	if agent.state != Waiting {
		return WrongStateError
	}
	agent.state = Running
	agent.ctx, agent.cancel = context.WithCancel(context.Background())
	go agent.EventProcessGroutine()
	return agent.startCollectors()
}

func (agent *Agent) Stop() error {
	if agent.state != Running {
		return WrongStateError
	}
	agent.state = Waiting
	agent.cancel()
	return agent.stopCollectors()
}

func (agent *Agent) Destroy() error {
	if agent.state != Waiting {
		return WrongStateError
	}
	return agent.destroyCollectors()
}

func (agent *Agent) OnEvent(event Event) {
	agent.evtBuf <- event
}
