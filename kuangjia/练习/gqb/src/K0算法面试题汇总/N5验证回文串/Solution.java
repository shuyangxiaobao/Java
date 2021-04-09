package K0算法面试题汇总.N5验证回文串;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        solution.isPalindrome ( "OP" );

    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase ();
        int length = s.length ();
        int i = 0;
        int j = length-1;
        while (i < j){
            char start = s.charAt ( i );
            char end = s.charAt ( j );
            boolean b1 = demo ( start );
            boolean b2 = demo ( end );
            if (b1 && b2){
                if (start == end){
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else {
                if (!b1){
                   i++;
                }
                if (!b2){
                    j--;
                }
            }
        }
        return true;
    }

    public boolean demo(Character s) {
        return (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9');
    }





        public boolean isPalindrome(String s) {
        s = s.toLowerCase ();
        int length = s.length ();
        StringBuilder builder = new StringBuilder ();
        for (int i = 0; i < length; i++) {
            if( (s.charAt ( i ) >= 'a' && s.charAt ( i ) <= 'z') || (s.charAt ( i ) >= '0' && s.charAt ( i ) <= '9')){
                builder.append ( s.charAt ( i )+"" );
            }
        }
        String str = builder.toString ();
        length = str.length ();
        int i = 0;
        int j = length-1;
        while (i < j){
            if (str.charAt ( i++ ) != str.charAt ( j-- )){
                return false;
            }
        }
        return true;
    }



}