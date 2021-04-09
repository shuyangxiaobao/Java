package K143重排链表;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//
class Solution {
    private static Object Queue;

    public static void main(String[] args) {

        ListNode node1 = new ListNode ( 1 );
        ListNode node2 = new ListNode ( 2 );
        ListNode node3 = new ListNode ( 3 );
        ListNode node4 = new ListNode ( 4 );
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reorderList(node1);



    }


   static public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<> ();
        Stack<ListNode> stack = new Stack<> ();
        ListNode root = head;
        while (root != null){
             queue.push ( root );
             stack.push ( root );
             root = root.next;
        }
        ListNode dummyNode = new ListNode ( 0 );
        ListNode tailNode = dummyNode;
        int size = queue.size ();
        while (size > 0){
            ListNode node1 = queue.pollLast ();
            tailNode.next = node1;
            tailNode = node1;
            size--;
            if (size == 0){
                break;
            }
            ListNode node2 = stack.pop ();
            tailNode.next = node2;
            tailNode = node2;
            size--;
        }
        tailNode.next = null;
    }


//    使用虚拟头节点  双指针
    public void reorderList2(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<> ();
        while (head != null){
            list.add ( head );
            head = head.next;
        }
        ListNode dummyNode = new ListNode ( 0 );
        ListNode tail = dummyNode;
        int left = 0;
        int right = list.size ()-1;
        while (left <= right){
            tail.next = list.get ( left );
            tail = list.get ( left );
            left++;
            tail.next = list.get ( right );
            tail = list.get ( right );
            right--;
        }
        if (left == right){
            tail.next = list.get ( left );
            tail = list.get ( left );
        }
        tail.next = null;
    }




}