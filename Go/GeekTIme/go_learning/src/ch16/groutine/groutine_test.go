package groutine_test

import (
	"fmt"
	"testing"
	"time"
)

func TestGroutine(t *testing.T) {
	for i := 0; i < 10; i++ {
		go func(i int) {
			fmt.Println(i)
		}(i)

		// if we do following, they will all print 10, because the above will use the copied value from i, while below will share the same value with main groutine
		// go func() {
		// 	fmt.Println(i)
		// } ()
	}

	time.Sleep(time.Millisecond * 50)
}
