import java.util.Arrays;

/*
* @Author: Qi Hu
* @Date:   2016-09-06 09:59:24
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-09-06 10:08:36
* @Source: https://leetcode.com/problems/find-the-difference/
*/
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] ar1 = s.toCharArray();
        char[] ar2 = t.toCharArray();
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        int l = s.length();
        int i = 0;
        while (i < l) {
        	if (ar1[i] != ar2[i]) {
        		return ar2[i];
        	}
        	i++;
        }
        return ar2[i];
    }
}