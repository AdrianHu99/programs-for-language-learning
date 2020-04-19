/*
* @Author: Qi Hu
* @Date:   2016-07-11 19:18:12
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-07-11 20:14:55
* @Source: https://leetcode.com/problems/power-of-four/
*/
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
    	if (num == 1) {
    		return true;
    	}
        while (num !=0) {
        	if (num == (num >> 2) *4) {
        		//we cannot directly move num because sometimes the two bits have values.
        		num = num >> 2;
	        	if (num == 1) {
	        		return true;
	        	}
        	}else {
        		return false;
        	}
        }
        return false;
    }
}

