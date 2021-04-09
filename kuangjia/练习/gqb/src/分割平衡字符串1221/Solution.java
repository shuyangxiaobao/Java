package 分割平衡字符串1221;

public class Solution {


    public int balancedStringSplit(String s) {
        int count = 0;
        int result = 0;
        for (char a:s.toCharArray ()) {
            if (a == 'R'){
                count++;
            }else {
                count--;
            }
            if (count == 0){
                result++;
            }
        }
        return result;
    }


}
