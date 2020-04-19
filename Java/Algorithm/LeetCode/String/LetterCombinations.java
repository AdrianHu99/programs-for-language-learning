import java.util.LinkedList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-22 08:59:19
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-22 09:40:25
* @Source: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.length() == 0)return ans;
        //first add an element with length = 0
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
        	//get the numeric value from the digits
        	int a = Character.getNumericValue(digits.charAt(i));
        	while (ans.peek().length() == i) {
        		String s = ans.remove();
        		for (char c : map[a].toCharArray()) {
        			//put the first removed element to the last with the new letter
        			ans.add(s+c);
        		}
        	}
        }
        return ans;
    }
}