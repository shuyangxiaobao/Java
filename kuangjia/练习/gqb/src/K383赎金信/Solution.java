package K383赎金信;


import java.util.ArrayList;

//
class Solution {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<String> list = new ArrayList<> ();
        char[] array = magazine.toCharArray ();
        for (char a:array
             ) {
            list.add ( ""+a );
        }
        char[] array1 = ransomNote.toCharArray ();
        for (char a:array1
        ) {
            String s = "" + a;
            if (list.contains ( s )){
                list.remove ( s );
            } else {
                return false;
            }
        }
        return true;
    }



}