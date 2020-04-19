import java.util.ArrayList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-27 22:53:40
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-27 23:27:16
* @Source: https://leetcode.com/problems/permutations/
*/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> an = new ArrayList<Integer>();
        int n = nums.length;
        back(nums, 0, an, ans);
        return ans;
    }
    public void back(int[] nums, int index, List<Integer> an, List<List<Integer>> ans){
    	if(index == nums.length){
    		ans.add(new ArrayList<Integer>(an));
    		return;
    	}


    	for (int i = 0; i < nums.length;i++ ) {
    		if(nums[i] == Integer.MAX_VALUE){

    		}else{
    			
    			int a = nums[i];
    			an.add(a);
    			nums[i] = Integer.MAX_VALUE;
    			back(nums, index+1, an, ans);
    			nums[i] = a;
    			an.remove(an.size()-1);
    		}
    	}
    	return;
    }
}