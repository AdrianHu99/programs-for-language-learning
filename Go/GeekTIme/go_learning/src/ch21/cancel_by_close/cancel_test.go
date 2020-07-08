package cancel_by_close_test

import (
	"fmt"
	"testing"
	"time"
)

func isCancelled(cancelChan chan struct{}) bool {
	select {
	case <-cancelChan:
		return true
	default:
		return false
	}
}

// push something to the channel, will only cause one groutine to end
func cancel_1(cancelChan chan struct{}) {
	cancelChan <- struct{}{}
}

// close the channel directly, will broadcast to all receivers, thus cause all groutines to end
func cancel_2(cancelChan chan struct{}) {
	close(cancelChan)
}

func TestCancel(t *testing.T) {
	cancelChan := make(chan struct{})
	for i := 0; i < 5; i++ {
		go func(i int, cancelChan chan struct{}) {
			for {
				if isCancelled(cancelChan) {
					break
				}
				time.Sleep(time.Millisecond * 5)
			}
			fmt.Println(i, " cancelled")

		}(i, cancelChan)
	}
	// cancel_1(cancelChan)
	cancel_2(cancelChan)
	time.Sleep(time.Second * 1)
}
