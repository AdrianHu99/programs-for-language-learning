/*
* @Author: adrrrrrrrian
* @Date:   2016-05-23 23:23:45
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-06-05 16:11:31
* @Source: https://leetcode.com/problems/patching-array/
*/
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1; 
        int ans = 0;
        int i = 0;
        while (miss <= n) {
        	if (i < nums.length && nums[i] <= miss) {
        		miss += nums[i++];
        	}else{
        		miss+=miss;
        		ans++;
        	}
        }
        return ans;
    }
}