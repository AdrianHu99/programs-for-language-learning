import java.util.Iterator;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-07 17:26:11
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-07 17:36:22
* @Source: https://leetcode.com/problems/peeking-iterator/
*/
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> i1;
    Integer next = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    i1 = iterator;
	    if(i1.hasNext()){
	    	next = i1.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer a = next;
		next = i1.hasNext()?i1.next():null;
	    return a;
	}

	@Override
	public boolean hasNext() {
	    return next!=null;
	}
}