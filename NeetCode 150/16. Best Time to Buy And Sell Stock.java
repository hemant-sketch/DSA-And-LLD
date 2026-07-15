class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int buy = prices[0];

        for(int idx = 1; idx < prices.length; idx++) {
            if(buy < prices[idx]){
                int profit = prices[idx] - buy;
                maxProfit = Math.max(profit, maxProfit);
            }else{
                buy = prices[idx];
            }
        }

        if(maxProfit == Integer.MIN_VALUE){
            return 0;
        }else{
            return maxProfit;
        }
    }
}
