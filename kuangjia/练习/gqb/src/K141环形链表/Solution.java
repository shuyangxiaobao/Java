package K141环形链表;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null){
            if (fast == slow){
                return true;
            }
            slow = slow.next;
            if (fast.next == null){
                return false;
            }
            fast = fast.next.next;

        }
        return false;
    }





    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }




}