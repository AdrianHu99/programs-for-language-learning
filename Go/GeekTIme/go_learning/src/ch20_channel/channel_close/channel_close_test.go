package channel_close_test

import (
	"fmt"
	"sync"
	"testing"
)

func dataProducer(ch chan int, wg *sync.WaitGroup) {
	go func() {
		for i := 0; i < 10; i++ {
			ch <- i
		}
		close(ch)
		wg.Done()
	}()
}

func dataReceiver(ch chan int, wg *sync.WaitGroup) {
	go func() {
		// with checking if channel is closed, now we don't need to use fori loop
		//for i := 0; i < 10; i++ {
		for {
			if data, ok := <-ch; ok { // channel is open
				fmt.Println(data)
			} else { // ok is false, meaning the channel is closed
				fmt.Println("Found channel closed")
				break
			}
		}
		wg.Done()
	}()
}

func TestClosedChannel(t *testing.T) {
	var wg sync.WaitGroup
	ch := make(chan int)
	wg.Add(1)
	dataProducer(ch, &wg)
	wg.Add(1)
	dataReceiver(ch, &wg)
	// wg.Add(1)
	// dataReceiver(ch, &wg)
	// wg.Add(1)
	// dataReceiver(ch, &wg)
	wg.Wait()
}
