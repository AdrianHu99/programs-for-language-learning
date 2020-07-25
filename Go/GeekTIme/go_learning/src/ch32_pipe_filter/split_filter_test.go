package pipefilter

import (
	"fmt"
	"testing"
)

func TestSplitFilter(t *testing.T) {
	spliter := NewSplitFilter(",")
	str := "abc,etdf,sfs"
	ret, err := spliter.Process(str)
	if err != nil {
		t.Fatal(err)
	}

	fmt.Println(ret)
}
