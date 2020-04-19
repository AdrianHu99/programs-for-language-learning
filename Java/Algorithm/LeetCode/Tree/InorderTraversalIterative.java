/*
* @Author: adrrrrrrrian
* @Date:   2016-04-06 19:33:49
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-06 19:44:50
* @Source: https://leetcode.com/problems/binary-tree-inorder-traversal/
*/

import java.util.ArrayList;
import java.util.List;
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
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> l = new ArrayList<Integer>();
        
        while(root != null){
        	s.push(root);
        	root = root.left;
        }

        while(!s.isEmpty()){
        	TreeNode t = s.pop();
        	l.add(t.val);
        	TreeNode r = t.right;
        	while(r!= null){
        		s.push(r);
        		r = r.left;
        	}
        }
        return l;

    }
}