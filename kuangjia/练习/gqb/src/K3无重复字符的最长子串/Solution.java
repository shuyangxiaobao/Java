package K3无重复字符的最长子串;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int abcabcbb = solution.lengthOfLongestSubstring ( "abcabchh" );
        System.out.println (abcabcbb);
    }


//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        int end = 0, start = 0;
//        for (; end < n; end++) {
//            char alpha = s.charAt(end);
//            if (map.containsKey(alpha)) {
//                start = Math.max ( map.get(alpha) +1,start );
//            }
//            ans = Math.max(ans, end - start + 1);
//            map.put(s.charAt(end), end);
//        }
//        return ans;
//    }
















    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int length = s.length ();
        HashMap<Character, Integer> hashMap = new HashMap<> ();
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (hashMap.containsKey ( s.charAt ( i ) )){
                start = Math.max ( start,hashMap.get ( s.charAt ( i ) ) +1);
            }
            hashMap.put ( s.charAt ( i ),i );
            max = Math.max ( max,i-start+1 );
        }
        return max;
    }












}