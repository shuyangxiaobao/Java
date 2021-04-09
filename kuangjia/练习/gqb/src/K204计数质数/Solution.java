package K204计数质数;



class Solution {
    public int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
        if(n ==3){
            return 1;
        }
        return countPrimes ( n-1 )+ (isPrime ( n-1 ) == true ? 1:0);
    }

    public boolean isPrime(int n){
        if(n == 2){
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

}