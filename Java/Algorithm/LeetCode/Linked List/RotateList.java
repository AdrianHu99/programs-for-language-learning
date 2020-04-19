/*
* @Author: adrianhu
* @Date:   2016-04-04 18:29:08
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-04-04 18:40:48
* @Source: https://leetcode.com/problems/rotate-list/
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList{
	 public ListNode rotateRight(ListNode head, int k) {
        ListNode s = head;
        if(s == null||s.next == null){
        	return head;
        }
        int a = 0;
        while(s != null){
        	a++;
        	s = s.next;
        }
        k = k%a;
        s = new ListNode(0);
        ListNode ss = s;
        s.next = head;
        for(int i = 0; i < k; i++){
        	ss = ss.next;
        }
        while(ss.next != null){
        	s = s.next;
        	ss = ss.next;
        }
        ss.next = head;
        head = s.next;
        s.next = null;
        return head;
    }
}
