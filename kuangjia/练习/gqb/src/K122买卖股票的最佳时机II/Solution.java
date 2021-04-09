package K122买卖股票的最佳时机II;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public int maxProfit(int[] prices) {
        int length = prices.length;
        int result = 0;
        for (int i = 1; i < length; i++) {
           if (prices[i] > prices[i-1]) {
               result += (prices[i] - prices[i - 1]);
           }
        }
        return result;
    }





}