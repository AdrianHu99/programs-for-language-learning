/*
* @Author: adrrrrrrrian
* @Date:   2016-04-22 10:40:25
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-25 20:12:54
* @Source: https://leetcode.com/problems/add-binary/
*/
public class AddBinaryOfTwoStrings {
    public String addBinary(String a, String b) {
        int flag = 0;
        if(a.length() == 0)return b;
        if(b.length() == 0)return a;
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int n = c1.length;
        int m = c2.length;
        StringBuffer s = new StringBuffer();
        while (n>=1||m>=1) {
        	int sum = flag;
        	if(n>=1)sum +=c1[--n]-'0';
        	if(m>=1)sum +=c2[--m]-'0';
        	s.insert(0,sum%2);
        	flag = sum/2;
        }
        if(flag == 1)s.insert(0,1);
        return s.toString();
    }
}