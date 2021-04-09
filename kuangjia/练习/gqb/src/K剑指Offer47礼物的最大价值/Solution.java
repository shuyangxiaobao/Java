package K剑指Offer47礼物的最大价值;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

//    动态规划（二维数组）
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        int sum = 0;
        for (int i = 0; i < col; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < row; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max ( dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }



}