class Solution {
    public int maxProfit(int[] arr) {
        int profit1 = 0;
        int profit2 = 0;
        int min_price1 = Integer.MAX_VALUE;
        int min_price2 = Integer.MAX_VALUE;
        for(int i = 0 ; i <arr.length ; i++){
            min_price1 = Math.min(min_price1, arr[i]);
            profit1 = Math.max(profit1, arr[i]-min_price1);
            min_price2 = Math.min(min_price2, arr[i] - profit1);
            profit2 = Math.max(profit2, arr[i]-min_price2);
        }
        return profit2;
    }
}