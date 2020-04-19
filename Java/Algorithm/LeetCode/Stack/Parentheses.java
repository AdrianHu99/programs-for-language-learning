import java.util.Stack;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-12 09:27:51
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-12 11:12:48
* Source: https://leetcode.com/problems/valid-parentheses/
*/
public class Parentheses {
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack<Character>();
        int l = s.length();
        if(l % 2 == 1)return false;
        for(int i = 0; i< l-1; i++){
            char c = s.charAt(i);
            if(c == '('){
                if(s.charAt(i+1) != ')')return false;
                else i++;
            }else if (c == '{'){
                if(s.charAt(i+1) != '}')return false;
                else i++;
            }else if(c == '['){
                if(s.charAt(i+1) != ']')return false;
                else i++;
            }
        }
        return true;
    }
}