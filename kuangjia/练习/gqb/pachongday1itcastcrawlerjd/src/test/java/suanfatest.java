import java.util.ArrayList;

public class suanfatest {
}


class Solution {
    public static void main(String[] args) {
        String i = longestPalindrome (
                "absdsba123456" );
        System.out.println ( i );
    }

    static public String longestPalindrome(String s) {
        if (s.length () < 1){
            return s;
        }
        String result = "";
        ArrayList<String> list = new ArrayList<String> ();
        for (int i = 1; i < s.length ()-1; i++) {
            int a = list.size ();
            for (int k = 0;k<a;k++){
                list.remove ( 0 );
            }
            String c = s.charAt ( i ) + "";
            list.add ( c );
            for (int j = 1; j <= i; j++) {
                if (i-j < 0  || i+j > s.length ()-1) {
                    if (list.size () > result.length ()) {
                        result = "";
                        for(int m = 0;m<list.size ();m++){
                            result = result + list.get ( m );
                        }
                        for (int k = 0;k<result.length ();k++){
                            list.remove ( 0 );
                        }
                    }
                    break;
                }
                String before = s.charAt ( i - j ) + "";
                String after = s.charAt ( i+j ) + "";
                if (before.equals ( after )){
                    list.add ( 0,before );
                    list.add ( after );
                } else {
                    if (list.size () > result.length ()) {
                        result = "";
                        for(int m = 0;m<list.size ();m++){
                            result = result + list.get ( m );
                        }
                        for (int k = 0;k<result.length ();k++){
                            list.remove ( 0 );
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }





    static public int lengthOfLongestSubstring(String s) {
        ArrayList<String> list = new ArrayList<String> ();
        int count = 0;
        for (int i = 0; i < s.length (); i++) {
            String c = s.charAt ( i ) + "";
            if (list.contains ( c )) {
                int i1 = list.indexOf ( c );
                for (int j = 0; j <= i1; j++) {
                    list.remove ( 0 );
                }
            }
            list.add ( c );
            if (list.size () > count) {
                count = list.size ();
            }
        }
        return count;
    }
}
