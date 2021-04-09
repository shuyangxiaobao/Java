package K146LRU缓存机制;


import java.util.HashMap;

class Solution {

}


class LRUCache {
    HashMap<Integer, Node> hashMap;
    Node first;
    Node last;
    int capacity;

    public LRUCache(int capacity) {
       hashMap = new HashMap<> (capacity);
       this.capacity = capacity;
       first = new Node (  );
       last = new Node (  );
       first.next = last;
       last.prev = last;
    }

    public int get(int key) {
        Node node = hashMap.get ( key );
        if (node == null){
            return -1;
        } else {
            removeNode(node);
            addFirst(node);
            return node.value;
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



    public void put(int key, int value) {
        Node node = hashMap.get ( key );
        if (node == null){
          node = new Node ( key,value );
          if (hashMap.size () == this.capacity){
              hashMap.remove ( last.prev.key );
              removeNode ( last.prev );
          }
          hashMap.put ( key,node );
          addFirst ( node );
        } else {
            node.value = value;
            removeNode ( node );
            addFirst ( node );
        }
    }
}

class Node{
     int key;
     int value;
     Node next;
     Node prev;

     public Node(){

     }
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }

}

