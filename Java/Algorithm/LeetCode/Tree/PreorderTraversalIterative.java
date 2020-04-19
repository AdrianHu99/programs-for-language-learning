/*
* @Author: adrrrrrrrian
* @Date:   2016-04-06 20:36:07
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-06 20:38:02
* @Source: https://leetcode.com/problems/binary-tree-preorder-traversal/
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
public class PreorderTraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        while(root != null){
            s.push(root);
            l.add(root.val);
            root = root.left;
        }

        while(!s.isEmpty()){
            TreeNode t = s.pop();
            TreeNode r = t.right;
            while(r != null){
                s.push(r);
                l.add(r.val);
                r = r.left;
            }
        }
        
        return l;

    }
}