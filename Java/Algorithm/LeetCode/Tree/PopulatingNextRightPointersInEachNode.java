/*
* @Author: adrrrrrrrian
* @Date:   2016-04-20 09:40:09
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-20 10:17:15
* @Source: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/

import java.util.LinkedList;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode  {
    public void connect(TreeLinkNode root) {
        if(root == null)return;
        else {
        	root.next = null;
        	LinkedList<TreeLinkNode> l = new LinkedList<TreeLinkNode>();
        	LinkedList<TreeLinkNode> ll = new LinkedList<TreeLinkNode>();
        	if(root.left != null)l.add(root.left);
        	if(root.right != null)l.add(root.right);
    		//for each up layer(lingkedlist)
    		while (l.size() > 0) {
    			TreeLinkNode t = l.poll();
    			//the difference between peek and peekfirst is that peekfirst will return null when the list is empty
    			t.next = l.peekFirst();
    			if(t.left != null)ll.add(t.left);
    			if(t.right != null)ll.add(t.right);
    			if(l.size() == 0){
    				l = new LinkedList<TreeLinkNode>(ll);
    				//remember to clear ll!
    				ll.clear();
    			}
    		}
        }
    }
}