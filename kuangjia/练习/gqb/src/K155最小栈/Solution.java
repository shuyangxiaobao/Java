package K155最小栈;


import java.util.Stack;

//
//class MinStack {
//    Stack<Integer> dataStack;
//    Stack<Integer> minStack;
//    public MinStack() {
//        dataStack = new Stack<> ();
//        minStack = new Stack<> ();
//    }
//    public void push(int x) {
//        dataStack.push ( x );
//        if (minStack.isEmpty ()){
//            minStack.push ( x );
//        } else {
//            minStack.push ( Math.min ( x,minStack.peek () ) );
//        }
//    }
//    public void pop() {
//        dataStack.pop ();
//        minStack.pop ();
//    }
//    public int top() {
//        return dataStack.peek ();
//    }
//    public int getMin() {
//        return minStack.pop ();
//    }
//
//}

class Node{
    int val;
    int min;
    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {

    Stack<Node> dataStack;
    public MinStack() {
        dataStack = new Stack<> ();
    }
    public void push(int x) {
        if (dataStack.isEmpty ()){
            dataStack.push ( new Node ( x,x ) );
        } else {
            dataStack.push ( new Node ( x,Math.min ( x,dataStack.peek ().min ) ) );
        }

    }
    public void pop() {
        dataStack.pop ();

    }
    public int top() {
        return dataStack.peek ().val;
    }
    public int getMin() {
        return dataStack.peek ().min;
    }

}