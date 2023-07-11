class Solution {
    public int maxProfit(int[] arr) {
      int min = Integer.MAX_VALUE;
      int profit = 0;
      int temp_profit = 0;
      for(int i = 0 ; i < arr.length ; i++){
          if(min > arr[i]){
              min = arr[i];
          }
          temp_profit = arr[i] - min;
          if(temp_profit > profit){
              profit = temp_profit;
          }

      }
      return profit;
    }
}