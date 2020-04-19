/*
* @Author: adrrrrrrrian
* @Date:   2016-04-26 21:22:50
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-26 21:31:20
* @Source: https://leetcode.com/problems/reverse-vowels-of-a-string/
*/
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length -1;
        while (i < j) {
        	while (i<=j&&!isVowel(c[i])) {
        		i++;
        	}
        	while (j>=i&&!isVowel(c[j])) {
        		j--;
        	}
        	if(i < j){
        		char a = c[i];
        		c[i] = c[j];
        		c[j] = a;
        	}
        	i++;
        	j--;
        }
        String ans = new String(c);
        return ans;
    }

    public boolean isVowel(char c ){
    	return c == 'a'||c=='e'||c=='i'||c=='o'||c=='u'||c == 'A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}