package K138复制带随机指针的链表;


import java.util.HashMap;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }
    HashMap<Node, Node> hashMap = new HashMap<> ();

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        if (hashMap.containsKey ( head )){
            return hashMap.get ( head );
        }
        Node root = new Node ( head.val );
        hashMap.put ( head,root );
        root.next = copyRandomList ( head.next );
        root.random = copyRandomList ( head.random );
        return root;
    }



}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}