package K58最后一个单词的长度;


//https://leetcode-cn.com/problems/length-of-last-word/
class Solution {
    public static void main(String[] args) {
        int length = lengthOfLastWord ( "a" );
        System.out.println (length);
    }

    static public int lengthOfLastWord(String s) {

        if (s == null || s.length () == 0){
            return 0;
        }
        char[] array = s.toCharArray ();
        int length = array.length;
        int begin = length-1;
        int end = length-1;
        while (end >= 0){
            if (array[end]==' '){
                end--;
            } else {
                break;
            }
        }
        if (end < 0){
            return 0;
        }
        begin = end;
        while (begin >= 0){
            if (array[begin] == ' '){
                break;
            } else {
                begin--;
            }
        }
        return end-begin;
    }




}