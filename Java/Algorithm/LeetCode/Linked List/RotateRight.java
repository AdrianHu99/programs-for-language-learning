/*
* @Author: adrianhu
* @Date:   2016-05-17 17:08:38
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-05-17 17:32:48
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
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next == null||k ==0)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = head;
        int j = 1;
        while (a.next != null) {
        	a = a.next;
        	j++;
        }
        k = k%j;
        ListNode b = head;
        for (int i = 0; i < j-k-1;i++ ) {
        	b = b.next;
        }
        a.next = dummy.next;
        dummy.next = b.next;
        b.next = null;
        return dummy.next;
    }
}