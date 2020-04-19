/*
* @Author: adrrrrrrrian
* @Date:   2016-05-14 11:14:06
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-14 11:40:05
* @Source: https://leetcode.com/problems/plus-one/
*/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int s = digits.length;
        int i = s-1;
        while(i >=0){

        		if(digits[i] + 1 == 10){
	        		digits[i] = 0;
	        	}else{
	        		//if it is like that, the program can end here, as there will not be any changes
	        		digits[i] = digits[i] + 1;
	        		return digits;
	        	}
        	
        	i--;
        }
        // it must be like 9999999..., so we only need to set the first as 1.
        	int[] ans = new int[s+1];
        	ans[0] = 1;
        	return ans;
    }
}