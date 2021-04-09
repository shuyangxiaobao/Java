package K118杨辉三角;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }

//    递归
    public List<List<Integer>> generate2(int numRows) {
        if (numRows == 1){
            ArrayList<List<Integer>> lists = new ArrayList<> ();
            ArrayList<Integer> list = new ArrayList<> ();
            list.add ( 1 );
            lists.add ( list );
            return lists;
        }

        List<List<Integer>> lists = generate2 ( numRows - 1 );
        List<Integer> list = lists.get ( lists.size () - 1 );

        ArrayList<Integer> listEnd = new ArrayList<> ();
        listEnd.add ( 1 );
        for (int i = 0; i < list.size ()-1; i++) {
            listEnd.add ( list.get ( i ) +list.get ( i+1 ));
        }
        listEnd.add ( 1 );
        lists.add ( listEnd );
        return lists;
    }


//    动态规划
    public List<List<Integer>> generate(int numRows) {

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
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<> ();
            for (int j = 0; j <= i; j++) {
                list.add ( dp[i][j] );
            }
            lists.add ( list );
        }
        return lists;
    }







}