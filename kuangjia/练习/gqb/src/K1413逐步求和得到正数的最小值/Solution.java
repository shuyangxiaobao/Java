package K1413逐步求和得到正数的最小值;


//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }
    public int minStartValue(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int min = nums[0];
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            min = Math.max ( min,sum );
        }
        return 1-min;

    }




}