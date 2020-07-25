package share_mem

import (
	"sync"
	"testing"
	"time"
)

// Without locking, there will be contention and the counter in the end won't be 5000
func TestCounter(t *testing.T) {
	counter := 0
	for i := 0; i < 5000; i++ {
		go func() {
			counter++
		}()
	}
	time.Sleep(1 * time.Second)
	t.Logf("counter = %d", counter)
}

func TestCounterThreadSafe(t *testing.T) {
	var mut sync.Mutex
	counter := 0
	for i := 0; i < 5000; i++ {
		go func() {
			defer func() {
				mut.Unlock()
			}()
			mut.Lock()
			counter++
		}()
	}

	// Add a sleep to wait until all groutines finish their jobs
	time.Sleep(1 * time.Second)
	t.Logf("counter = %d", counter)
}

// Instead of using sleep, we use sync.WaitGroup() to wait until all groutines finish, it is similar to Java's join()
func TestCounterWaitGroup(t *testing.T) {
	var mut sync.Mutex
	var wg sync.WaitGroup
	counter := 0
	for i := 0; i < 5000; i++ {
		wg.Add(1)
		go func() {
			defer func() {
				mut.Unlock()
			}()
			mut.Lock()
			counter++
			wg.Done()
		}()
	}

	wg.Wait()
	t.Logf("counter = %d", counter)
}
