package customer_type_test

import (
	"fmt"
	"testing"
	"time"
)

type IntConv func(op int) int

// Use IntConv to replace the method name in ch10.func_test.go
func timeSpent(inner IntConv) IntConv {
	return func(n int) int {
		start := time.Now()
		ret := inner(n)
		fmt.Println("time spent:", time.Since(start).Seconds())
		return ret
	}
}

func slowFun(sss int) int {
	time.Sleep(time.Second * 1)
	return sss
}

func TestFn(t *testing.T) {
	tsSF := timeSpent(slowFun)
	t.Log(tsSF(10))
}
