package K28实现strStr;


//
class Solution {



    public static void main(String[] args) {
        int next = strStr ( "aabaaabaaac","aabaaac" );
        System.out.println (next);
    }

    //    KMP算法
   static public int[] next(String str){
        int length = str.length ();
        char[] array = str.toCharArray ();
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (array[i] == array[dp[i-1]]){
                dp[i] = dp[i-1]+1;
            }
        }
        // System.out.println (dp);
        for (int i = length-1; i > 0 ; i--) {
            dp[i] = dp[i-1];
        }
        dp[0] = -1;
        return dp;
    }

    static public int strStr(String haystack, String needle) {
        if (needle.length () < 1){
            return -1;
        }

        int[] next = next ( needle );
        int length = haystack.length ();
        int j = 0;
        int i = 0;
        while (i<haystack.length () && j < needle.length ()){
            if (j== -1 || haystack.charAt ( i ) == needle.charAt ( j )){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length ()){
            return i-j;
        }
        return -1;

    }





//调用系统方法（面试不可用）
//    static public int strStr(String haystack, String needle) {
//        int i = haystack.indexOf ( needle );
//        if (i >= 0){
//            return i;
//        }
//        return -1;
//    }




//   1。暴力法
//   static public int strStr(String haystack, String needle) {
//        if (haystack.equals ( needle )){
//            return 0;
//        }
//        char[] array1 = haystack.toCharArray ();
//        char[] array2 = needle.toCharArray ();
//        if (array2.length == 0){
//            return 0;
//        }
//        for (int i = 0; i < haystack.length (); i++) {
//            if (array1[i] == array2[0] && i + array2.length<=array1.length){
//                String substring = haystack.substring ( i, i + array2.length );
//                if (substring.equals ( needle )){
//                    return i;
//                }
//            }
//        }
//        return -1;
//
//    }



}