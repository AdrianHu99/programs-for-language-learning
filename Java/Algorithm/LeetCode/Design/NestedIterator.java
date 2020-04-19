/*
* @Author: Qi Hu
* @Date:   2016-07-22 10:25:32
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-07-22 11:07:23
* @Source: https://leetcode.com/problems/flatten-nested-list-iterator/
*/

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack<NestedInteger>();
    public NestedIterator(List<NestedInteger> nestedList) {

    	for (int i = nestedList.size()-1; i>=0; i--) {
    		stack.push(nestedList.get(i));
    	}
    }

    @Override
    public Integer next() {
    	return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
    	while (!stack.isEmpty()) {
    		NestedInteger ni = stack.peek();
    		if (ni.isInteger()) {
    			return true;
    		}
    		stack.pop();
    		for (int i = ni.getList().size()-1; i>=0; i--) {
    			stack.push(ni.getList().get(i));
    		}
    	}
    	return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */