import java.util.ArrayList;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-20 08:18:02
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-20 09:28:33
* @Source: https://leetcode.com/problems/count-and-say/
*/
public class CountAndSay {


	public String countAndSay(int n){
		if(n <= 1)return "1";
		else{
			StringBuffer s = new StringBuffer("1");
			for (int i = 2; i <= n; i++) {
				ArrayList<Character> a = new ArrayList<Character>();
				char c = s.charAt(0);
		        int count = 1;
		        for (int j = 1; j < s.length(); j++) {
		        	if(c == s.charAt(j)){
		        		count++;
		        	}else {
		        		char ch = Integer.toString(count).charAt(0);
		        		a.add(ch);
		        		a.add(c);
		        		c = s.charAt(j);
		        		count = 1;
		        	}
		        }
		        char ch = Integer.toString(count).charAt(0);
		        a.add(ch);
		        a.add(c);
		        s = new StringBuffer(a.size());
		    	for(Character cha: a){
				   s.append(cha);
				}
			}
			return s.toString();
		}
		
	}
}