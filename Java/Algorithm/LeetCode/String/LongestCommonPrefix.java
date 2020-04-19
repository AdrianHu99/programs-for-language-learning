/*
* @Author: adrrrrrrrian
* @Date:   2016-04-22 09:40:46
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-22 10:15:32
* @Source: https://leetcode.com/problems/longest-common-prefix/
*/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return "";
        else if (strs.length == 1) {
        	return strs[0];
        }
        else {
        	String s1 = strs[0];
        	String s2 = strs[1];
        	int l = s1.length()>=s2.length()?s2.length():s1.length();
        	StringBuffer s = new StringBuffer();
        	//find the common prefix between the first two strings
        	for (int i = 0; i < l; i++) {
        		if(s1.charAt(i) == s2.charAt(i)){
        			s.append(s1.charAt(i));
        		}else {
        			break;
        		}
        	}
        	//see if s is also the beginning of other strings
        	for (int i = 2; i < strs.length; i++) {
        		if(strs[i].length() == 0)return "";
        		int len = s.length() >=strs[i].length()?strs[i].length():s.length();
        		if(s.length()>len)s.delete(len,s.length());
        		for(int j = 0; j < len;j++){
        			if (s.charAt(j) != strs[i].charAt(j)) {
        				s.delete(j,s.length());
        				break;
        			}
        		}
        	}
        	return s.toString();
        }
    }
}