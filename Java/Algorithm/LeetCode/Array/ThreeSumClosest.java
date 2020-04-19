/*
* @Author: Qi Hu
* @Date:   2016-06-22 21:25:18
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-06-22 21:35:21
* @Source: https://leetcode.com/problems/3sum-closest/
*/
import java.lang.Math;
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int l = nums.length;
        int ans = nums[0]+nums[1]+nums[l-1];
        Arrays.sort(nums);
        for (int i = 0; i < l-2; i++) {
    		int lo = i+1;
    		int hi = l-1;
    		int val = nums[i];
    		while (lo < hi) {
    			int bb = val + nums[lo] + nums[hi];
    			int aa = Math.abs(target - bb);
    			if ( bb > target) {
        			hi--;
        		}else if(bb < target) {
        			lo++;
        		}else{
        		    ans = target;
        		    break;
        		}
        		if (Math.abs(target-ans)>aa) {
        			ans = bb;
        		}
    		}
        }
        return ans;
    }
}