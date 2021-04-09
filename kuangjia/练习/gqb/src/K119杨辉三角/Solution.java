package K119杨辉三角;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }

//动态规划
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex+1;
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;

        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows; j++) {
                dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
            }
        }
        ArrayList<Integer> lists = new ArrayList<> ();
        for (int i = 0; i <numRows ; i++) {
            lists.add ( dp[numRows-1][i] );

        }
        return lists;
    }





}