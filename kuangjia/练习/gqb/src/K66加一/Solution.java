package K66加一;


import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {


    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        Boolean isNine = true;
        for (int i = 0; i < length; i++) {
            if (digits[i] != 9){
                isNine = false;
                break;
            }
        }
        if (isNine){
            int[] arr = new int[length + 1];
            arr[0] = 1;
            return arr;
        }
        int[] arr = new int[length];
        int k = 0;
        for (int i = length-1; i >= 0; i++) {
            if (i == length-1){
                int sum = digits[i] + 1;
                if (sum == 10){
                    k = 1;
                    arr[i] = 0;
                } else {
                    arr[i] = sum;
                }
            }else {
                int sum = digits[i] + k;
                if (sum == 10) {
                    k = 1;
                    arr[i] = 0;
                } else {
                    arr[i] = sum;
                    k = 0;
                }
            }
        }
        return arr;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort (nums);
        return Math.max(nums[-1] * nums[-2] * nums[-3], nums[-1] * nums[0] * nums[1]);
    }



}