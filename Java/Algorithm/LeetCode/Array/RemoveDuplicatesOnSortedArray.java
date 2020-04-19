/*
* @Author: adrianhu
* @Date:   2016-03-22 14:47:17
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-22 14:59:48
* @Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/

public class RemoveDuplicatesOnSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <2)return n;
        int realpt = 0;
        int oldpt = 0;
        nums[realpt] = nums[oldpt];
        while (oldpt < n-1) {
        	if(nums[oldpt]!=nums[oldpt+1]){
        		realpt++;
        		oldpt++;
        		nums[realpt] = nums[oldpt];
        	}else{
        		oldpt++;
        	}
        }
        return realpt+1;
    }
}