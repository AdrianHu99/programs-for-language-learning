package condition_test

import "testing"

func TestIfMultiSec(t *testing.T) {
	if a := 1 == 1; a {
		t.Log("1==1")
	}
	// How to use the condition in if?
	// if v,err := someFunc(); err==nil {
	// what do we do if there is no error
	// } else {
	// what do we do if there is an error
	// }
}

func TestSwitchMultiCase(t *testing.T) {
	for i := 0; i < 5; i++ {
		switch i {
		// go supports multiple values to match in one case
		case 0, 2:
			t.Log("Even")
			// break, go will by default break it
		case 1, 3:
			t.Log("Odd")
		default:
			t.Log("it is not 0-3")
		}
	}
}

func TestSwitchCondition(t *testing.T) {
	for i := 0; i < 5; i++ {
		switch {
		// go supports multiple values to match in one case
		case i%2 == 0:
			t.Log("Even")
			// break, go will by default break it
		case i%2 == 1:
			t.Log("Odd")
		default:
			t.Log("unknown")
		}
	}
}
