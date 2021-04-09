package K941有效的山脉数组;


import java.util.Arrays;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length-1; i++) {
          if (arr[i] < arr[i+1]) {
              left++;
          }
        }
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] <= arr[i-1]) {
                right--;
            }
        }
        return arr[left] == arr[right] && left > 0 && (left < arr.length-1);
    }


    public int dominantIndex(int[] nums) {
        int length = nums.length;
        if (length <2){
            return 0;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                max = nums[i] ;
                maxIndex = i;
            }
        }

        Arrays.sort ( nums );
        if (nums[length-1]-nums[length-2]*2 > 0){
            return maxIndex;
        } else {
            return -1;
        }
    }



}