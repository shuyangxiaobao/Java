package K206反转链表;


//
class Solution {
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
        ListNode lastNode = null;
        ListNode root = head;
        while (head != null){
            ListNode nextnode = head.next;
            head.next = lastNode;
            lastNode = head;
            head = nextnode;
        }
        return root;
    }




}