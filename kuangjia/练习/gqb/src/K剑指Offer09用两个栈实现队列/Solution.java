package K剑指Offer09用两个栈实现队列;


import java.util.Stack;

class CQueue {
    Stack<Integer> a;
    Stack<Integer> b;

    public CQueue() {
        a = new Stack<> ();
        b = new Stack<> ();
    }

    public void appendTail(int value) {
        a.push ( value );

    }

    public int deleteHead() {
        if (b.isEmpty ()){
            while (!a.isEmpty ()){
                b.push ( a.pop () );
            }
        }
        if (b.isEmpty ()){
            return 0;
        }
        return b.pop ();
    }
}
