/*
* @Author: adrian
* @Date:   2016-07-11 20:21:32
* @Last Modified by:   adrian
* @Last Modified time: 2016-07-11 20:37:58
* @Source: https://leetcode.com/problems/sum-of-two-integers/
*/
public class GetSum {
    public int getSum(int a, int b) {
        if (a == 0) {
        	return b;
        }
        if (b == 0) {
        	return a;
        }
        while (b != 0) {
        	int c = a&b;
        	a = a^b;
        	b = c<<1;
        }
        return a;
    }
}