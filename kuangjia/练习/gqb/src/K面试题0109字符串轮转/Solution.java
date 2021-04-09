package K面试题0109字符串轮转;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length () != s2.length ()){
            return false;
        }
        return (s1+s1).contains ( s2 );
    }




}