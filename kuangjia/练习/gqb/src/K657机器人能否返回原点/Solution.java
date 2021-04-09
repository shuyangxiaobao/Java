package K657机器人能否返回原点;


//
class Solution {
    public static void main(String[] args) {
        boolean b = judgeCircle ( "RLUURDDDLU" );
        System.out.println (b);
    }

    static public boolean judgeCircle(String moves) {
        char[] array = moves.toCharArray ();
        double t = 0.0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == 'R'){
                a += 1;
            } else if(c == 'L'){
                a -= 1;
            }else if(c == 'U'){
                b += 1;

            }else if(c == 'D'){
                b -= 1;
            }
        }
        return a == b && a == 0;
    }




}