import java.util.Set;

/*
* @Author: adrrrrrrrian
* @Date:   2016-06-05 16:22:59
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-06-05 16:30:42
* @Source: https://leetcode.com/problems/word-ladder/
*/
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        return 0;
    }


    public int transform(String a, String b){
    	int l = a.length();
    	int ans = 0;
    	for (int i = 0; i < l; i++) {
    		if(a.charAt(i) != b.charAt(i)){
    			ans++;
    		}
    	}
    	return ans;
    }

    public String find(String a, Set<String> wordList){
    	for(String s: wordList){
    		int d = transform(a, s);
    		if(d <= 1){
    			return s;
    		}else{
    			return null;
    		}
    	}
    	return null;
    }
}