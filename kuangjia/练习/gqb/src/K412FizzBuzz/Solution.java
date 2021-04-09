package K412FizzBuzz;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {

    }

    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<> ();
        for (int i = 1; i < n+1; i++) {
            if (i%3 == 0 && i%5 == 0){
                list.add ("FizzBuzz" );
            } else if(i%3 == 0){
                list.add ("Fizz" );
            }else if(i%5 == 0){
                list.add ("Buzz" );
            } else {
                list.add ( "" +i);
            }
        }
        return list;
    }

    public List<String> fizzBuzz2(int n) {
        ArrayList<String> list = new ArrayList<> ();
        for (int i = 1; i < n+1; i++) {
            switch (i%15){
                case 1:{
                    list.add ( i+"" );
                }
                break;
                case 2:{
                    list.add ( i+"" );
                }
                break;

                case 3:{
                    list.add ( "Fizz" );
                }
                break;

                case 4:{
                    list.add ( i+"" );
                }
                break;

                case 5:{
                    list.add ( "Buzz" );
                }
                break;
                case 6:{
                    list.add ( "Fizz" );
                }
                break;
                case 7:{
                    list.add ( i+"" );
                }
                break;

                case 8:{
                    list.add ( i+"" );
                }
                break;

                case 9:{
                    list.add ( "Fizz" );
                }
                break;

                case 10:{
                    list.add ( "Buzz" );
                }
                break;
                case 11:{
                    list.add ( i+"" );
                }
                break;
                case 12:{
                    list.add ( "Fizz" );
                }
                break;

                case 13:{
                    list.add ( i+"" );
                }
                break;

                case 14:{
                    list.add ( i+"" );
                }
                break;

                case 0:{
                    list.add ( "FizzBuzz" );
                }
                break;
            }

        }
        return list;
    }




}