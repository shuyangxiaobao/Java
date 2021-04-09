package K203移除链表元素;



//
class Solution {
    public static void main(String[] args) {



    }


//    public ListNode removeElements2(ListNode head, int val) {
//        if (head == null){
//            return null;
//        }
//        ListNode newHead = null;
//        while (head != null){
//            if (head.val != val){
//                newHead = head;
//                break;
//            } else {
//                head = head.next;
//            }
//        }
//        ListNode cur = newHead;
//        if (head != null){
//            head = head.next;
//        }
//        while (head != null){
//           if (head.val == val){
//               head = head.next;
//           } else {
//               cur.next = head;
//               cur = head;
//               head = head.next;
//           }
//        }
//        if (cur != null){
//            cur.next = null;
//        }
//        return newHead;
//    }


//    public ListNode removeElements(ListNode head, int val) {
//        ListNode b = new ListNode ( 0 );
//        ListNode t = b;
//        while (head != null){
//            if (head.val != val){
//                t.next = head;
//                t = head;
//            }
//            head = head.next;
//        }
//        t.next = null;
//        return b.next;
//    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummynode = new ListNode ( 0 );
        dummynode.next = head;
        ListNode tail =dummynode;
        while (head != null){
            if (head.val == val){

            } else {
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        tail.next = null;
        return dummynode.next;
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