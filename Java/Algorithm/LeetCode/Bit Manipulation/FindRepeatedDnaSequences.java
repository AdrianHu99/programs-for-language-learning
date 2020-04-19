import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* @Author: adrianhu
* @Date:   2016-05-31 09:15:28
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-05-31 09:22:54
* @Source: https://leetcode.com/problems/repeated-dna-sequences/
*/
public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<String>();
        Set<String> duplicate = new HashSet<String>();
        for (int i = 0; i < s.length() - 9; i ++) {
        	String test = s.substring(i, i+10);
        	if(!seen.add(test)){
        		duplicate.add(test);
        	}
        }
        return new ArrayList(duplicate);
    }
}