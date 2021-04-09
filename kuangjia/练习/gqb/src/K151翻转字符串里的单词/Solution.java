package K151翻转字符串里的单词;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public String reverseWords(String s) {
        int length = s.length ();
        char[] array = s.toCharArray ();
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != ' '){
                index = i;
                break;
            }
        }
        int end = length-1;

        for (int i = length-1; i >= 0; i--) {
            if (array[i] != ' '){
                end = i;
                break;
            }
        }

        String ans = new String ();
        for (int i = index; i <= end; i++) {
            StringBuilder temp = new StringBuilder ();

            while (i<=end && array[i] != ' '){
                temp.append ( array[i] + "" );
                i++;
            }
            if (temp.toString ().length () == 0)continue;
            if (ans.length () > 0){
                ans = temp.toString () +" "+ans;
            } else {
                ans = temp.toString () +"";
            }
        }
        return ans;
    }




}