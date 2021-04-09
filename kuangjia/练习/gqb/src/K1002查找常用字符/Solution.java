package K1002查找常用字符;


import java.util.*;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

        String[] A = {"cool","lock","cook"};
        List<String> list = commonChars ( A );
        System.out.println (list);

    }

    static public List<String> commonChars(String[] A) {
        ArrayList<Character> hashSet = new ArrayList<> ();
        char[] array = A[0].toCharArray ();
        for (Character a:array
        ) {
            hashSet.add ( a );
        }

        for (String str:A) {
            char[] chars = str.toCharArray ();
            ArrayList<Character> tempSet = new ArrayList<> ();
            for (Character a:chars) {
                if (hashSet.contains ( a )){
                    tempSet.add ( a );
                    hashSet.remove ( a );
                }
            }
            hashSet = tempSet;
        }
        ArrayList<String> result = new ArrayList<> ();
        Iterator<Character> iterator = hashSet.iterator ();
        while (iterator.hasNext ()){
            Character next = iterator.next ();
            result.add ( ""+next+"" );
        }
        return result;
    }
}