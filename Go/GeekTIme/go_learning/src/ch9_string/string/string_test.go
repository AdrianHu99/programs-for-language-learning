package string_test

import "testing"

func TestString(t *testing.T) {
	var s string
	t.Log(s)
	s = "hello"
	t.Log(len(s))

	// s[1] = '3' // string is non-changeable byte slice
	s = "\xE4\xB8\xA5"
	// s = "\xE4\xBA\xB5\xFF"
	t.Log(s)
	// it's the length of the bytes
	t.Log(len(s))

	s = "严"
	t.Log(len(s))
	// fetch unicode from string
	c := []rune(s)
	t.Log(len(c))
	t.Logf("严 unicode %x", c[0])
	t.Logf("严 UTF8 %x", s)
}

func TestStringToRune(t *testing.T) {
	s := "严严严严严严严"
	for _, c := range s {
		t.Logf("%[1]c %[1]d %[1]x", c)
	}
}
