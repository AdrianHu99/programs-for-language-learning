/*
* @Author: adrrrrrrrian
* @Date:   2016-05-02 20:33:39
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-02 20:34:12
* @Source: https://leetcode.com/problems/find-peak-element/
*/
public class FindPeakElementUsingRecursion {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return binary(nums, 0, n-1);
    }
    public int binary(int[] nums, int left, int right){
        if(left == right){
            return left;
        }else{
            int mid = (left+right)/2;
            if(nums[mid] > nums[mid+1]){
                return binary(nums, left, mid);
            }else{
                return binary(nums, mid+1,right);
            }
        }
    }
}