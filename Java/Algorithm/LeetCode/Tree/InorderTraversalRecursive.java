/*
* @Author: adrrrrrrrian
* @Date:   2016-04-06 19:47:13
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-06 20:01:43
* @Source: https://leetcode.com/problems/binary-tree-inorder-traversal/
*/

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderTraversalRecursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        
        if(root == null){
            return l;
        }
        
        if(root.left != null){
            l.addAll(inorderTraversal(root.left));
        }
        l.add(root.val);

        if(root.right != null){
            l.addAll(inorderTraversal(root.right));
        }
        
        return l;

    }
}