/*
* @Author: adrrrrrrrian
* @Date:   2016-05-16 20:47:45
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-16 21:04:51
* @Source: https://leetcode.com/problems/zigzag-conversion/
*/
public class ConvertZigZag {
    public String convert(String s, int numRows) {
    	char[] c = s.toCharArray();
        int l = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i ++) {
        	sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < l) {
        	for (int j = 0; j < numRows && i < l; j++) {
        		sb[j].append(c[i++]);
        	}
        	for (int j = numRows-2; j >=1&&i < l; j--) {
        		sb[j].append(c[i++]);
        	}
        }
        for (int j = 1; j < numRows; j++) {
        	sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}