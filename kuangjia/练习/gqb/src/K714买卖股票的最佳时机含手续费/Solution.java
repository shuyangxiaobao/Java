package K714买卖股票的最佳时机含手续费;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int buy = -prices[0];
        int sell = 0;
        for (int i = 0; i < length; i++) {
            buy = Math.max ( buy,sell-prices[i] );
            sell = Math.max ( sell,buy+prices[i]-fee );
        }
        return sell;
    }




}