import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-05-13 10:15:07
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-13 10:36:31
* @Source: https://leetcode.com/problems/anagrams/
*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if(strs == null||strs.length == 0)return new ArrayList<List<String>>();
        //this is a very important step! So that you don't need to worry about the sort stuff!!!
        Arrays.sort(strs);
        for (String s: strs ) {
        	//use sorted string as the key to hashmap
        	char[] c = s.toCharArray();
        	Arrays.sort(c);
        	String key = String.valueOf(c);
        	if(!map.containsKey(key))map.put(key, new ArrayList<String>());
        	map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}