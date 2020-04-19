/*
* @Author: adrrrrrrrian
* @Date:   2016-06-15 18:04:13
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-06-15 18:11:58
* @Source: https://leetcode.com/problems/implement-strstr/
*/
public class StrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ;i++ ) {
        	for (int j = 0; ;j++ ) {
        		if (j == needle.length()) {
        			return i;
        		}
        		if (i+j == haystack.length()) {
        			return -1;
        		}
        		if (haystack.charAt(i+j) != needle.charAt(j)) {
        			break;
        		}
        	}
        }
    }
}