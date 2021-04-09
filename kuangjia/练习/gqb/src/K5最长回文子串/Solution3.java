package K5最长回文子串;


//
class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3 ();
        String s = solution.longestPalindrome ( "bb" );
        System.out.println (s);
    }


    //    动态规划(优化为一纬数组)
    public String longestPalindrome(String s) {
        int length = s.length ();
        char[] array = s.toCharArray ();
        int start = 0;
        String result = s.charAt ( 0 )+"";
        for (int i = 0; i < length; i++) {
            if (array[i] != array[start]){
                String str = demo ( s, start - 1, i );
                if (str.length () > result.length ()){
                    result = str;
                }
                start = i;
            }
        }
        String str = demo ( s, start - 1, length );
        if (str.length () > result.length ()){
            result = str;
        }
        return result;

    }

    public String demo(String s,int start,int end){
        char[] array = s.toCharArray ();
        int length = array.length;
        while (start >= 0 && end < length){
            if (array[start] == array[end]){
                start--;
                end++;
            }else {
                break;
            }
        }
       return s.substring ( start+1,end );
    }


}