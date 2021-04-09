package K剑指Offer47礼物的最大价值;


//
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2 ();
//        solution.

    }

//    动态规划（一维数组）
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        int sum = 0;
        for (int i = 0; i < col; i++) {
            sum += grid[0][i];
            dp[i] = sum;
        }
        for (int i = 1; i < row; i++) {
            dp[0] = dp[0]+grid[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.max ( dp[j-1],dp[j]) + grid[i][j];
            }
        }
        return dp[col-1];
    }




}