package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	counts := make(map[string]int)
	nameMap := make(map[string][]string)
	files := os.Args[1:]
	if len(files) > 0 {
		for _, file := range files {
			f, err := os.Open(file)
			if err != nil {
				fmt.Fprintf(os.Stderr, "dup2: %v\n", err)
				continue
			} else {
				countLines(f, counts, nameMap)
			}
			f.Close()
		}
	} else {
		countLines(os.Stdin, counts, nameMap)
	}
	// NOTE:ignoring potential errors from input.Err()
	for line, n := range counts {
		if n > 1 {
			fmt.Printf("%d\t%s\n", n, line)
			for index, str := range nameMap[line] {
				fmt.Printf("The file contains the %v th dup %v is called %v \n", index+1, line, str)
			}
		}
	}
}

func countLines(f *os.File, counts map[string]int, nameMap map[string][]string) { // counts is passed by reference
	input := bufio.NewScanner(f)
	for input.Scan() {
		counts[input.Text()]++
		nameMap[input.Text()] = append(nameMap[input.Text()], f.Name())
	}
}
