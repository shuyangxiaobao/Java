package K148排序链表;


import java.util.ArrayList;
import java.util.Comparator;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public ListNode sortList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<> ();

        while (head != null){
            list.add ( head );
            head = head.next;
        }


        list.sort ( new Comparator<ListNode> () {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        } );
        ListNode dummyNode = new ListNode ( -1 );
        ListNode tail = dummyNode;
        int size = list.size ();
        for (int i = 0; i < size; i++) {
            ListNode node = list.get ( i );
            tail.next = node;
            tail = node;
        }
        tail.next = null;
        return dummyNode.next;
    }




}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}