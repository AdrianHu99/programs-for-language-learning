import java.util.ArrayList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-05-12 10:19:58
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-12 10:45:01
* @Source: https://leetcode.com/problems/majority-element-ii/
*/
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int n = nums.length;
        if(n==0)return ans;
        //we can't set count1 and count2 as 1 as we now need to count 2 numbers, count1 and count2 may be same as the nums[1] == nums[0];
        int count1 = 0;
        int count2 = 0;
        int a1= 0;
        int a2= 0;
        for (int i = 2; i < n; i ++) {
        	if(nums[i] == a1){
        		count1++;
        	}else if (nums[i] == a2) {
        		count2++;
        	}else if (count1 == 0) {
        		count1++;
        		a1 = nums[i];
        	}else if (count2 == 0) {
        		count2++;
        		a2 = nums[i];
        	}else {
        		count1--;
        		count2--;
        	}
        }
        //we now have the right a1 and a2, but we need to calculate the right numbers of a1 and a2 as the result from last for loop is not accurate.
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == a1)count1++;
            if(nums[i] == a2)count2++;
        }
        if(count1 > n/3){
        	ans.add(a1);
        }
        //a2 should not be equal to a1
        if(a2!=a1&&count2>n/3){
        	ans.add(a2);
        }
        return ans;
    }
}