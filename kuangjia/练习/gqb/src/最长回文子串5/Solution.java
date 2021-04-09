package 最长回文子串5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {





    static public String longestPalindrome(String s) {
        int len = s.length ();
        if (len < 2) {
            return s;
        }
        boolean[] dp = new boolean[s.length ()];
        int maxLength = 1;
        int begin = 0;
        dp[0] = true;
        char[] array = s.toCharArray ();
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (array[i] == array[j]){
                    if (j-i < 3){
                        dp[i] = true;
                    } else {
                        dp[i] = dp[i+1];
                    }
                } else {
                    dp[i] = false;
                }
                if (dp[i]){
                    if ((j-i+1)>maxLength){
                        maxLength = j-i+1;
                        begin = i;
                    }
                }

            }
        }
       return s.substring ( begin,begin+maxLength);
    }

   static public String longestPalindrome2(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }





    //    3. 无重复字符的最长子串
    static public int lengthOfLongestSubstring(String s) {
        int length = s.length ();
        if (length < 2){
            return length;
        }
        int max = 1;
        char[] array = s.toCharArray ();
        int[][] dp = new int[length+1][length+1];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (isContain ( i,j,array )){
                    int count = 0;
                    ArrayList<Character> list = new ArrayList<> ();
                    for (int k = j; k >=i; k--) {
                        if (!list.contains ( array[k])){
                            list.add(array[k]);
                            count++;
                        } else {
                            break;
                        }
//                        if (array[k] == array[j]){
//                            break;
//                        } else {
//                            count++;
//                        }
                    }
                    max = Math.max ( max,count );
                    dp[i][j] = count;
                } else {
                    dp[i][j] = dp[i][j-1]+1;
                    max = Math.max ( max,dp[i][j] );
                }
            }
        }
        return max;
    }

    static public Boolean isContain(int i,int j,char[] array) {
        ArrayList<Character> list = new ArrayList<> ();
        for (int k = i; k <= j-1 ; k++) {
            list.add ( array[k] );
        }
        return list.contains ( array[j] );
    }


//  static   public int lengthOfLongestSubstring2(String s) {
//        int length = s.length ();
//        if (length < 2){
//            return length;
//        }
//        String substring = s.substring ( 0, s.length () - 1 );
//        int len = lengthOfLongestSubstring2 ( substring );
//        char[] array = s.toCharArray ();
//        ArrayList<Character> list = new ArrayList<> ();
//        for (int i = 0; i < length-1; i++) {
//            if (list.contains ( array[i] )){
//                return len;
//            }
//            list.add ( array[i] );
//        }
//        if (list.contains ( array[length-1] )){
//            return len;
//        } else {
//            return len+1;
//        }
//    }


   static public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            if (dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max ( max,dp[i] );
        }
        return max;

    }



    public static void main(String[] args) {
//        if (true){
//            String string = "absd";
//            int s = lengthOfLongestSubstring ( string );
//            System.out.println ("最长回文子串"+s);
//
//        }
        int[] arr  = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray ( arr );
        System.out.println (i);


    }




}









