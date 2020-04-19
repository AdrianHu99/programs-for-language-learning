/*
* @Author: adrrrrrrrian
* @Date:   2016-04-06 20:24:00
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-06 20:24:14
* @Source: https://leetcode.com/problems/binary-tree-postorder-traversal/
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
public class PostorderTraversalRecursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        
        if(root == null){
            return l;
        }
        
        
        
        if(root.left != null){
            l.addAll(postorderTraversal(root.left));
        }

        if(root.right != null){
            l.addAll(postorderTraversal(root.right));
        }
        l.add(root.val);
        return l;

    }
}