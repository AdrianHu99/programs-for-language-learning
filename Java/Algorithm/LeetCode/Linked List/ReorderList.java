/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList{
	public void reorderList(ListNode head) {
        if(head == null || head.next == null||head.next.next == null){
            return;
        }
        //find the middle point
        ListNode a = head;
        ListNode aa = head;
        while( aa.next != null){
        	a = a.next;
        	aa = aa.next;
        	if(aa.next == null){
        	    break;
        	}else{
        	    aa = aa.next;
        	}
        }


        //reverse the second part
        ListNode start = a.next;
        a.next = null;
        ListNode current = start.next;
        start.next = null;
        while(current != null){
        	ListNode temp = current.next;
        	
        	current.next = start;
        	start = current;
        	current = temp;
        }


        //reorder the list
        ListNode previous = head.next;
        ListNode realhead = head;
        while(previous!= null||start != null){
        	if(previous != null){
        		head.next = previous;
        		head = head.next;
        		previous = previous.next;
        	}
        	if(start != null){
        		head.next = start;
        		head = head.next;
        		start = start.next;
        	}
        }
    }
}