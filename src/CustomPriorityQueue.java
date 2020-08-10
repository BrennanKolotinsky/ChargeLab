import java.util.*;

public class CustomPriorityQueue {

    private int capacity;
    private int items; // this is the number of items we have stored currently
    private int prev; // this is the previous val
    private boolean twoInARow; // this is a boolean to track whether the previous value was added to the queue twice in a row
    private PriorityQueue<Item> pq; // this is a priority queue we will store the items in

    public CustomPriorityQueue(int cap) {
        this.capacity = cap;
        this.items = 0;
        this.pq  = new PriorityQueue<>((a, b) -> b.getPriority() - a.getPriority()); // sort by priority using lambda expressions
    }

    /*
        This functions add our items to the priority queue
        Input: Object Item
        Output: Boolean True on success, false if it fails for some reason
     */
    public boolean add(Item i) {
        return true;
    }
}
