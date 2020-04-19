/*
* @Author: adrrrrrrrian
* @Date:   2016-04-07 16:12:05
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-07 17:18:09
* @Source: https://leetcode.com/problems/binary-tree-postorder-traversal/?sort=hot
*/

import java.util.LinkedList;
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
public class PostorderTraversalIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<Integer>();
        Stack<TreeNode> d = new Stack<TreeNode>();

        while(root != null){
            d.push(root);
            l.add(0,root.val);
            root = root.right;
        }

        while(!d.isEmpty()){
            TreeNode t = d.pop();
            TreeNode r = t.left;
            while(r != null){
                d.push(r);
                l.add(0,r.val);
                r = r.right;
            }
        }
        
        return l;

    }
}