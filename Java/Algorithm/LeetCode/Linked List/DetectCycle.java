/*
* @Author: adrianhu
* @Date:   2016-03-24 14:13:42
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-03-24 14:19:41
* @Source: https://leetcode.com/problems/linked-list-cycle-ii/
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null)return null;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        do{
        	slow = slow.next;
        	fast = fast.next.next;
        }while(fast != null&&fast.next!=null && slow != fast);
        if(fast == null||fast.next == null)return null;
        ListNode ans = start;
        while(ans != slow){
        	slow = slow.next;
        	ans = ans.next;
        }
        return ans;
    }
}