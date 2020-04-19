import java.util.PriorityQueue;
import java.util.Queue;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-08 13:27:52
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-11 10:15:48
* @Source: https://leetcode.com/problems/find-median-from-data-stream/
*/
class MedianFinder {
	Queue<Long> s = new PriorityQueue<Long>();
	Queue<Long> l = new PriorityQueue<Long>(); 

    // Adds a number into the data structure.
    public void addNum(int num) {
        l.add((long)num);
        s.add(-l.poll());
        if(l.size() < s.size()){
        	l.add(-s.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return l.size()>s.size()? l.peek():(l.peek()-s.peek())/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();