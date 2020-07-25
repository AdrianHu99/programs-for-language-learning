package testing

import (
	"fmt"
	"testing"
)

func TestSquare(t *testing.T) {
	inputs := [...]int{1, 2, 3}
	expected := [...]int{1, 4, 9}
	for i := 0; i < len(inputs); i++ {
		ret := square(inputs[i])
		if ret != expected[i] {
			t.Errorf("input is %d, the expected is %d, the actual is %d", inputs[i], expected[i], ret)
		}
	}
}

// Error will still continue the current test
func TestErrorInCode(t *testing.T) {
	fmt.Println("Start")
	t.Error("Error")
	fmt.Println("End")
}

// Fatal won't continue the current test
func TestFatalInCode(t *testing.T) {
	fmt.Println("Start")
	t.Fatal("Fatal")
	fmt.Println("End")
}
