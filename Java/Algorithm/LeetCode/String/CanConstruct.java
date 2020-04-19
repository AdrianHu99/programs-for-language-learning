import java.util.HashMap;

/*
* @Author: Qi Hu
* @Date:   2016-09-07 09:55:11
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-09-07 10:14:20
* @Source: https://leetcode.com/problems/ransom-note/
*/
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        //The idea is to use hashmap store the character and how many it shows
        //Up in the ransomeNote, and then compare it to magazine. 
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int l = ransomNote.length();
        int count = 0;

        for (int i = 0; i < l; i++) {
        	char c = ransomNote.charAt(i);
        	if (!hm.containsKey(c)) {
        		hm.put(c,1);
        		//Count how many different letters
        		count++;
        	}else {
        		hm.put(c,hm.get(c)+1);
        	}
        }

        int m = magazine.length();
        //Compare hashmap to the characters in magazine
        for (int i = 0; i < m; i++) {
        	char c = magazine.charAt(i);
        	if (hm.containsKey(c)) {
        		hm.put(c,hm.get(c)-1);
        		//If hm.get(c) is 0, that means magazine 
        		//has the letter and has larger or equal numbers of it than ransomNote.
        		if (hm.get(c) == 0) {
        			count--;
        		}
        	}
        }

        if (count == 0) {
        	return true;
        }else {
        	return false;
        }
    }
}