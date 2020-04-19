/*
* @Author: adrrrrrrrian
* @Date:   2016-04-09 10:12:11
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-09 10:23:18
* @Source: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/
public class FindMin {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while(s < e){
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