/*
* @Author: adrrrrrrrian
* @Date:   2016-03-31 17:54:38
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-31 18:03:56
* @Source: https://leetcode.com/problems/length-of-last-word/
*/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        if(a.length == 0)return 0;
        String ans = a[a.length -1];
        return ans.length();
    }
}