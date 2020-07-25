package panic_recover_test

import (
	"errors"
	"fmt"
	"testing"
)

func TestPanicExit(t *testing.T) {
	defer func() {
		if err := recover(); err != nil {
			fmt.Println("recovered from ", err)
		}
		fmt.Println("Finally")
	}()

	fmt.Println("Start")

	// defer function will be called if using panic
	panic(errors.New("Something is wrong!"))
	// defer function won't be called if using os.Exit()
	// os.Exit(-1)

	fmt.Println("End")
}
