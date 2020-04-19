/*
* @Author: adrrrrrrrian
* @Date:   2016-03-21 17:59:12
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-24 17:47:15
* @Source: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        if(head.next == null)return new TreeNode(head.val);
        ListNode fast = head;
        ListNode slow = head;
        ListNode a = null;
        while(fast.next!=null&&fast.next.next!= null){
        	fast = fast.next.next;
        	a = slow;
            slow = slow.next;
        }
        if(a == null){
            head = null;
        }else{
            a.next = null;
        }
        TreeNode root = new TreeNode(slow.val);
        ListNode newhead = slow.next;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(newhead);
        return root;
    }
}