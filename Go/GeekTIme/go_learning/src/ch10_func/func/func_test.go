package func_test

import (
	"fmt"
	"math/rand"
	"testing"
	"time"
)

func returnMultiValues() (int, int) {
	return rand.Intn(10), rand.Intn(20)
}

// With this, we don't need to calculate time for
// other functions, we just need to pass the function into this
// to transform a new function with this ability
func timeSpent(inner func(i int) int) func(o int) int {
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
	a, _ := returnMultiValues()
	t.Log(a)
	tsSF := timeSpent(slowFun)
	t.Log(tsSF(10))
}

func Sum(ops ...int) int {
	ret := 0
	for _, op := range ops {
		ret += op
	}
	return ret
}

func TestVarParam(t *testing.T) {
	t.Log(Sum(1, 2, 3, 4))
	t.Log(Sum(1, 2, 3, 4, 5))

}

func Clear() {
	fmt.Println("Clear resources.")
}

func TestDefer(t *testing.T) {
	// defer could be used like try finally
	defer Clear()
	fmt.Println("Start")
	panic("err")
}
