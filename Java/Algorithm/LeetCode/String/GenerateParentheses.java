import java.util.ArrayList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-31 17:33:31
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-31 17:51:06
* @Source: https://leetcode.com/problems/generate-parentheses/
*/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        int left = n;
        int right = 0;
        generate(ans, "",left, right);
        return ans;
    }
    public void generate(List<String> ans, String a, int left, int right){
    	if(left ==0&&right==0){
    		ans.add(a);
    		return;
    	}
    	else{
    		if(left>0)generate(ans, a+"(", left-1,right+1);
    		if(right>0)generate(ans, a+")", left, right-1);
    	}
    	return;
    }
}