package K86分隔链表;



//
class Solution {
    public static void main(String[] args) {

    }



    public ListNode partition2(ListNode head, int x) {
        ListNode leftNode = new ListNode ( 0 );
        ListNode lefttail = leftNode;
        ListNode rightNode = new ListNode ( 0 );
        ListNode righttail = rightNode;
        while (head != null){
            if (head.val < x){
                lefttail.next = head;
                lefttail = head;
            } else {
                righttail.next = head;
                righttail = head;
            }
            head = head.next;
        }
        lefttail.next = rightNode.next;
        return leftNode.next;
    }











}