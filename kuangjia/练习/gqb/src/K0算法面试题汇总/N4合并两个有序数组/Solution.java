package K0算法面试题汇总.N4合并两个有序数组;


import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        solution.merge ( nums1,3,nums2,3 );

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length1 = m;
        int length2 = n;
        int[] result = new int[length1 + length2];
        int i = 0,j = 0;
        int k = 0;
        while (i < length1 || j < length2 ){
            if (i < length1 && j < length2){
                if(nums1[i] >= nums2[j]){
                    result[k++] = nums2[j++];
                } else {
                    result[k++] = nums1[i++];
                }
            } else {
                if (i < length1){
                    result[k++] = nums1[i++];
                }
                if (j < length2){
                    result[k++] = nums2[j++];
                }
            }
        }
        for (int l = 0; l < m+n; l++) {
            nums1[l] = result[l];
        }
    }



}