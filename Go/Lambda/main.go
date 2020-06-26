package main

import (
	"fmt"

	"github.com/aws/aws-lambda-go/lambda"
)

// MyEvent is ...
type MyEvent struct {
	Name string `json:"What is your name?"`
	Age  int    `json:"How old are you?"`
}

// MyResponse is ...
type MyResponse struct {
	Message string `json:"Answer:"`
}

// HandleLambdaEvent is ...
func HandleLambdaEvent(event MyEvent) (MyResponse, error) {
	return MyResponse{Message: fmt.Sprintf("%s is %d years old!", event.Name, event.Age)}, nil
}

func main() {
	lambda.Start(HandleLambdaEvent)
}
