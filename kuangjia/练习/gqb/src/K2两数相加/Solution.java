package K2两数相加;


import java.util.List;

//
class Solution {
    public static void main(String[] args) {

    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode headNode = new ListNode ( 0 );
//        ListNode tailNode = headNode;
//        int jw = 0;
//        int sum = 0;
//        while (l1 != null || l2 != null){
//            int a = 0;
//            if (l1 != null){
//                a = l1.val;
//                l1 = l1.next;
//            }
//            int b = 0;
//            if (l2 != null){
//                b = l2.val;
//                l2 = l2.next;
//            }
//            sum = a+b+jw;
//            ListNode node = new ListNode ( sum % 10 );
//            tailNode.next = node;
//            tailNode = node;
//            jw = sum/10;
//        }
//        if (jw > 0){
//            ListNode node = new ListNode ( 1 );
//            tailNode.next = node;
//        }
//        return headNode.next;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode ( 0 );
        ListNode tail = dummyNode;
        int jw = 0;
        while (l1 != null || l2 != null){
           int a = 0;
           if (l1 != null){
               a = l1.val;
               l1 = l1.next;
           }
            int b = 0;
            if (l2 != null){
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a+b+jw;
            jw = sum/10;
            ListNode node = new ListNode ( sum % 10 );
            tail.next = node;
            tail = node;
        }
        if (jw > 0){
            tail.next = new ListNode ( 1 );
        }
        return dummyNode.next;
    }




    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }


}