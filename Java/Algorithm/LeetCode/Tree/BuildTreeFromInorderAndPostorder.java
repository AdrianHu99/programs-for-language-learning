/*
* @Author: Qi Hu
* @Date:   2016-06-23 15:34:36
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-06-23 16:55:29
* @Source: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
public class BuildTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = inorder.length;
        return helper(inorder, postorder, 0, l-1, 0, l-1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend){
    	if (inend < 0 || postend < 0 || poststart > postend||postend >= postorder.length||inend >= inorder.length||instart > inend) {
    		return null;
    	}
    	TreeNode head = new TreeNode(postorder[postend]);
    	int i = instart;
    	while (i <= inend&&inorder[i] != head.val) {
    		i++;
    	}
    	int inleftend = i-1;
    	int postleftend = inleftend-(instart-poststart);
    	int inrightstart = i+1;
    	int inrightend = inend;
    	int postrightstart = postleftend + 1;
    	int postrightend = postend-1;

    	head.left = helper(inorder, postorder, instart, inleftend, poststart, postleftend);
    	head.right = helper(inorder, postorder, inrightstart, inrightend, postrightstart, postrightend);

    	return head;
    }
}