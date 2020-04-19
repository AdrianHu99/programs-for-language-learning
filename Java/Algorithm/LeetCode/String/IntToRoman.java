/*
* @Author: adrrrrrrrian
* @Date:   2016-03-14 10:17:08
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-14 10:50:54
* @Source: https://leetcode.com/problems/integer-to-roman/
*/
public class IntToRoman {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}