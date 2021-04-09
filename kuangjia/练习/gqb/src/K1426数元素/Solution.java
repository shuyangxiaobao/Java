package K1426数元素;


import java.util.Arrays;
import java.util.HashSet;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }

    public int countElements(int[] arr) {
        Arrays.sort ( arr );
        int length = arr.length;
        HashSet<Object> hashSet = new HashSet<> ();
        for (int i = 0; i < length; i++) {
            hashSet.add ( arr[i] );
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (hashSet.contains ( arr[i]+1 )){
                count++;
            }
        }
        return count;
    }




}