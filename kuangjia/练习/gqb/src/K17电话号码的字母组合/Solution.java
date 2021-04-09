package K17电话号码的字母组合;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        List<String> list = solution.letterCombinations ( "23" );
        System.out.println (list);

    }
    List<String> lists;
    String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

        lists = new ArrayList<> (  );
        Character[] characters = new Character[digits.length ()];
        int length = digits.length ();
        if (length == 0){
            return lists;
        }
        letterCombinations(digits,1,characters);
        return lists;
    }


    public void letterCombinations(String digits,int index,Character[] characters) {
        int length = digits.length ();
        if (index == length+1){
            StringBuilder builder = new StringBuilder ();
            for (int i = 0; i < length; i++) {
                builder.append ( characters[i]+"" ) ;
            }
            lists.add ( builder.toString () );
            return;
        }
        char[] array = digits.toCharArray ();
        String s = arr[array[index - 1] - '2'];
        char[] array1 = s.toCharArray ();
        int length1 = array1.length;
        for (int i = 0; i < length1; i++) {
            characters[index-1] = array1[i];
            letterCombinations(digits,index+1,characters);
        }

    }


    }