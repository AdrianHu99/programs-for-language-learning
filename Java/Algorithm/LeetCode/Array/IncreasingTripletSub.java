/*
* @Author: adrrrrrrrian
* @Date:   2016-03-16 15:50:02
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-16 15:50:28
* @Source: https://leetcode.com/problems/increasing-triplet-subsequence/
*/
public class IncreasingTripletSub {
    public boolean increasingTriplet(int[] nums) {
        int flag = 0;
        int i = 0;
        while(i < nums.length){
            int a = nums[i];
            int j = i+1;
            while(j < nums.length){
                if(nums[j] > a){
                        if(findbig(nums,j))return true;
                        else{
                            j++;
                            continue;
                        }
                }
                j++;
            }
            i++;
        }
        return false;
    }
    public boolean findbig(int[] nums, int i){
        for(int j = i; j < nums.length;j++){
            if(nums[j] > nums[i])return true;
        }
        return false;
    }
}