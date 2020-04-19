/*
* @Author: adrrrrrrrian
* @Date:   2016-05-13 09:15:49
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-13 09:33:42
* @Source: https://leetcode.com/problems/longest-palindromic-substring/
*/
public class LongestPalindrome {
	private int lo, max;
    public String longestPalindrome(String s) {
        int l = s.length();
        if(l < 2)return s;

        for (int i = 0;i < l;i++) {
        	isPalindrome(s, i, i);//odd
        	isPalindrome(s, i, i+1);//even
        }
        return s.substring(lo, lo+max);
    }
    public void isPalindrome(String s, int a, int b){
    	while(s.charAt(a)==s.charAt(b)&&a<=b&&a >=0&&b<s.length()){
    		a--;
    		b++;
    	}
    	if(max < b-a-1){
    		lo = a+1;
    		max = b-a-1;
    	}
    }
}