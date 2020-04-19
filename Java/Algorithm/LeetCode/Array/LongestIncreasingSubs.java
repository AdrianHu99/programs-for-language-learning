/*
* @Author: adrrrrrrrian
* @Date:   2016-04-15 09:33:55
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-15 10:22:56
* @Source: https://leetcode.com/problems/longest-increasing-subsequence/
*/


//tags: arrays, DP
public class LongestIncreasingSubs {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        // This array is to record the length of longest subsequence with nums[i](this is very important)
        // Again, count[] is not the maximum length of previous i numbers![1,2,3,6,7,8,9,4]: count[n-1]=4
        int[] count = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
        	count[i] = 1;
        	for (int j = 0 ; j < n; j++) {
        		// If so, that means the length might be longer when adding nums[i];
        		if(nums[j] < nums[i]){
        			// We need to notice that even so, count[j]+1 might not be larger than count[i]
        			count[i] = count[i]>(count[j]+1)?count[i]:(count[j]+1);
        		}
        	}
        	max = Math.max(max, count[i]);
        }
        return max;
    }
}