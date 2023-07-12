class Solution {
    static int [][]dp;
    public int maxProfit(int[] prices) {
        dp = new int [2][prices.length];
        return helper(prices, 0, 0);
    }
    static int helper(int []prices, int index, int buy){
        if(index >= prices.length){
            return 0;
        }
        if(dp[buy][index]!=0){
            return dp[buy][index];
        }
        int profit = 0;
        if(buy == 0){
            profit = Math.max(0+helper(prices, index+1, 0), -prices[index]+helper(prices, index+1, 1));
        }
        if(buy == 1){
            profit = Math.max(0+helper(prices, index+1, 1), prices[index]+helper(prices, index+2, 0));
        }
        return dp[buy][index] = profit;
    }
}