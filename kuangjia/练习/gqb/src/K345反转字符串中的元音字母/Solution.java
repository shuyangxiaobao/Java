package K345反转字符串中的元音字母;


import java.util.ArrayList;
import java.util.HashSet;

//
class Solution {
    public static void main(String[] args) {
        String leetcode = reverseVowels ( "leetcode" );
        System.out.println (leetcode);
    }

   static   public String reverseVowels(String s) {
        HashSet<Object> hashset = new HashSet<> ();
        hashset.add ( "a" );
        hashset.add ( "e" );
        hashset.add ( "i" );
        hashset.add ( "o" );
        hashset.add ( "u" );
        hashset.add ( "A" );
        hashset.add ( "E" );
        hashset.add ( "I" );
        hashset.add ( "O" );
        hashset.add ( "U" );
        char[] array = s.toCharArray ();
        int length = array.length;
        int begin = 0;
        int end = length-1;
        while (begin < end){
            while (true){
                String s1 = array[begin] + "";
                if (hashset.contains ( s1 )){
                    break;
                }
                begin++;
            }
            if (begin >= end){
                break;
            }

            while (true){
                String s1 = array[end] + "";
                if (hashset.contains ( s1 )){
                    break;
                }
                end--;
            }
            char temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            begin++;
            end--;
        }
        StringBuilder builder = new StringBuilder ();
        for (char a:array
             ) {
            builder.append ( a+"" );
        }
        return builder.toString ();
    }



}