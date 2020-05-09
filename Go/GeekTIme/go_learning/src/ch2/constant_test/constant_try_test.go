package constant_test

import "testing"

const (
	Monday = iota + 1
	Tuesday
	Wednesday
	Thursday
	Friday
	Saturday
	Sunday
)

func TestConstantTry(t *testing.T) {
	t.Log(Monday, Tuesday)
}
