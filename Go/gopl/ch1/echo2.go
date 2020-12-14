package main

import (
	"fmt"
	"os"
)

func main() {
	s, sep := "", ""
	for _, arg := range os.Args[1:] {
		sep = " " + arg
		s += sep
	}

	for index, arg := range os.Args[0:] {
		fmt.Printf("%d, %s\n", index, arg)

	}
	fmt.Println("some inputs: " + s)
}
