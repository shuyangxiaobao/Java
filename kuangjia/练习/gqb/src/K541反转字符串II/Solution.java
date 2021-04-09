package K541反转字符串II;


//
class Solution {
    public static void main(String[] args) {
        String s = reverseStr ( "abcdefg", 2 );
        System.out.println (s);
    }

    static public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray ();
        int length = charArray.length;
        StringBuilder result = new StringBuilder ();

        for (int i = 0; i < length; ) {
            if (i+2*k <= length){
                String substring = s.substring ( i, i + k );
                StringBuilder stringBuilder = new StringBuilder ();
                stringBuilder.append ( substring );
                stringBuilder.reverse ();
                stringBuilder.append ( s.substring ( i+k, i + 2*k ) );
                i += 2*k;
                result.append ( stringBuilder.toString () );
            } else if (i+k>=length){
                StringBuilder stringBuilder = new StringBuilder ();
                String substring = s.substring ( i, length);
                stringBuilder.append ( substring );
                stringBuilder.reverse ();
                result.append ( stringBuilder.toString () );
                break;
            }else if (i+k<length && i+2*k>length){
                StringBuilder stringBuilder = new StringBuilder ();
                String substring = s.substring ( i, i+k);
                stringBuilder.append ( substring );
                stringBuilder.reverse ();
                stringBuilder.append ( s.substring ( i+k,length ) );
                result.append ( stringBuilder.toString () );

                break;
            }
        }
        return result.toString ();
    }





}