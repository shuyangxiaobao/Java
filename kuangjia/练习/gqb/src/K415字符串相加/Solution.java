package K415字符串相加;


import java.util.ArrayList;

// https://leetcode-cn.com/problems/add-strings/
class Solution {
    public static void main(String[] args) {
        String s = addStrings ( "3897", "893" );
        System.out.println (s);
    }

    static public String addStrings(String num1, String num2) {
        char[] array1 = num1.toCharArray ();
        char[] array2 = num2.toCharArray ();
        int maxlength = Math.max ( array1.length,array2.length );
        int jw = 0;
        StringBuilder builder = new StringBuilder ();
        ArrayList<Integer> list = new ArrayList<> ();
        for (int i = 0; i < maxlength; i++) {
            int a = 0;
            if (array1.length-1-i >= 0){
                a = array1[array1.length-1-i] - 48;
            }
            int b = 0;
            if (array2.length-1-i >= 0){
                b = array2[array2.length-1-i] - 48;
            }
            int sum = a+b+ jw;
            jw = sum/10;
            list.add ( sum%10 );
        }
        if (jw > 0){
            list.add ( jw );
        }
        for (int i = list.size ()-1; i >= 0; i--) {
            Integer a = list.get ( i );
            builder.append ( a +"");
        }
        String string = builder.toString ();
        return string;
    }




}