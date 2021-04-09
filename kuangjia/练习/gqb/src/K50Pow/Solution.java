package K50Pow;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        double pow = solution.myPow ( 4, 6 );
        System.out.println (pow);

    }


    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if(n== 1){
            return x;
        }
        if(n== -1){
            return 1/x;
        }
        boolean b = (n & 1) == 1;
        double half = myPow ( x, n >>1 );
        half = half * half;
        if (b){
            if (n > 0){
                half = half * x;
            } else {
                half = half / x;
            }
        }
        return half;

    }



}