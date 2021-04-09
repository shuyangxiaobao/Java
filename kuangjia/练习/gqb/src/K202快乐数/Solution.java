package K202快乐数;


class Solution {
     int count = 0;
    public boolean isHappy(int n) {
        count++;
        if (count >= 1000){
            return false;
        }
        if (n == 1){
            return true;
        }
        int a = n;
        int sum = 0;
        while (a > 0){
            int end = a%10;
            sum += end * end;
            a = a/10;
        }
        return isHappy ( sum );
    }
}