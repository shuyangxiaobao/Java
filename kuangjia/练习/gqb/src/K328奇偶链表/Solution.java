package K328奇偶链表;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        ListNode node1 = new ListNode ( 1 );
        ListNode node2 = new ListNode ( 2 );
        ListNode node3 = new ListNode ( 3 );
        ListNode node4 = new ListNode ( 4 );
        ListNode node5 = new ListNode (  5);
        ListNode node6 = new ListNode (  6);
        ListNode node7 = new ListNode (  7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        solution.oddEvenList ( node1 );

//        solution.

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode root2 = head;

        ListNode root = head;
        ListNode prevNode = head.next;
        head = head.next.next;
        while (head != null && head.next != null){
            ListNode nextHead = head.next.next;
            prevNode.next = head.next;
            prevNode = head.next;
            ListNode rootNext = root.next;
            root.next = head;
            head.next = rootNext;
            head = nextHead;
            root = root.next;
        }
        if (head != null){
            prevNode.next = null;
            ListNode rootNext = root.next;
            root.next = head;
            head.next = rootNext;

        }


        return root2;
    }






}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder ();
        ListNode node = this;
        while (node != null){
            builder.append ( node.val+"->" );
            node = node.next;
        }
        return builder.toString ();
    }
}