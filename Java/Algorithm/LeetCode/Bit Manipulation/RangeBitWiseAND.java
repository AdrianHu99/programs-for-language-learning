/*
* @Author: adrianhu
* @Date:   2016-05-31 08:52:02
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-05-31 09:08:15
* @Source: https://leetcode.com/problems/bitwise-and-of-numbers-range/
*/
public class RangeBitWiseAND {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
        	return 0;
        }
        int factor = 1;
        while (m != n) {
        	m >>= 1;
        	n >>= 1;
        	factor <<= 1;
        }
        return m * factor;

    }
}