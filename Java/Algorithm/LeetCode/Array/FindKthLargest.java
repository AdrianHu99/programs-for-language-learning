/*
* @Author: adrrrrrrrian
* @Date:   2016-04-18 19:45:04
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-18 20:02:08
* @Source: https://leetcode.com/problems/kth-largest-element-in-an-array/
*/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
        	return Integer.MAX_VALUE;
        }
        return quicksort(nums, 0,n-1,n-k);
    }

    //quick sort: put numbers smaller than pivot into left, larger than pivot into right
    public int quicksort(int[] nums, int lo, int hi, int key){
    	if(lo > hi)return Integer.MAX_VALUE;
    	//set pivot as nums[hi]
    	int pivot = nums[hi];
    	int l = lo;
    	for (int i = lo; i < hi;i++ ) {
    		if(nums[i] < pivot){
    			//put all small number into left part
    			swap(nums, i, l++);
    		}
    	}
    	// put pivot to the place l;
    	swap(nums, l, hi);
    	if(l == key)return nums[l];
    	else if(l < key)return quicksort(nums, l+1, hi, key);
    	else return quicksort(nums, lo, l-1, key);
    }
    public void swap(int[] nums, int a, int b){
    	int me = nums[a];
    	nums[a] = nums[b];
    	nums[b] = me;
    }
}