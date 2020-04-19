/*
* @Author: adrianhu
* @Date:   2016-04-04 19:46:07
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-04-06 10:49:55
* @Source: https://leetcode.com/problems/merge-k-sorted-lists/
*/

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKLists {
     public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0)return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                if(a.val > b.val )return 1;
                else if(a.val == b.val )return 0;
                else return -1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        for(ListNode l: lists){
            queue.add(l);
        }

        while(queue.size() > 0){
            head.next = queue.poll();
            head = head.next;
            if(head.next != null){
                queue.add(head.next);
            }
        }
        return dummy.next;
    }
}