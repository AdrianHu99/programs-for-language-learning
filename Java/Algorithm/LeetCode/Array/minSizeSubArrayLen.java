/*
* @Author: adrrrrrrrian
* @Date:   2016-04-16 22:24:38
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-17 09:27:15
* @Source: https://leetcode.com/problems/minimum-size-subarray-sum/
*/
public class minSizeSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
    	int min = Integer.MAX_VALUE;
    	if(nums.length == 0)return 0;
        int sum = 0;
        int i = 0; int j = 0;
        while (j < nums.length) {
            sum+=nums[j++];
            while(sum>=s){
                min = Math.min(min, j-i);
                sum -= nums[i++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}