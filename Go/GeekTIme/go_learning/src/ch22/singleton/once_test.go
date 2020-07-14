package once_test

import (
	"fmt"
	"sync"
	"testing"
	"unsafe"
)

/*
var once sync.ONce
var obj *SingletonObj

func GetSingletonObj() *SingletonObj {
	once.Do(func() {
		fmt.Println("Create singleton obj")
		obj = &SingletonObj{}
	})
	return obj
}
*/

type Singleton struct {
}

var singleInstance *Singleton
var once sync.Once

func GetSingletonObj() *Singleton {
	once.Do(func() {
		fmt.Println("Create obj")
		singleInstance = new(Singleton)
	})
	return singleInstance
}

// Test to make sure getSingletonObject will always get the same object
func TestGetSingletonObj(t *testing.T) {
	var wg sync.WaitGroup
	for i := 0; i < 10; i++ {
		wg.Add(1)
		go func() {
			obj := GetSingletonObj()
			fmt.Printf("%x\n", unsafe.Pointer(obj))
			wg.Done()
		}()
	}
	wg.Wait()
}
