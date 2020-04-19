/*
* @Author: adrianhu
* @Date:   2016-03-15 13:00:10
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-03-15 13:33:26
* @Source: https://leetcode.com/problems/swap-nodes-in-pairs/
*/
public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null)return null;
        else{
        	ListNode a = head;
        	if(a.next == null)return head;
        	else{
        		ListNode b = head;
        		a = a.next;
        		b = swapPairs(b.next.next);
        		a.next = b;
        	}
        	return a;
        }
    }
}