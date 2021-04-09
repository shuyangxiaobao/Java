package suanfa;


public class Solution {
    static public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        if (n == 2){
            return "11";
        }
        String lastStr = countAndSay ( n-1 );
        char begin = lastStr.charAt ( 0 );
        int number = 1;
        StringBuilder result = new StringBuilder (  );
        for (int i = 1; i < lastStr.length (); i++) {
            char end = lastStr.charAt ( i );
            if (end == begin){
                number++;
            } else {
                result.append ( number + ""+begin );if (n == 1){
                    return "1";
                }
                begin = end;
                number = 1;
            }
            if (i == lastStr.length () -1){
                result.append ( number + ""+begin );
            }
        }
        return result.toString ();
    }

    public static void main(String[] args) {
        String a = countAndSay(10);
        System.out.println (a);
    }

}
