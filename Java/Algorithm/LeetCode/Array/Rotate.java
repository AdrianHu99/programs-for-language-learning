import java.util.Arrays;

/*
* @Author: adrrrrrrrian
* @Date:   2016-05-17 16:04:02
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-17 16:45:51
* @Source: https://leetcode.com/problems/rotate-array/
*/
class RotateArray {
    public void rotate(int[] nums, int k) {
    	
    	int l = nums.length;
    	if(k>=l)k = k%l;
    	if(k == 0||l==1)return;
        int[] a = Arrays.copyOfRange(nums, l-k, l+1);
        int[] b = Arrays.copyOfRange(nums, 0, l-k);
        for (int i = 0; i < a.length ; i++) {
        	nums[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
        	nums[i+a.length-1] = b[i];
        }
    }
}