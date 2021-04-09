package K242有效的字母异位词;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

//
class Solution {
    public static void main(String[] args) {

    }


    public boolean isAnagram(String s, String t) {
        HashSet<Character> hashSet = new HashSet<> ();
        char[] array1 = s.toCharArray ();
        char[] array2 = t.toCharArray ();
        Arrays.sort ( array1 );
        Arrays.sort ( array2 );
        int length1 = array1.length;
        int length2 = array2.length;
        if (length1 != length2){
            return false;
        }
        for (int i = 0; i < length1; i++) {
            if (array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }




}