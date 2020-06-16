package condition_test

import "testing"

func TestIfMultiSec(t *testing.T) {
	if a := 1 == 1; a {
		t.Log("1==1")
	}
	// How to use the condition in if?
	// if v,err := someFunc(); err==nil {

	// } else {

	// }
}
