package K237删除链表中的节点;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }





}




 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
