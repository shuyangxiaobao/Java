package K696计数二进制子串;


//
class Solution {
    public static void main(String[] args) {
        int i = countBinarySubstrings ( "00110011" );
        System.out.println (i);
    }


    static public int countBinarySubstrings(String s) {
        char[] array = s.toCharArray ();
        int length = array.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            int j = i;
            while (j<length && array[j] == array[i]){
                j++;
            }
            int count = j-i;
            int begin = j;
            int count2 = 0;
            while (j<length && array[j] == array[begin]){
                j++;
                count2 = j-begin;
                if (count2 >= count){
                    break;
                }
            }
            if (count2 >= count){
                result++;
            }
        }
        return result;
    }




}