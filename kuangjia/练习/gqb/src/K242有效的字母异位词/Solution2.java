package K242有效的字母异位词;


import java.util.Arrays;
import java.util.HashSet;

//
class Solution2 {
    public static void main(String[] args) {

    }

//先排序再比较
//    public boolean isAnagram(String s, String t) {
//        char[] arr1 = s.toCharArray ();
//        char[] arr2 = t.toCharArray ();
//        if (arr1.length != arr2.length){
//            return false;
//        }
//        Arrays.sort ( arr1 );
//        Arrays.sort ( arr2 );
//        int length = arr1.length;
//        for (int i = 0; i < length; i++) {
//            if (arr1[i] != arr2[i]){
//                return false;
//            }
//        }
//        return true;
//    }


    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        char[] arr1 = s.toCharArray ();
        char[] arr2 = t.toCharArray ();
        for (Character ch:arr1) {
            arr[ch-'a']++;
        }
        for (Character ch:arr2) {
            arr[ch-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0){
                return false;
            }
        }
        return true;
    }



}