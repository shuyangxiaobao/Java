package K234回文链表;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//
class Solution {



    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val+"->"+next;
        }
    }


    public boolean isPalindrome2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<> ();
        ListNode root = head;
        while (root != null){
            list.add ( root.val );
            root = root.next;
        }
        int size = list.size ();
        for (int i = size-1; i >= 0; i--) {
            if (head.val != list.get ( i )){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<> ();
        ListNode root = head;
        while (root != null){
            list.add ( root.val );
            root = root.next;
        }
        int begin = 0;
        int end = list.size ()-1;
        while (begin <= end){
            if (list.get ( begin ) == list.get ( end )){
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

    public boolean isPalindrome3(ListNode head) {
        Stack<Integer> stack = new Stack<> ();
        LinkedList<Integer> queue = new LinkedList<> ();
        if (head == null){
            return true;
        }
        while (head != null){
            stack.push ( head.val );
            queue.offer ( head.val );
            head = head.next;
        }
        while (!stack.isEmpty ()){
           if (stack.pop () != queue.poll ()){
               return false;
           }
        }
        return true;
    }


    public boolean isPalindrome4(ListNode head) {
        ArrayList<Integer> list = new ArrayList<> ();
        if (head == null){
            return true;
        }
        while (head != null){
            list.add ( head.val );
            head = head.next;
        }
        int left = 0;
        int mid = list.size () >> 1;
        while (left <= mid){
            if (list.get ( left ) != list.get ( list.size ()-1-left )){
                return false;
            }
            left++;
        }
        return true;
    }



}