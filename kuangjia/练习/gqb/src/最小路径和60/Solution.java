package 最小路径和60;

public class Solution {

    public static void main(String[] args) {
        int[][] arr ={{1,3,1},{1,5,1},{4,2,1}};
        int minPathSum = minPathSum ( arr );
        System.out.println (minPathSum);

    }


  static   public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        int sum = 0;
        for (int i = 0; i < column; i++) {
            sum+=grid[0][i];
            dp[0][i] = sum;
        }

        sum = 0;
        for (int i = 0; i < row; i++) {
            sum+=grid[i][0];
            dp[i][0] = sum;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
               dp[i][j] = Math.min ( dp[i-1][j],dp[i][j-1] )+grid[i][j];
            }
        }
        return dp[row-1][column-1];
    }
    

}









