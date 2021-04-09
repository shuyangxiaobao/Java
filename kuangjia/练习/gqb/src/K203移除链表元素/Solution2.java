package K203移除链表元素;



//
class Solution2 {
    public static void main(String[] args) {



    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode ( -1 );
        dummyNode.next = head;
        ListNode tail = dummyNode;
        while (head != null){
            if(head.val == val){

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