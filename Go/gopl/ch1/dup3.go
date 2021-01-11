package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)

func main() {
	counts := make(map[string]int)
	for _, fileName := range os.Args[1:] {
		data, err := ioutil.ReadFile(fileName)
		if err != nil {
			fmt.Printf("err: %v \n ", err)
			continue
		}
		arrayOfStrings := strings.Split(string(data), "\n")
		for _, line := range arrayOfStrings {
			counts[line]++
		}
	}
	for str, counter := range counts {
		if counter > 1 {
			fmt.Printf("Got duplicated line: %v which showed up %v times \n", str, counter)
		}
	}
}
