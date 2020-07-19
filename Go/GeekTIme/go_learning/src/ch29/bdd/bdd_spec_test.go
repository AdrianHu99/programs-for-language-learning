package testing

import (
	"testing"

	. "github.com/smartstreets/goconvey/convey"
)

func TestSpec(t *testing.T) {
	Convey("Given 2 even numbers", t, func() {
		a := 2
		b := 4

		Convey("When add the two numbers", func() {
			c := a + b

			Convey("Then the result should be still even", func() {
				So(c%2, ShouldEqual, 0)
			})
		})
	})
}
