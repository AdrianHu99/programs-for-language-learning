/*
* @Author: adrrrrrrrian
* @Date:   2016-04-09 10:39:36
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-09 10:43:48
* @Source: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
*/

public class FindMin2 {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while(s < e){
            while(s < e && nums[s] == nums[e]){
                e--;
            }
        	if(nums[s] < nums[e]){
        		return nums[s];
        	}
        	int mid = (s+e)/2;
            
        	if(nums[mid] >= nums[s]){// why these two can be equal? try [2,1], the mid is actually s so that they are equal and we need to move...
        		s = mid + 1;
        	}else{
        		e = mid;
        	}
        }
        return nums[s];
    }
}