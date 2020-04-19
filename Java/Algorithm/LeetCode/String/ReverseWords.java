import java.util.Arrays;
import java.util.Collections;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-26 21:34:09
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-26 21:59:09
* @Source: https://leetcode.com/problems/reverse-words-in-a-string/
*/
public class ReverseWords {
    public String reverseWords(String s) {
    	//" +" stands for multiple spaces
        String[] words = s.trim().split(" +");
    	Collections.reverse(Arrays.asList(words));
    	return String.join(" ", words);
    }
}