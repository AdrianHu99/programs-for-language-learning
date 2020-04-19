/*
* @Author: adrrrrrrrian
* @Date:   2016-04-08 14:33:40
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-08 17:02:54
* @Source: https://leetcode.com/problems/container-with-most-water/?sort=hot
*/
public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int max = 0;
        while(l < r){
            int n = Math.min(height[l],height[r])*(r-l);
            max = max > n ? max : n;
            if(height[l] < height[r])l++;
            else r--;
        }
        return max;
    }
}