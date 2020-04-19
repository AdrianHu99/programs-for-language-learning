import java.util.ArrayList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-06-02 22:44:11
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-06-02 22:57:56
* @Source: https://leetcode.com/problems/pascals-triangle/
*/
public class GeneratePascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> a = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(numRows == 0)return ans;
        a.add(1);
        ans.add(a);
        for (int i = 0; i < numRows; i++) {
        	List<Integer> b = new ArrayList<Integer>();
        	b.add(1);
        	for (int j = 0; j < a.size()-1; j++) {
        		b.add(a.get(j)+a.get(j+1));
        	}
        	b.add(1);
        	ans.add(b);
        	a = b;
        }
        ans.remove(ans.size() - 1);
        return ans;
    }
}