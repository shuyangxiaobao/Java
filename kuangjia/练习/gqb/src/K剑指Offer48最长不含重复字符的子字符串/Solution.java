package K剑指Offer48最长不含重复字符的子字符串;


import java.util.HashMap;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int length = solution.lengthOfLongestSubstring ( "abba" );
        System.out.println (length);

    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length ();
        if (length < 2){
            return length;
        }
        char[] array = s.toCharArray ();
        int start = 0;
        int max = 1;
        HashMap<Character, Integer> hashMap = new HashMap<> ();
        int[] hash = new int[128];

        for (int i = 0; i < length; i++) {
            if (hashMap.containsKey ( array[i] )){
                start = Math.max ( hashMap.get ( array[i] ).intValue ()+1,start );
                max = Math.max ( max,i-start+1 );
                hashMap.put ( array[i],i );
            } else {
                hashMap.put ( array[i],i );
                max = Math.max ( max,i-start+1 );
            }
        }
        max = Math.max ( max,length-1-start+1 );
        return max;
    }




}