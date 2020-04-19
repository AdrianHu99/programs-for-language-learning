import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-05-17 17:47:24
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-17 18:03:37
* @Source: https://leetcode.com/problems/3sum/
*/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int l = nums.length;
        for (int i = 0; i < l-2; i++) {
        	if (i == 0|| nums[i] != nums[i-1]) {
        		int lo = i+1;
        		int hi = l-1;
        		int end = 0-nums[i];
        		while (lo < hi) {
        			if (nums[lo]+nums[hi] == end) {
	        			ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
	        			while (lo < hi&&nums[lo] == nums[lo+1]) {
	        				lo++;
	        			}
	        			while (lo < hi&&nums[hi] == nums[hi-1]) {
	        				hi--;
	        			}
	        			lo++;
	        			hi--;
	        		}else if (nums[lo]+nums[hi] < end) {
	        			lo++;
	        		}else {
	        			hi--;
	        		}
        		}
        		
        	}
        }
        return ans;
    }
}