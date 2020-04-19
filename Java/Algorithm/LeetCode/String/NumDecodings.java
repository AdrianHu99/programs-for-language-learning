/*
* @Author: adrrrrrrrian
* @Date:   2016-05-15 10:24:31
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-16 13:53:54
* @Source: https://leetcode.com/problems/decode-ways/
*/
public class NumDecodings {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.length() == 0) {
        	return 0;
        }else{
        	//start from the last element because '0'   
        	int[] ans = new int[n+1];
        	ans[n] = 1;
            ans[n-1] = s.charAt(n-1) != '0' ? 1:0;
            for (int i = n-2; i >=0; i--) {
                if(s.charAt(i) == '0') continue;
                else ans[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? ans[i+1]+ans[i+2] : ans[i+1];
            }
        	return ans[0];
        }
    }
}