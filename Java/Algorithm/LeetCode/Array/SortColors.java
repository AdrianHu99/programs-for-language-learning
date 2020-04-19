/*
* @Author: adrrrrrrrian
* @Date:   2016-03-23 20:20:00
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-23 20:46:34
* @Source: https://leetcode.com/problems/sort-colors/
*/
public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0;
        int zero = 0; int two = nums.length - 1;
        while (i < nums.length) {
        	while(nums[i] == 0&&i > zero){
        		swap(nums, zero++, i);
        	}
        	while (nums[i] == 2&& i < two) {
        		swap(nums, two-- ,i );
        	}
        	while(nums[i] == 0&&i > zero){// make sure that after swap 2, it is not 0
        		swap(nums, zero++, i);
        	}
        	i++;
        }
    }
    public void swap(int[] nums, int a , int b){
    	int c = nums[a];
    	int d = nums[b];
    	nums[a] = d;
    	nums[b] = c;
    }
}