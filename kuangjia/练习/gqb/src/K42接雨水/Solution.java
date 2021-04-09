package K42接雨水;


        import java.util.ArrayList;

class Solution {

//    方法一：暴力法
    public int trap1(int[] height) {

        int length = height.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = i; j >=0 ; j--) {
                leftMax = Math.max ( leftMax,height[j] );
            }
            for (int j = i; j < length ; j++) {
                rightMax = Math.max ( rightMax,height[j] );
            }
            int min = Math.min ( rightMax, leftMax );
            sum += (min-height[i]);
        }
        return sum;
    }
//    时间复杂度 O(n^2) 空间复杂度  O(1)


//    方法2：动态规划
    //    时间复杂度 O(n) 空间复杂度  O(n)
    public int trap(int[] height) {
        int length = height.length;
        if (length < 3){
            return 0;
        }
        int sum = 0;
        int[] rightArr = new int[length];
        rightArr[0] = height[0];
        for (int i = 1; i < length; i++) {
            if (height[i] > rightArr[i-1]){
                rightArr[i] = height[i];
            } else {
                rightArr[i] = rightArr[i-1];
            }
        }
        int[] leftArr = new int[length];
        leftArr[length-1] = height[length-1];
        for (int i = length-2; i >= 0; i--) {
            if (height[i] > leftArr[i+1]){
                leftArr[i] = height[i];
            } else {
                leftArr[i] = leftArr[i+1];
            }
        }
        for (int i = 0; i < length; i++) {
            int min = Math.min ( rightArr[i], leftArr[i] );
            sum += (min-height[i]);
        }
        return sum;
    }

//    public int strStr(String haystack, String needle) {
//        int i = haystack.indexOf ( needle );
//        if (i >= 0){
//            return i;
//        }
//        return -1;
//    }






}