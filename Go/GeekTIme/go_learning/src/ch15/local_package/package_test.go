package yoyo

import (
	"fmt"
	"testing"

	"com.qih/ch15/series"
)

func init() {
	fmt.Println("init in test")
}

func TestPackage(t *testing.T) {
	t.Log(series.GetFibonacci(5))
}
