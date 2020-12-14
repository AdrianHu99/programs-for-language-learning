package main

import (
	"fmt"
	"os"
)

func main() {
	var s, sep string
	// s = "" // don't need this, string is initialized into empty string by default
	i := 1
	for ; i < len(os.Args); i++ {
		sep = os.Args[i]
		s += sep + " "
	}
	if s != "" {
		fmt.Println("We got some inputs: " + s)
	}
}
