package K92反转链表II;


//
class Solution {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode ( 1 );
        ListNode listNode2 = new ListNode ( 2 );
        ListNode listNode3 = new ListNode ( 3 );
        ListNode listNode4 = new ListNode ( 4 );
        ListNode listNode5 = new ListNode ( 5 );
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverseBetween ( listNode1,2,4 );
    }

//   static public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode dummyNode = new ListNode ( 0 );
//        dummyNode.next = head;
//        ListNode tail = dummyNode;
//        for (int i = 0; i < left-1; i++) {
//            tail = tail.next;
//            head = head.next;
//        }
//       ListNode node2 = head;
//       head = head.next;
//        for (int i = 0; i < right-left; i++) {
//            ListNode head4 = head.next;
//            ListNode tailNext = tail.next;
//            tail.next = head;
//            head.next = tailNext;
//            node2.next = head4;
//            head = head4;
//        }
//        return dummyNode.next;
//    }

    static public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode ( 0 );
        dummyNode.next = head;
        ListNode tail = dummyNode;
        for (int i = 0; i < left-1; i++) {
            tail = tail.next;
            head = head.next;
        }
        ListNode node2 = head;
        head = head.next;
        for (int i = 0; i < right-left; i++) {
            ListNode node5 = head.next;
            ListNode node3 = tail.next;
            tail.next = head;
            head.next = node3;
            node2.next = node5;
            head = node5;
        }
        return dummyNode.next;
    }


}