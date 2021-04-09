package K剑指Offer59队列的最大值;


import java.util.LinkedList;

class MaxQueue {
    LinkedList<Integer> dataqueue;
    LinkedList<Integer> maxqueue;


    public MaxQueue() {
        dataqueue = new LinkedList<> ();
        maxqueue = new LinkedList<> ();

    }

    public int max_value() {
        if (maxqueue.isEmpty ()){
            return -1;
        }
        return maxqueue.peekFirst ();

    }

    public void push_back(int value) {

        while (!maxqueue.isEmpty () && value > maxqueue.peekLast ()){
            maxqueue.pollLast ();
        }
        dataqueue.offerLast ( value );
        maxqueue.offerLast ( value );

    }

    public int pop_front() {
        if (dataqueue.isEmpty ()){
            return -1;
        }
        int last = dataqueue.pollFirst ();
        if (last == maxqueue.peekFirst ()){
            maxqueue.pollFirst ();
        }
        return last;
    }
}
