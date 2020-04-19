/*
* @Author: adrianhu
* @Date:   2016-03-18 13:46:55
* @Last Modified by:   adrianhu
* @Last Modified time: 2016-03-18 13:47:15
* @Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int maxi = 0;
        for(int i = 0;i < prices.length;i++){
            mini = Math.min(mini,prices[i]);
            maxi = Math.max(maxi,prices[i]-mini);
        }
        return maxi;
        
    }
}