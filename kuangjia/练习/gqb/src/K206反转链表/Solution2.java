package K206反转链表;


//
class Solution2 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode lastNode = null;
        while (head != null){
            ListNode next = head.next;
            head.next = lastNode;
            lastNode = head;
            head = next;
        }
        return lastNode;
    }





}