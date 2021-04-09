package K面试题0205链表求和;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode ( -1 );
        ListNode tail = dummyNode;
        int jw = 0;
        while (l1 != null || l2 != null){
            int a = 0;
            if (l1 != null){
                a = l1.val;
            }
            int b = 0;
            if (l2 != null){
                b = l2.val;
            }
            int sum = a +b+jw;
            ListNode node = new ListNode ( sum % 10 );
            tail.next = node;
            tail = node;
            jw = sum / 10;
        }
        return dummyNode.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }





}