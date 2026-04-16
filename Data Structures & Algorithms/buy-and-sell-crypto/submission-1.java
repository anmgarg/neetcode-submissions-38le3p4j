class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;

        for (int j=1; j<prices.length; j++) {
            if(prices[j] > prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            } else {
                i = j;
            }
        }
        return maxProfit;
    }
}
