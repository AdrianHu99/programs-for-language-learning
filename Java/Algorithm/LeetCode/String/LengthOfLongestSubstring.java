import java.util.HashSet;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-21 17:08:40
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-21 17:18:15
* @Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<Character>();
        int n = s.length();
        int max = 0;
        for(int i = 0; i < n; i++){
        	char c = s.charAt(i);
        	int j = i;
        	int an = 0;
        	while(j < n&&hash.add(c)){
        		j++;
        		an++;
        		c = s.charAt(j);
        	}
        	max = Math.max(max, an);
        	hash.clear();
        }
        return 0;
    }
}