package K48旋转图像;


// https://leetcode-cn.com/problems/rotate-image/
class Solution {
    public static void main(String[] args) {

    }


    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][length-1-j];
                matrix[length-1-i][length-1-j] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][j];
                matrix[length-1-i][j] = temp;
            }
        }
    }




}