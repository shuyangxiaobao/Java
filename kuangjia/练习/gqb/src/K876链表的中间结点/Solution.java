package K876链表的中间结点;


import java.util.ArrayList;
import java.util.HashMap;

//
class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache (2);
        cache.put ( 1,1 );
        cache.put ( 2,2 );
        cache.get ( 1 );
        cache.put ( 3,3 );
        cache.get ( 2 );

    }

}

class LRUCache {
    HashMap<Integer, Node> hashMap;
    int capacity;
    Node first;
    Node last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<> ();
        first = new  Node();
        last = new Node (  );
        first.next = last;
        last.prev = first;

    }

    public int get(int key) {
        Node node = hashMap.get ( key );
        if (node== null){
            return -1;
        }
        removeNode ( node );
        addFirst ( node );
        return node.value;

    }

    public void put(int key, int value) {
        Node node = hashMap.get ( key );
        if (node != null){
            node.value = value;
            removeNode ( node );
            addFirst ( node );
        } else {
            if (hashMap.size () == capacity){
                hashMap.remove ( last.prev.key );
                removeNode ( last.prev );
            }
            node = new Node ( key,value );
            hashMap.put ( key,node );
            addFirst ( node );
        }
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addFirst(Node node){
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
        node.prev = first;
    }
}


class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
    public Node() {

    }
}