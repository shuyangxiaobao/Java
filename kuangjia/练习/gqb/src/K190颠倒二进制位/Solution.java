package K190颠倒二进制位;


//
class Solution {
    public static void main(String[] args) {

    }

    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            answer = answer << 1;
            answer += n&1;
            n = n >> 1;
        }
        return answer;
    }




}