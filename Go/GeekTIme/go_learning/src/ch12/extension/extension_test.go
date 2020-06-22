package extension

import (
	"fmt"
	"testing"
)

type Pet struct {
}

func (p *Pet) Speak() {
	fmt.Print("...")
}

func (p *Pet) SpeakTo(host string) {
	p.Speak()
	fmt.Println(" ", host)
}

// type Dog struct {
// 	p *Pet
// }

// func (d *Dog) Speak() {
// 	d.p.Speak()
// }

// func (d *Dog) SpeakTo(host string) {
// 	d.p.SpeakTo(host)
// }

// above can be achieved just by this
type Dog struct {
	Pet
}

func TestDog(t *testing.T) {
	dog := new(Dog)
	dog.SpeakTo("Chao")
}
