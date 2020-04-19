import java.util.ArrayList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-18 14:19:25
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-18 14:19:48
* Source: https://leetcode.com/problems/combination-sum-iii/
*/
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[9];
        for(int i = 0;i < 9; i++){
            candidates[i] = i+1;
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> small = new ArrayList<Integer>();
        calculate(candidates, n, ans, small, 0,k);
        return ans;
    }
    public void calculate(int[] candidates, int target, List<List<Integer>> ans, List<Integer> small, int begin,int k){
    	if(target == 0&&k==0){
    	    ans.add(new ArrayList(small));
    	    return;
    	}else if(target< 0||k==0){
    	    return;
    	}else{
    	    int l = candidates.length;
    	    int i = begin;
    		while(i < l){
    			small.add(candidates[i]);
    			int jj = k-1;
    			calculate(candidates, target - candidates[i], ans, small, i+1,jj);
    			small.remove(small.size() -1);
    			i++;
    		}
    	}
    }
}