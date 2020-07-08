package select_test

import (
	"fmt"
	"testing"
	"time"
)

func service() string {
	time.Sleep(time.Millisecond * 50)
	// change the sleep time to cause the timeout
	//time.Sleep(time.Millisecond * 500)
	return "Done"
}

func AsyncService() chan string {
	// create the channel
	retCh := make(chan string)
	go func() {
		ret := service()
		fmt.Println("returned result.")
		// put response to the channel
		retCh <- ret
		fmt.Println("service exited.")
	}()
	return retCh
}

// Implement timeout mechanism
func TestSelect(t *testing.T) {
	select {
	case retCh := <-AsyncService():
		t.Log(retCh)
	case <-time.After(time.Millisecond * 100):
		t.Error("TIME OUT")
	}
}
