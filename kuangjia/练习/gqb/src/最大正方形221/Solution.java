package 最大正方形221;

public class Solution {

    public static void main(String[] args) {
//        char[][] arr ={{'0'},{'1'}};
        char[][] arr ={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int minPathSum = maximalSquare2 ( arr );
        System.out.println (minPathSum);

    }

   static public int maximalSquare2(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int max = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == '1'){
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                char a = matrix[i][j];
                if (a == '1'){
                    int min = Math.min ( dp[i - 1][j], dp[i][j - 1] );
                    min = Math.min ( min, dp[i-1][j - 1] );
                    dp[i][j] = min +1;
                    max = Math.max ( max,dp[i][j]);
                }
            }
        }
        return max*max;
    }

}









