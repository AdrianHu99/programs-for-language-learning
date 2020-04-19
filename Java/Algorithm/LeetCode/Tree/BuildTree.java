/*
* @Author: adrrrrrrrian
* @Date:   2016-06-03 23:10:22
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-06-04 00:05:53
* @Source: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0, inorder.length -1, preorder, inorder);


    }

    public TreeNode helper(int pres, int ins, int ine, int[] preorder, int[] inorder){
    	if (ins > ine || pres > preorder.length - 1) {
    		return null;
    	}

    	TreeNode head = new TreeNode(preorder[pres]);
    	int index = 0;
    	for (int i = ins; i <= ine; i++) {//remember here is i <=ine, because ine is already the length - 1;
    		if(inorder[i] == head.val){
    			index = i;
    		}
    	}
    	head.left = helper(pres+1, ins, index-1, preorder, inorder);
    	head.right = helper(pres+index-ins+1,index+1,ine, preorder, inorder);
    	return head;

    }
}