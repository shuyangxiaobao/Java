package yiqian;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        xlpArrayList<Integer> ints = new xlpArrayList<> ();
        ints.add ( 10 );
        ints.add ( 10 );
        ints.add ( 22 );
        ints.add ( 33 );
        System.out.println ( ints );
    }

    @Test
    public void demo1() {
        Person person = new Person ( "xiaoming", 16 );
        Person person2 = new Person ( "小芳", 18 );
        xlpArrayList<Person> arrayList = new xlpArrayList<> ();
        arrayList.add ( person );
        arrayList.add ( person2 );
        System.out.println ( arrayList );
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {


    //    反转一个链表（头插法）
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode end = head.next;
        ListNode tempNode = new ListNode ( 0 );
        head.next = null;
        while (end.next != null) {
            tempNode = end.next;
            end.next = head;
            head = end;
            end = tempNode;
        }
        end.next = head;
        return end;
    }


    //    反转一个链表（递归）
    static public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2 ( head.next );
        ListNode node2 = node;
        while (node2.next != null) {
            node2 = node2.next;
        }
        node2.next = head;
        head.next = null;
        return node;
    }


    public static void main(String[] args) {
        demo1 ();
        demo2 ();
    }


    @Test
    static public void demo1() {
        ListNode node1 = new ListNode ( 1 );
        ListNode node2 = new ListNode ( 2 );
        ListNode node3 = new ListNode ( 3 );

        node1.next = node2;
        node2.next = node3;

        removeElements ( node1, 3 );

//
//
//
//        yiqian.ListNode node4 = new yiqian.ListNode ( 7 );
//        yiqian.ListNode node5 = new yiqian.ListNode ( 8 );
//        yiqian.ListNode node6 = new yiqian.ListNode ( 8 );
//
//        node4.next = node5;
//        node5.next = node6;
//
//        mergeTwoLists(node1,node4);

    }


    //链表（删除链表中的节点）
    static public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (head.val == val) {
                return null;
            } else {
                return head;
            }
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode head1 = head;
        ListNode head2 = head1.next;
        while (head2 != null) {
            if (head2.val == val) {
                head1.next = head2.next;
                break;
            } else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        return head;
    }


    //  环形链表（使用快慢指针）
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (first != null) {
            if (second.next == null || second.next.next == null) {
                return false;
            }
            second = second.next.next;
            first = first.next;
            if (first == second) {
                return true;
            }
        }
        return false;

    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<> ();
        while (head != null) {
            head = head.next;
            list.add ( 0, new Integer ( head.val ) );
            list.add ( 0, head.val );
        }
        int size = list.size ();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get ( i );
        }
        return result;
    }


    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode reult = l1;

        while (l1 != null && l1.next != null) {
            while (l2 != null) {
                ListNode l1_next = l1.next;
                if (l1.val <= l2.val && l1.next.val >= l2.val) {
                    ListNode l2_temp = new ListNode ( l2.val );
                    l1.next = l2_temp;
                    l2_temp.next = l1_next;
                    l2 = l2.next;
                } else {
                    break;
                }
            }
            l1 = l1.next;
        }

        if (l1.next != null) {
            l1 = l1.next;
        }
        l1.next = l2;
        return reult;
    }


    static public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode head1 = head;
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        for (int i = 0; i < size - k; i++) {
            head1 = head1.next;
        }
        return head1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Stack<ListNode> stackA = new Stack<> ();
        Stack<ListNode> stackB = new Stack<> ();

        while (headA != null) {
            stackA.push ( headA );
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push ( headB );
            headB = headB.next;
        }
        ListNode nodeA = stackA.pop ();
        ListNode nodeB = stackB.pop ();

        int count = 0;
        ListNode result = headA;

        while (nodeA.val == nodeB.val) {
            count++;
            result = nodeA;
            nodeA = stackA.pop ();
            nodeB = stackB.pop ();

        }
        if (count > 0) {
            return result;
        } else {
            return null;
        }

    }


    static public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (head.val == val) {
                return null;
            } else {
                return head;
            }
        }

        Stack<ListNode> stack = new Stack<> ();
        while (head != null) {
            stack.push ( head );
            head = head.next;
        }

        Stack<ListNode> stack2 = new Stack<> ();

        while (!stack.isEmpty ()) {
            ListNode node = stack.pop ();
            if (node.val != val) {
                stack2.push ( node );
            }
        }
        if (stack2.isEmpty ()) {
            return null;
        }
        ListNode result = stack2.pop ();
        ListNode result1 = result;
        while (!stack2.isEmpty ()) {
            ListNode temp = stack2.pop ();
            result1.next = temp;
            result1 = temp;
        }
        result1.next = null;
        return result;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> nodes = new Stack<> ();
        nodes.add ( head );
        int val = head.val;
        while (head != null) {
            if (val != head.val) {
                nodes.add ( head );
                val = head.val;
            }
            head = head.next;
        }

        Stack<ListNode> nodes2 = new Stack<> ();

        while (!nodes.isEmpty ()) {
            nodes2.push ( nodes.pop () );
        }

        ListNode first = nodes2.pop ();
        ListNode first1 = first;
        while (!nodes2.isEmpty ()) {
            first1.next = nodes2.pop ();
            first1 = first1.next;
        }
        first1.next = null;
        return first;
    }


    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode head1 = head;
        while (head != null) {
            head = head.next;
            count++;
        }
        if (count % 2 == 0) {
            for (int i = 0; i < count / 2; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < count / 2; i++) {
                head1 = head1.next;
            }
        }
        return head1;
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray ();
        Stack<Character> stack = new Stack<> ();
        for (char c : chars) {
            if (stack.size () == 0) {
                stack.push ( c );
            } else {
                Character peek = stack.peek ();
                if ((peek == '(' && c == ')') || (peek == '{' && c == '}') || (peek == '[' && c == ']')) {
                    stack.pop ();
                } else {
                    stack.push ( c );
                }
            }
        }
        return stack.isEmpty ();
    }

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<> ();
        stack.push ( 0 );

        char[] chars = S.toCharArray ();
        for (Character c : chars) {
            if (c == '(') {
                stack.push ( 0 );
            } else {
                Integer a = stack.pop ();
                Integer b = stack.pop ();
                if (a > 0) {
                    stack.push ( 2 * a + b );
                } else {
                    stack.push ( b + 1 );
                }
            }
        }
        return stack.pop ();

    }

    @Test
    static public void demo2() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        evalRPN ( tokens );

    }

    static public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<> ();

        for (String s : tokens) {
            switch (s) {
                case "+": {
                    Integer a = stack.pop ();
                    Integer b = stack.pop ();
                    stack.push ( b + a );
                    break;

                }
                case "-": {
                    Integer a = stack.pop ();
                    Integer b = stack.pop ();
                    stack.push ( b - a );
                    break;

                }
                case "/": {
                    Integer a = stack.pop ();
                    Integer b = stack.pop ();
                    stack.push ( b / a );
                    break;

                }
                case "*": {
                    Integer a = stack.pop ();
                    Integer b = stack.pop ();
                    stack.push ( b * a );
                    break;

                }
                default: {
                    stack.push ( Integer.valueOf ( s ) );
                    break;
                }
            }
        }

        return stack.pop ();

    }


    class MyQueue {
        private Stack<Integer> a;
        private Stack<Integer> b;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            a = new Stack<Integer> ();
            b = new Stack<Integer> ();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            a.push ( x );

        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!a.isEmpty ()){
                b.push ( a.pop () );
            }
            int result = b.pop ();
            while (!b.isEmpty ()){
                a.push ( b.pop () );
            }
            return result;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!a.isEmpty ()){
                b.push ( a.pop () );
            }
            int result = b.pop ();
            b.push ( result );
            while (!b.isEmpty ()){
                a.push ( b.pop () );
            }
            return result;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return a.isEmpty ();
        }
    }

    class MyStack {
        private Queue<Integer> a;//输入队列
        private Queue<Integer> b;//输出队列
        /** Initialize your data structure here. */
        public MyStack() {
            a = new LinkedList<> ();
            b = new LinkedList<> ();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            a.offer ( x );
            while (!b.isEmpty ()){
                a.offer ( b.poll () );
            }
            Queue temp = a;
            a = b;
            b = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return b.poll ();
        }

        /** Get the top element. */
        public int top() {
            return b.peek ();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return b.isEmpty ();
        }
    }


}
