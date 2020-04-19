/*
* @Author: adrrrrrrrian
* @Date:   2016-04-20 10:31:06
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-20 10:39:50
* @Source: https://leetcode.com/problems/binary-tree-right-side-view/
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
public class TreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        go(l, root, 0);
        return l;
    }
    public void go(List<Integer> l, TreeNode root, int depth){
    	if(root == null)return;

    	if(depth == l.size()){
    		l.add(root.val);
    	}

    	go(l, root.right, depth+1);
    	go(l, root.left, depth+1);

    }
}