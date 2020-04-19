/*
* @Author: adrrrrrrrian
* @Date:   2016-05-13 09:54:39
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-13 09:54:57
* @Source: https://leetcode.com/problems/valid-anagram/
*/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] num = new int[26];
        for(int i = 0;i<s.length(); i++){
            num[s.charAt(i) - 'a']++;
            num[t.charAt(i) - 'a']--;
        }
        for(int j : num){
            if(j != 0){
                return false;
            }
        }
        return true;
        
    }
}