package K面试题0304化栈为队;


import java.util.Stack;

class MyQueue {
    Stack<Integer> a;
    Stack<Integer> b;
    /** Initialize your data structure here. */
    public MyQueue() {
        a = new Stack<Integer> ();
        b = new Stack<Integer> ();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push ( x );

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (b.isEmpty ()){
            while (!a.isEmpty ()){
                b.push ( a.pop () );
            }
        }
        return b.pop ();
    }

    /** Get the front element. */
    public int peek() {
        if (b.isEmpty ()){
            while (!a.isEmpty ()){
                b.push ( a.pop () );
            }
        }
        return b.peek ();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return a.isEmpty () && b.isEmpty ();
    }
}
