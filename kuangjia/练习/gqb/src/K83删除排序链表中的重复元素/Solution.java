package K83删除排序链表中的重复元素;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public ListNode deleteDuplicates(ListNode head) {
//        虚拟头节点
        ListNode dummyNode = new ListNode ( Integer.MAX_VALUE );
        ListNode tail = dummyNode;
        dummyNode.next = head;
        while (head != null){
            if (head.val == tail.val){

            } else {
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        tail.next = null;
        return dummyNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }





}