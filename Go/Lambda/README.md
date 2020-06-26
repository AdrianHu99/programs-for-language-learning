~/my-function$ go get github.com/aws/aws-lambda-go/lambda
~/my-function$ GOOS=linux go build main.go
~/my-function$ zip function.zip main
~/my-function$ aws lambda create-function --function-name qi-lambda-go --runtime go1.x --zip-file fileb://main.zip --handler main --role arn:aws:iam::637936058229:role/qih_crossAccountA_role


Test input: 
{
  "What is your name?": "Jim",
  "How old are you?": 33
}
