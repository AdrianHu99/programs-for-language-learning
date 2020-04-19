import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-12 08:48:47
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-12 11:07:45
* Source: https://leetcode.com/problems/combination-sum/
*/
public class CombinationSum {
    public List<List<Integer>> combination(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> small = new ArrayList<Integer>();
        calculate(candidates, target, ans, small, 0);
        return ans;
    }
    public void calculate(int[] candidates, int target, List<List<Integer>> ans, List<Integer> small, int begin){
    	int a = candidates[begin];
    	if(target < 0)return;
    	else if(0 == target)ans.add(new ArrayList(small));
    	else{
    		while(begin < candidates.length){
    			small.add(candidates[begin]);
    			calculate(candidates, target - candidates[begin], ans, small, begin);
    			small.remove(small.size() -1);
    			begin++;
    		}
    		
    	}
    }

}