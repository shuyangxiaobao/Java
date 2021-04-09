package K13罗马数字转整数;


//
class Solution {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        s=s.replace ( "IV","a");
        s=s.replace ( "IX","b");
        s=s.replace ( "XL","c");
        s=s.replace ( "XC","d");
        s=s.replace ( "CD","e");
        s=s.replace ( "CM","f");
        int length = s.length ();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += cal ( s.charAt ( i ) );
        }
        return sum;
    }

    public int cal(char ch) {
        switch (ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            case 'a' : return 4;
            case 'b' : return 9;
            case 'c' : return 40;
            case 'd' : return 90;
            case 'e' : return 400;
            case 'f' : return 900;
        }
        return 0;
    }


}