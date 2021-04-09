package K350两个数组的交集II;


import java.util.ArrayList;
import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {

    }



   static public int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        Arrays.sort ( nums1 );
        Arrays.sort ( nums2 );
        int index1 = 0;
        int index2 = 0;
        ArrayList<Integer> list = new ArrayList<> ();
        while (index1 < length1 && index2 < length2){
            if (nums1[index1] < nums2[index2]){
                index1++;
            } else if (nums1[index1] == nums2[index2]) {
                list.add ( nums1[index1] );
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
       int[] arr = new int[list.size ()];
        for (int i = 0; i < list.size (); i++) {
            arr[i] = list.get ( i );
        }
        return arr;
    }




}