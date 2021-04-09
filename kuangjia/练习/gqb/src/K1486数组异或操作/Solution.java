package K1486数组异或操作;


//
class Solution {
    public static void main(String[] args) {

    }

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (start +2*i);
        }
        return result;
    }




}