package pipefilter

// Request is the input of the filter
type Request interface{}

// Response is the output of the filter
type Response interface{}

// Filter interface is the definition of the data processing components
// pipe-filter structure
type Filter interface {
	Process(data Request) (Response, error)
}
