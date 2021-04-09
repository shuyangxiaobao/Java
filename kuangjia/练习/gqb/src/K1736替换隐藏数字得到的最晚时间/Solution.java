package K1736替换隐藏数字得到的最晚时间;


//
class Solution {
    public static void main(String[] args) {
        String s = maximumTime ( "0?:3?" );
        System.out.println (s);

    }

    static public String maximumTime(String time) {
        StringBuffer stringBuffer = new StringBuffer ();
        char[] array = time.toCharArray ();
        char a = array[0];
        char b = array[1];
        char c = array[3];
        char d = array[4];
        if (b == '?'){
            if (a == '?'){
                a = '2';
                b = '3';
            } else {
                if (a<'2'){
                    b = '9';
                } else {
                    b = '3';
                }
            }
        }else {
            if (b < '4'){
                if (a == '?'){
                    a = '2';
                }
            } else {
                if (a == '?'){
                    a = '1';
                }
            }
        }
        if (c == '?'){
            c = '5';
        }
        if (d == '?'){
            d = '9';
        }
        stringBuffer.append ( a+"" );
        stringBuffer.append ( b+"" );
        stringBuffer.append ( ":" );
        stringBuffer.append ( c+"" );
        stringBuffer.append ( d+"" );
        return stringBuffer.toString ();
    }



}