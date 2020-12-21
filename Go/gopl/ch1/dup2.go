package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	counts := make(map[string]int)
	files := os.Args[1:]
	if len(files) > 0 {
		for _, file := range files {
			f, err := os.Open(file)
			if err != nil {
				fmt.Fprintf(os.Stderr, "dup2: %v\n", err)
				continue
			} else {
				countLines(f, counts)
			}
			f.Close()
		}
	} else {
		countLines(os.Stdin, counts)
	}
	// NOTE:ignoring potential errors from input.Err()
	for line, n := range counts {
		if n > 1 {
			fmt.Printf("%d\t%s\n", n, line)
		}
	}
}

func countLines(f *os.File, counts map[string]int) { // counts is passed by reference
	input := bufio.NewScanner(f)
	for input.Scan() {
		counts[input.Text()]++
	}
}
