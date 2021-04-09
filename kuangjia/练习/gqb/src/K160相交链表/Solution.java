package K160相交链表;


import java.util.HashSet;
import java.util.Stack;

//
class Solution {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<> ();
        while (headA != null){
            hashSet.add ( headA );
            headA = headA.next;
        }
        while (headB != null){
            if (hashSet.contains ( headB )){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }



    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodB = headB;

        while (nodeA != nodB){
            if (nodeA != null){
                nodeA = nodeA.next;
            } else {
                nodeA = headB;
            }
            if (nodB != null){
                nodB = nodB.next;
            } else {
                nodB = headA;
            }
        }
        return nodeA;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        Stack<ListNode> stackA = new Stack<> ();
        Stack<ListNode> stackB = new Stack<> ();
        while (headA != null){
            stackA.push ( headA );
            headA = headA.next;
        }

        while (headB != null){
            stackB.push ( headB );
            headB = headB.next;
        }
        ListNode result = null;
        while (!stackA.isEmpty () && !stackB.isEmpty () && stackA.peek () == stackB.peek ()){
            result = stackA.peek ();
            stackA.pop ();
            stackB.pop ();
        }
        return result;
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