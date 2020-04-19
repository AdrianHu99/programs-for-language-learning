/*
* @Author: adrianhu
* @Date:   2016-03-16 16:01:05
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-03-16 17:56:12
* @Source: https://leetcode.com/problems/insertion-sort-list/
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null)return head;
        ListNode a = new ListNode(0);
        ListNode b = a;
        ListNode c = head;
        while (c != null){
        	ListNode dd = c.next;
        	while(a.next != null && a.next.val <= c.val){
        		a = a.next;
        	}
        	c.next = a.next;
        	a.next = c;
        	a = b;
        	c = dd;
        }
        return b.next;
    }
}