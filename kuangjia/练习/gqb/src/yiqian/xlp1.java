package yiqian;

public class xlp1 {

    public static void main(String[] args) {

        int fib = fib ( 10 );
        System.out.println (fib);
    }

    static public int fib(int N) {
       int a = 0;
       int b = 1;
        for (int i = 0; i < N; i++) {
            b = a+b;
            a = b-a;
        }
        return a;
    }
}



