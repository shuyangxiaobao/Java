package K59螺旋矩阵II;


//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[][] ints = generateMatrix ( 5 );
        for (int[] arr:ints
             ) {
            for (int a:arr
                 ) {
                System.out.print (a+" ");
            }
            System.out.println ("");
        }
    }

    static public int[][] generateMatrix(int n) {
        int[][] dp = new int[n][n];
        int i = 0;
        int j = 0;
        int index = 1;
        dp[0][0] = 1;

        int direction = 1;
        while (true){

            if (direction == 1){
                if (j+1<n && dp[i][j+1]==0){
                    dp[i][j+1] = index+1;
                    index++;
                    j++;
                    continue;
                }
            }
            if (direction == 2){
                if(i+1<n && dp[i+1][j]==0){
                    dp[i+1][j] = index+1;
                    index++;
                    i++;
                    continue;
                }
            }
            if (direction == 3){
                if(j-1 >= 0 && dp[i][j-1]==0){
                    dp[i][j-1] = index+1;
                    index++;
                    j--;
                    continue;
                }
            }
            if (direction == 4){
                if(i-1 >= 0 && dp[i-1][j]==0){
                    dp[i-1][j] = index+1;
                    index++;
                    i--;
                    continue;
                }
            }


            if (j+1<n && dp[i][j+1]==0){
                dp[i][j+1] = index+1;
                index++;
                j++;
                direction = 1;
                continue;
            } else if(i+1<n && dp[i+1][j]==0){
                dp[i+1][j] = index+1;
                index++;
                i++;
                direction = 2;
                continue;
            } else if(j-1 >= 0 && dp[i][j-1]==0){
                dp[i][j-1] = index+1;
                index++;
                j--;
                direction = 3;
                continue;
            }else if(i-1 >= 0 && dp[i-1][j]==0){
                dp[i-1][j] = index+1;
                index++;
                i--;
                direction = 4;
                continue;
            }
            break;
        }
        return dp;
    }




}