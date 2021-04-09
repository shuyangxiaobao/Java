package K1232缀点成线;

class Solution {
    public static void main(String[] args) {


    }


    public boolean checkStraightLine(int[][] coordinates) {

        double v;
        if ((coordinates[1][0] - coordinates[0][0])== 0){
            v = Integer.MAX_VALUE;
        } else {
            v = (coordinates[1][1] - coordinates[0][1]) * 1.0 / (coordinates[1][0] - coordinates[0][0]);
        }

        for (int i = 1; i < coordinates.length; i++) {
            double t;
            if ((coordinates[i][0] - coordinates[0][0]) == 0){
                t = Integer.MAX_VALUE;
            }else {
                t = (coordinates[i][1] - coordinates[0][1]) * 1.0 /(coordinates[i][0] - coordinates[0][0]) ;
            }
            if (v != t){
                return false;
            }
        }
        return true;
    }

}