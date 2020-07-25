package error_test

import (
	"errors"
	"fmt"
	"testing"
)

var LessThanZeroError = errors.New("n should not be less than 0")
var moreThanHundredError = errors.New("n should not be more than 100")

// Show how to do error handling in Go
func GetFibonacci(n int) ([]int, error) {
	if n < 0 {
		return nil, LessThanZeroError
	}
	if n > 100 {
		return nil, moreThanHundredError
	}

	fibList := []int{1, 1}
	for i := 2; i < n; i++ {
		fibList = append(fibList, fibList[i-2]+fibList[i-1])
	}
	return fibList, nil
}

func LalalaGetFibibonacci(n int) ([]int, error) {
	return GetFibonacci(n)
}

func TestYo(t *testing.T) {
	valueForTest := 7
	// valueForTest := -11
	// valueForTest := 111
	if v, err := LalalaGetFibibonacci(valueForTest); err != nil {
		if err == LessThanZeroError {
			fmt.Println("It is less than 0")
		}
		if err == moreThanHundredError {
			fmt.Println("It is more than 100")
		}
		t.Error(err)
	} else {
		t.Log(v)
	}
}

// Best practice in error handling for Go: fail first
/*
if v1,err = function(); err == nil {
	if v2,err = function2(); err == nil {
		doBusinessLogic()
	} else {
		fmt.Println("Error", err)
	}
} else {
	fmt.Println("Error", err)
}

above is not recommended, instead:

if v1,err = function(); err != nil {
	fmt.Println("Error", err)
}
if v2,err = function2(); err != nil {
	fmt.Println("Error", err)
}
doBusinessLogic()
*/
