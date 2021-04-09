package K67二进制求和;


//
class Solution {
    public static void main(String[] args) {
        String s = addBinary ( "11", "1" );
        System.out.println (s);

    }


   static public String addBinary(String a, String b) {

        char[] array1 = a.toCharArray ();
        char[] array2 = b.toCharArray ();
        int maxlength = Math.max ( array1.length,array2.length );
        StringBuilder stringBuilder = new StringBuilder ();
        int jw = 0;
        for (int i = 0; i < maxlength; i++) {
            int t = 0;
            if (array1.length-1-i >=0){
                t = array1[array1.length-1-i]-48;
            }
            int k = 0;
            if (array2.length-1-i >=0){
                k = array2[array2.length-1-i]-48;
            }
            int sum = t+k+jw;
            jw = sum/2;
            stringBuilder.append ( sum%2+"" );
        }
        if (jw > 0){
            stringBuilder.append ( jw+"" );
        }
        stringBuilder.reverse ();
        return stringBuilder.toString ();
    }





}