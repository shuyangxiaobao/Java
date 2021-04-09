package K21合并两个有序链表;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode ( 0 );
        ListNode tail = dummyNode;
        while (l1 != null || l2 != null){
            if (l1 == null){
                tail.next = l2;
                break;
            }
            if (l2 == null){
                tail.next = l1;
                break;
            }
            if (l1.val <= l2.val){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        return dummyNode.next;
    }




}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
