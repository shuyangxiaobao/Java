package K剑指Offer04二维数组中的查找;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solutio

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0){
            return false;
        }
        int col = matrix[0].length;
        int i = row-1;
        int j = 0;
        while (i >= 0 && j < col){
            if (matrix[i][j] < target){
                j++;
            } else if (matrix[i][j] > target){
                i--;
            } else {
              return true;
            }
        }
        return false;
    }




}