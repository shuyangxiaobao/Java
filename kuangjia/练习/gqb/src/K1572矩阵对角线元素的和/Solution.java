package K1572矩阵对角线元素的和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {


    }


    public int diagonalSum(int[][] mat) {
        int length = mat.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += mat[i][i];
            sum += mat[mat.length-1-i][i];
        }
        if (length%2 == 1){
            sum -= mat[length/2][length/2];
        }
        return sum;
    }



}