package microkernel

import (
	"context"
	"errors"
	"fmt"
	"testing"
	"time"
)

type DemoCollector struct {
	evtReceiver EventReceiver
	agtCtx      context.Context
	stopChan    chan struct{}
	name        string
	content     string
}

func NewCollect(name string, content string) *DemoCollector {
	return &DemoCollector{
		stopChan: make(chan struct{}),
		name:     name,
		content:  content,
	}
}

func (c *DemoCollector) Init(evtReceiver EventReceiver) error {
	fmt.Println("initialize collect", c.name)
	c.evtReceiver = evtReceiver
	return nil
}

// Interface implementation
func (c *DemoCollector) Start(agtCtx context.Context) error {
	fmt.Println("start collect", c.name)
	for {
		select {
		case <-agtCtx.Done():
			// Send the channel a empty struct to stop
			c.stopChan <- struct{}{}
			break
		default:
			// Keep generating events and push it to the receiver
			time.Sleep(time.Millisecond * 50)
			c.evtReceiver.OnEvent(Event{c.name, c.content})
		}
	}
}

func (c *DemoCollector) Stop() error {
	fmt.Println("stop collect", c.name)
	select {
	case <-c.stopChan:
		return nil
	case <-time.After(time.Second * 1):
		return errors.New("failed to stop for timeout")
	}
}

func (c *DemoCollector) Destroy() error {
	fmt.Println(c.name, "released resources.")
	return nil
}

func TestAgent(t *testing.T) {
	agent := NewAgent(100)
	c1 := NewCollect("c1", "1")
	c2 := NewCollect("c2", "2")
	agent.RegisterCollector("c1", c1)
	agent.RegisterCollector("c2", c2)
	agent.Start()
	fmt.Println(agent.Start())
	time.Sleep(time.Second * 2)
	agent.Stop()
	agent.Destroy()
}
