package K289生命游戏;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gameOfLife ( board,i,j,dp );
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = dp[i][j];
            }
        }
    }

    public void gameOfLife(int[][] board,int a ,int b,int[][] dp) {
        int count = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i = a-1; i <= a+1; i++) {
            for (int j = b-1; j <= b+1 ; j++) {
                if (i >= 0 && i < row && j >= 0 && j < col){
                    if (board[i][j] == 1){
                        count++;
                    }
                }
            }
        }
        if (board[a][b] == 1){
            count--;
        }
        System.out.println (count);
        if (board[a][b] == 1){
            if (count < 2){
                dp[a][b] = 0;
            } else if (count < 4){
                dp[a][b] = 1;
            } else {
                dp[a][b] = 0;
            }
        } else {
            if (count == 3) {
                dp[a][b] = 1;
            }
        }
    }
}