package K54螺旋矩阵;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{6,9,7}};
        List<Integer> list = spiralOrder ( matrix );
        System.out.println (list);
    }


   static public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<> ();
        int row = matrix.length;
        if (row == 0){
            return list;
        }
        int col = matrix[0].length;
        for (int i = 0; i < col; i++) {
            list.add ( matrix[0][i] );
        }

        for (int i = 1; i < row; i++) {
            list.add ( matrix[i][col-1] );
        }

        for (int i = col-2; i > 0 && row > 1; i--) {
            list.add ( matrix[row-1][i] );
        }

        for (int i = row-1; i > 0 && col > 1; i--) {
            list.add ( matrix[i][0] );
        }
        if (row <= 2 || col <= 2){
            return list;
        }
        int[][] dp = new int[row - 2][col - 2];
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
               dp[i-1][j-1] = matrix[i][j];
            }
        }
        List<Integer> list1 = spiralOrder ( dp );

        for (int a:list1
             ) {
            list.add ( a );
        }
        return list;
    }


//    public List<Integer> spiralOrder_sub(int[][] matrix,List<Integer>list) {
//
//        ArrayList<Integer> list = new ArrayList<> ();
//        int row = matrix.length;
//        int col = matrix[0].length;
//        for (int i = 0; i < col; i++) {
//            list.add ( matrix[0][i] );
//        }
//        for (int i = 1; i < row; i++) {
//            list.add ( matrix[i][col-1] );
//        }
//
//        for (int i = col-2; i >= 0; i--) {
//            list.add ( matrix[row-1][i] );
//        }
//
//        for (int i = row-2; i > 0; i--) {
//            list.add ( matrix[i][0] );
//        }
//        int[][] dp = new int[row - 1][col - 1];
//        for (int i = 1; i < row-1; i++) {
//            for (int j = 1; j < col-1; j++) {
//                dp[i-1][j-1] = matrix[i][j];
//            }
//        }
//        List<Integer> list1 = spiralOrder ( dp );
//    }




}