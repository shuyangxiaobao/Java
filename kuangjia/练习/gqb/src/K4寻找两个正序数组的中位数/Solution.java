package K4寻找两个正序数组的中位数;


import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        findMedianSortedArrays2(nums1,nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] arr = new int[length1 + length2];
        for (int i = 0; i < length1; i++) {
            arr[i] = nums1[i];
        }
        for (int i = 0; i < length2; i++) {
            arr[i+length1] = nums2[i];
        }
        Arrays.sort ( arr );
        int length = arr.length;
        if (length%2 == 1){
            return arr[length/2];
        }else {
            return (arr[length/2]+arr[length/2-1])*1.0/2;
        }
    }

    static public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] arr = new int[length1 + length2];
        int length = arr.length;
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index<length && index1 < length1 && index2 < length2){
            if (nums1[index1]<=nums2[index2]){
                arr[index++] = nums1[index1++];
            } else {
                arr[index++] = nums2[index2++];
            }
        }
        if (index < length){
            if (index1 < length1){
                while (index<length){
                    arr[index++] = nums1[index1++];
                }
            }else {
                while (index<length){
                    arr[index++] = nums2[index2++];
                }
            }
        }
        if (length%2 == 1){
            return arr[length/2];
        }else {
            return (arr[length/2]+arr[length/2-1])*1.0/2;
        }
    }



}