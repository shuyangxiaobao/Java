package K剑指Offer25合并两个排序的链表;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null )return l2;
        if (l2 == null )return l1;
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        if (l1.val <= l2.val){
            dummyNode.next = l1;
            tail = l1;
            l1 = l1.next;
        } else {
            dummyNode.next = l2;
            tail = l2;
            l2 = l2.next;
        }


        while (l1 != null || l2 != null){
            if (l1 == null){
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
                break;
            }
            if (l2 == null){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
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