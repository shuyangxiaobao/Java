package K680验证回文字符串Ⅱ;


//
class Solution {
    public static void main(String[] args) {
        validPalindrome("bddb");
    }

   static public boolean validPalindrome(String s) {
        if (validPalindrome_sub ( s,0,s.length ()-1 )){
            return true;
        }
        char[] array = s.toCharArray ();
        int length = array.length;
        int begin = 0;
        int end = length-1;
        while (begin<length && array[begin] == array[end] && begin < end){
            begin++;
            end--;
        }
        if(begin == end){
            return true;
        }
        return validPalindrome_sub ( s,begin,end-1 ) || validPalindrome_sub ( s,begin+1,end );
    }


    static public boolean validPalindrome_sub(String s,int begin,int end){
        char[] array = s.toCharArray ();
        int length = array.length;
        if (begin >= length){
            return false;
        }
        if (end < 0){
            return false;
        }
        if (begin == end){
            return true;
        }


        if (array[begin] == array[end]){
            if (end-begin == 1){
                return true;
            }
            return validPalindrome_sub(s,begin+1,end-1);
        } else {
            return false;
        }
    }




}