/*
* @Author: adrianhu
* @Date:   2016-03-15 21:20:26
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-03-15 22:50:02
* @Source: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class deleteDuplicates2{
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null|| head.next == null)return head;
        ListNode dummy = new ListNode(0);
        ListNode d1 = head;
        ListNode d2 = head.next;
        if(d1.val != d2.val){
        	dummy.next = d1;
        }
        ListNode d3 = dummy.next==null?dummy:dummy.next;//we wand the initial d3 is not null; and in the future the new node will be put into d3.next
        while(d2!= null){
        	if(d2.next == null){
        		if(d2.val == d1.val){
        			d3.next = null;
        		}else{
        			d3.next = d2;
        		}
        		return dummy.next;
        	}
        	if(d2.val == d2.next.val||d2.val == d1.val){
        		
        	}else{
        		d3.next = d2;
        		d3 = d3.next;
        	}
        	d1 = d1.next;
        	d2 = d2.next;
        }
        return dummy.next;
    }
}