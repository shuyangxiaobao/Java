package K19删除链表的倒数第N个结点;


import java.util.ArrayList;

//
class Solution {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode dummyNode = new ListNode ( 0 );
        dummyNode.next = head;
        ListNode tail = dummyNode;
        ListNode[] list = new ListNode[40];
        list[0] = dummyNode;
        int i = 1;
        while (head != null){
            list[i++] = head;
            head = head.next;
        }
        ListNode listNode = list[  i - n - 1 ];
        listNode.next = listNode.next.next;
        return dummyNode.next;
    }


//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null){
//            return null;
//        }
//        ListNode dummyNode = new ListNode ( 0 );
//        dummyNode.next = head;
//        ListNode tail = dummyNode;
//        ArrayList<ListNode> list = new ArrayList<ListNode> ();
//        list.add ( dummyNode );
//        while (head != null){
//            list.add ( head );
//            head = head.next;
//        }
//        ListNode listNode = list.get ( list.size () - n - 1 );
//        listNode.next = listNode.next.next;
//        return dummyNode.next;
//    }





}