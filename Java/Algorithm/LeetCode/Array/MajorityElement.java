/*
* @Author: adrrrrrrrian
* @Date:   2016-05-12 09:59:22
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-12 10:11:50
* @Source: https://leetcode.com/problems/majority-element/
*/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int a = nums[0];
        for (int i = 1; i < n; i++) {
        	if(count == 0){
        		count++;
        		a = nums[i];
        	}else if(nums[i] == a){
        		count++;
        	}else{
        		count--;
        	}
        }
        return a;
    }
}