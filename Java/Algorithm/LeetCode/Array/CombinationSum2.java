import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-12 11:05:13
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-12 11:06:32
* @Source: https://leetcode.com/problems/combination-sum-ii/
*/
public class CombinationSum2 {
    public List<List<Integer>> combination(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> small = new ArrayList<Integer>();
        calculate(candidates, target, ans, small, 0);
        return ans;
    }
    public void calculate(int[] candidates, int target, List<List<Integer>> ans, List<Integer> small, int begin){
        if(target == 0){
            ans.add(new ArrayList(small));
            return;
        }else if(target< 0){
            return;
        }else{
            int l = candidates.length;
            int i = begin;
            while(i < l){
                if(i > begin && candidates[i-1] == candidates[i]){
                    i++;
                    continue;
                }
                small.add(candidates[i]);
                calculate(candidates, target - candidates[i], ans, small, i+1);
                small.remove(small.size() -1);
                i++;
            }
        }
    }
}