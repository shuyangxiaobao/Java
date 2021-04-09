package K88合并两个有序数组;


import java.util.Arrays;

//
class Solution {

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};

        merge ( nums1,3,nums2,3 );
    }

    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n ==0){
            return;
        }
        int inde1 = m-1;
        int index2 = n-1;
        int end = m+n-1;
        while (end >= 0 && inde1 >= 0 && index2 >=0){
            if (nums1[inde1] >= nums2[index2]){
                nums1[end--] = nums1[inde1];
                inde1--;
            } else {
                nums1[end--] = nums2[index2];
                index2--;
            }
        }
        while (index2 >= 0){
            nums1[end--] = nums2[index2--];
        }
    }
}