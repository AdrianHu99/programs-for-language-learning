/*
* @Author: adrrrrrrrian
* @Date:   2016-04-06 20:12:29
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-06 20:12:40
* @Source: https://leetcode.com/problems/binary-tree-preorder-traversal/
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
public class PreorderTraversalRecursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        
        if(root == null){
            return l;
        }
        
        l.add(root.val);
        
        if(root.left != null){
            l.addAll(preorderTraversal(root.left));
        }

        if(root.right != null){
            l.addAll(preorderTraversal(root.right));
        }
        
        return l;

    }
}