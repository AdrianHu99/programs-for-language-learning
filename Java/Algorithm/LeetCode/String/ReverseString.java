/*
* @Author: adrrrrrrrian
* @Date:   2016-05-13 08:32:56
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-13 08:37:34
* @Source: https://leetcode.com/problems/reverse-string/
*/
public class ReverseString {
    public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}