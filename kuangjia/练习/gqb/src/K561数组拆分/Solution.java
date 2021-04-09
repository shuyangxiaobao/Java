package K561数组拆分;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length/2; i++) {
            sum += nums[i*2];
        }
        return sum;
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length-1; j++) {
                if (nums[j] == 0){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


}