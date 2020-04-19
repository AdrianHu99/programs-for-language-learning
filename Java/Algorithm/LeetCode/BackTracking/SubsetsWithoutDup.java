import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-23 16:21:56
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-23 16:27:26
* @Source: https://leetcode.com/problems/subsets/
*/
public class SubsetsWithoutDup {
    public List<List<Integer>> subsets(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        backtracking(ans, a, 0,nums);
        return ans;
    }
    public void backtracking(List<List<Integer>> ans, List<Integer> a, int i, int[] nums){
    	if(i <= nums.length){
    		ans.add(new ArrayList<Integer>(a));
    	}

    	while (i < nums.length) {
    		a.add(nums[i]);
    		backtracking(ans, a, i+1,nums);
    		a.remove(a.size()-1);
    		i++;
    	}
    	return;
    }
}