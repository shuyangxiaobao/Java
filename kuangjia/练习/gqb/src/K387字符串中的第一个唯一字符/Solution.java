package K387字符串中的第一个唯一字符;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//
class Solution {
    public static void main(String[] args) {
        int leetcode = firstUniqChar ( "loveleetcode" );
        System.out.println (leetcode);
    }

   static public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<> ();
        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt ( i );
            if (hashMap.containsKey ( ch )){
                hashMap.put ( ch,hashMap.get ( ch ).intValue ()+1 );
            } else {
                hashMap.put ( ch,1 );
            }
        }
        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt ( i );
            if (hashMap.get ( ch ).intValue () == 1){
                return i;
            }
        }
        return -1;
    }






}