/*
* @Author: adrrrrrrrian
* @Date:   2016-04-05 19:15:42
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-05 19:58:15
* @Source: https://leetcode.com/problems/binary-search-tree-iterator/
*/

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

	private TreeNode root;
	private Stack<TreeNode> s = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        orderpush(s,root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ans = s.pop();
        if(ans.right!= null){
        	orderpush(s,ans.right);
        }
        return ans.val;
    }

    public void orderpush(Stack<TreeNode> s, TreeNode root){
    	while(root != null){
    		s.push(root);
    		root = root.left;
    	}
    }


}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */