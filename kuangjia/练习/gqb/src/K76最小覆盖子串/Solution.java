package K76最小覆盖子串;


import java.util.HashSet;
import java.util.LinkedList;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        solution.minWindow ( "ADOBECODEBANC","ABC" );


    }

    public String minWindow(String s, String t) {

        Boolean contain = isContain ( s, t );
        if (!contain){
            return "";
        }
        int s_length = s.length ();
        int left = 0;
        int right = s_length;
        String result = new String ( s );
        for (int i = 0; i < s_length; i++) {
            for (int j = i+1; j <= s_length; j++) {
                String s1 = s.substring ( i, j );
                System.out.println (s1);
                if (isContain ( s1,t )){
                    if (result.length () > s1.length ()){
                        result = s1;
                    }
                }
            }
        }

        return result;

    }

    public Boolean isContain(String s, String t) {
        LinkedList<String> list = new LinkedList<> ();
        int t_length = t.length ();
        for (int i = 0; i < t_length; i++) {
            list.add ( t.charAt ( i ) +"");
        }
        int s_length = s.length ();
        for (int i = 0; i < s_length; i++) {
            String c = s.charAt ( i ) + "";
            if (list.contains ( c )){
                list.remove ( c );
            }
        }
        return list.isEmpty ();
    }






}