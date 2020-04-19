import java.util.HashMap;

/*
* @Author: Qi Hu
* @Date:   2016-09-07 10:21:05
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-09-07 10:31:32
* @Source: https://leetcode.com/problems/first-unique-character-in-a-string/
*/
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
        int l = s.length();

        for (int i = 0; i < l; i++) {
        	char c = s.charAt(i);
        	//Store the character with its index
        	if (!hm.containsKey(c)) {
        		hm.put(c,i);
        	}
        	//If there is a duplicate, change the value to l
        	else {
        		hm.put(c,l);
        	}
        }

        for (int i = 0; i < l; i++) {
        	//If the value is not l, then the value will be the location
        	if (hm.containsValue(i)) {
        		return i;
        	}
        }
        return -1;
    }
}