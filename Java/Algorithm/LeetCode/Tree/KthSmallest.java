/*
* @Author: adrrrrrrrian
* @Date:   2016-04-06 19:22:13
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-06 19:32:48
* @Source: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode a = root;
        while(a != null){
        	s.push(a);
        	a = a.left;
        }

        while(k != 0){
        	TreeNode n = s.pop();
        	k--;
        	if(k == 0)return n.val;
        	TreeNode r = n.right;
        	while(r != null){
        		s.push(r);
        		r = r.left;
        	}
        }

        return 0;
    }
}