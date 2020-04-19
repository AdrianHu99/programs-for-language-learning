/*
* @Author: adrrrrrrrian
* @Date:   2016-05-02 19:48:53
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-02 20:00:32
* @Source: https://leetcode.com/problems/find-peak-element/
*/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1){
        	return 0;
        }else{
        	if(nums[1] < nums[0]) return 0;
        	if(nums[n-1] > nums[n-2])return n-1;
        	for (int i = 1; i < n; i++) {
        		if(nums[i] > nums[i-1]&& nums[i] < nums[i+1]){
        			return i;
        		}
        	}
        }
        return 0;
    }
}