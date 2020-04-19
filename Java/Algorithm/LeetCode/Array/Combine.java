import java.util.ArrayList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-06-06 23:14:32
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-06-08 21:30:17
* @Source: https://leetcode.com/problems/combinations/
*/
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        comb(1,n,k,ans, new ArrayList<Integer>());
        return ans;
    }

    public void comb(int start, int n, int k, List<List<Integer>> a, List<Integer> b){
    	if (k == 0) {
    		a.add(new ArrayList<Integer>(b));
    		return;
    	}
    	for (int i = start; i <= n; i++) {
    		b.add(i);
    		comb(i+1, n, k-1, a,b);
    		b.remove(b.size()-1);
    	}
    }
}