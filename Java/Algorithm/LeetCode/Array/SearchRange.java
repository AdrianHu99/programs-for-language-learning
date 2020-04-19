/*
* @Author: adrrrrrrrian
* @Date:   2016-04-28 15:52:05
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-02 21:58:22
* @Source: https://leetcode.com/problems/search-for-a-range/
*/
public class SearchRange {
    public int[] SearchRange(int[] nums, int target) {
        int n = nums.length;
        int s = binary(nums, 0, n-1, target);
        // it could not be target, or target is larger than the largest element in nums which wil return n;
        if(nums[s] != target || s == n)return new int[]{-1,-1};
        return new int[]{s, binary(nums,0,n,target+1)-1};
        
    }
    //find the location of the first element which is equal or greater than target;
    public int binary(int[] nums, int l, int r, int target){
    	while(l < r){
    		int mid = (l+r)/2;
    		if(nums[mid] < target){
    			l = mid+1;
    		}else {
    			r = mid;
    		}
    	}
    	return l;
    	/*if(l == r)return l;
    	int mid = (l+r)/2;
    	if(nums[mid] > target){
    		return binary(nums, l, mid-1,target);
    	}else if(nums[mid] < target){
    		return binary(nums,mid+1,r,target);
    	}else {
    		int i = mid;
    		while(nums[i] != target){
    			i--;
    		}
    		return i+1;
    	}*/
    }
}