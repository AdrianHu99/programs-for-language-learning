package map_test

import "testing"

func TestInitMap(t *testing.T) {
	m1 := map[int]int{1: 1, 2: 4, 3: 9}
	t.Log(m1[2])
	// if no matching key, return 0
	t.Log(m1[4])
	t.Logf("len m1=%d", len(m1))
	m2 := map[int]int{}
	t.Logf("len m2=%d", len(m2))
	m3 := make(map[int]int, 10)
	t.Logf("len m3=%d", len(m3))
}

func TestAccessNotExistingKey(t *testing.T) {
	m1 := map[int]int{}
	t.Log(m1[1])
	m1[2] = 0
	t.Log(m1[2])
	// how can I differentiate scenarios where key does exist and value is 0, or key does not exist?
	if v, ok := m1[3]; ok {
		t.Logf("Key 3 exists, the value is %d", v)
	} else {
		t.Log("key 3 does not exist")
	}
}

func TestTravelMap(t *testing.T) {
	m1 := map[int]int{1: 1, 2: 4, 3: 9}
	for k, v := range m1 {
		t.Log(k, v)
	}
}
