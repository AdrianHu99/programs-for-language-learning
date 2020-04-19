/*
* @Author: Qi Hu
* @Date:   2016-09-08 22:58:54
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-09-08 23:48:37
* @Source: https://leetcode.com/problems/factorial-trailing-zeroes/
*/
public class TrailingZeroes {
    public int trailingZeroes(int n) {
    	//This is from a post: https://discuss.leetcode.com/topic/6516/my-one-line-solutions-in-3-languages
    	//Because the trailing zeroes are made by 2*5, and 2 is always enough,
    	//So the question is actually to find how many 5 do we have.
    	//Some numbers have one 5 factors, some have 2 (25) and some have 3 (125). 
    	//So we need to count how many 5 factors from 1 to n.
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}