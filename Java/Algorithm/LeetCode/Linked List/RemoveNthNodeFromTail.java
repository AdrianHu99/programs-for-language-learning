// Source : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Author : Qi Hu
// Date   : 2016-02-01

/**********************************************************************************
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 *
 *Note:
 *
 *Given n will always be valid.
 *
 **********************************************************************************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromTail {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(0);
        ListNode b = prev;
        ListNode a = prev;
        prev.next = head;
        while(n>0){
            b = b.next;
            n--;
        }
        while(b.next != null){
            a = a.next;
            b = b.next;
        }
        a.next = a.next.next;
        return prev.next;
        
    }
}