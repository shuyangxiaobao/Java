package K0算法面试题汇总.N3搜索二维矩阵;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row-1;
        int j = 0;
        while (i >= 0 && j < col){
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target){
                i--;
            } else {
                j++;
            }
        }
        return false;
    }




}