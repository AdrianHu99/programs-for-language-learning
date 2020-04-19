/*
* @Author: adrianhu
* @Date:   2016-03-15 14:22:46
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-03-15 21:18:23
* @Source: https://leetcode.com/problems/reverse-nodes-in-k-group/
*/
public class ReverseNodeInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null||head.next == null)return head;
        ListNode curr = head;
        int i = k;//this is k because we want to get the head of the next round of k numbers
        while(i-- != 0&&curr != null  ){
            curr = curr.next;// so that curr will be the head of the next k numbers;
        }
        if(i!=-1&&curr == null){
            return head;// that means it does not have k numbers of nodes;
        }
        curr = reverseKGroup(curr,k);//get the head of next k numbers after doing the reverse
        ListNode a = head;
        i = k-1;
        while(i-- > 0){
            ListNode next = a.next;
            a.next = curr;
            curr = a;
            a = next;
        }
        a.next = curr;//remember you need to take care of the last step 
        return a;
    }
}