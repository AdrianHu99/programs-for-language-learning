/*
* @Author: adrrrrrrrian
* @Date:   2016-03-22 17:41:40
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-22 19:17:48
* @Source: https://leetcode.com/problems/subsets-ii/
*/

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> a = new ArrayList<Integer>();
    	backtracking(nums, 0, ans, a);
    	return ans;
    }
    public void backtracking(int[] nums, int index, List<List<Integer>> ans, List<Integer> a){
    	if(index < nums.length){
    		ans.add(a);
    	}
    	int i = index;
    	while(i < nums.length){
    		a.add(nums[i]);
    		backtracking(nums, i+1, ans, a);
    		a.remove(a.size()-1);
    		i++;
	    	while(i<nums.length&&nums[i]==nums[i-1]){
	    		i++;
	    	}
    	}
    }
}