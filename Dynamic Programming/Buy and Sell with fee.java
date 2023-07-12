class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0, effectbuy = prices[0];
        for(int i = 0 ;i < prices.length ; i++){
            profit = Math.max(profit, prices[i]-effectbuy- fee);
            effectbuy = Math.min(effectbuy, prices[i] -  profit);
        }
        return profit;
    }
}