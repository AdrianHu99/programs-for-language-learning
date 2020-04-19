import java.util.Stack;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-07 17:44:48
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-07 18:03:04
* @Source: https://leetcode.com/problems/min-stack/
*/
class MinStack {
	Stack<Integer> s = new Stack<Integer>();
	int min = Integer.MAX_VALUE;
    public void push(int x) {
        if(x <= min){
        	s.push(min);
        	min = x;
        }
        s.push(x);
    }

    public void pop() {
        int a = s.pop();
        if(a == min){
        	min = s.pop();
        }

    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}
