package K125验证回文串;


//
class Solution {
    public static void main(String[] args) {
        boolean b = isPalindrome ( "race a car" );
        System.out.println (b);


    }

   static public boolean isPalindrome(String s) {
       s = s.toLowerCase ();
       char[] array = s.toCharArray ();
       int length = array.length;

       StringBuilder builder = new StringBuilder ();
       for (char a:array
            ) {
           if ((a >= 'a' && a<='z')|| (a >= '0' && a<='9')){
              builder.append ( a+"" );
           }
       }
       s = builder.toString ();
       array = s.toCharArray ();
       length = array.length;
       int begin = 0;
       int end = length-1;
       while (begin<end){
           if(array[begin] != array[end]){
               return false;
           } else {
               begin++;
               end--;
           }
       }
       return true;

   }




}