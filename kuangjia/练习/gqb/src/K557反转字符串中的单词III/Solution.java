package K557反转字符串中的单词III;


//
class Solution {
    public static void main(String[] args) {
        String s = reverseWords ( "Let's take LeetCode contest" );
        System.out.println (s);
    }

    static public String reverseWords(String s) {
        char[] array = s.toCharArray ();
        StringBuilder builder = new StringBuilder ();
        StringBuilder tempBuilder = new StringBuilder ();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1){
                builder.append (tempBuilder.reverse ().toString ());
            }
            if (array[i] == ' '){
                builder.append (tempBuilder.reverse ().toString ());
                builder.append (" ");
                tempBuilder = new StringBuilder ();
            } else {
                tempBuilder.append ( array[i]+"");
            }
        }
//        builder.delete ( builder.length ()-2,builder.length ()-1 );
        return builder.toString ();
    }



}