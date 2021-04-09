package K63股票的最大利润;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] dp = new int[length];
        dp[length - 1] = prices[length-1];
        for (int i = length-2; i >= 0; i--) {
            dp[i] = Math.max ( dp[i+1],prices[i] );
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
           max = Math.max ( dp[i]-prices[i],max );
        }
        return max;
    }





}