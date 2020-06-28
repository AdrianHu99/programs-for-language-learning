package interface_test

import (
	"fmt"
	"testing"
)

type Code string
type Programmer interface {
	WriteHelloWorld() Code
}

type GoProgrammer struct {
}

func (g *GoProgrammer) WriteHelloWorld() Code {
	return "fmt.Println(\"hello world\")"
}

type JavaProgrammer struct {
}

func (p *JavaProgrammer) WriteHelloWorld() Code {
	return "system.out.println(\"hello world\");"
}

func WriteFirstFunction(p Programmer) {
	fmt.Printf("%T %v\n", p, p.WriteHelloWorld())
}

func TestClient(t *testing.T) {
	gop := new(GoProgrammer)
	javap := new(JavaProgrammer)
	WriteFirstFunction(gop)
	WriteFirstFunction(javap)
}
