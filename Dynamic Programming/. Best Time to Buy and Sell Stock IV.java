class Solution {
   static  int [][][]dp;
    public int maxProfit(int k, int[] prices) {
        dp  = new int [k+1][2][prices.length+1];
        return helper(k, prices, 0, 0);
    }
    static int helper(int k, int []prices, int buy, int index) {
        if(k==0 || index == prices.length){
            return 0;
        }
        if(dp[k][buy][index]!=0){
            return dp[k][buy][index];
        }
        int profit = 0;
        if(buy == 0){
            profit = Math.max(0+helper(k, prices, 0, index+1), -prices[index]+helper(k, prices, 1, index+1));
        }
        if(buy == 1){
            profit = Math.max(0+helper(k, prices, 1, index+1), prices[index]+helper(k-1, prices, 0, index+1));
        }
        return dp[k][buy][index] = profit;
    }
}