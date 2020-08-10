import java.util.*;

public class CustomPriorityQueue {

    private int capacity;
    private int itemCnt; // this is the number of items we have stored currently
    private int prev; // this is the previous val
    private boolean twoInARow; // this is a boolean to track whether the previous value was added to the queue twice in a row
    private boolean removedOneNum; // track if we have removed our first number into our queue ever!
    private PriorityQueue<Item> pq; // this is a priority queue we will store the items in

    public CustomPriorityQueue(int cap) {
        this.capacity = cap;
        this.itemCnt = 0;
        this.pq  = new PriorityQueue<>((a, b) -> b.getPriority() - a.getPriority()); // sort by priority using lambda expressions
    }

    /*
        This functions add our items to the priority queue
        Input: Object Item
        Output: Boolean True on success, false if it fails for some reason
     */
    public boolean add(Item i) {
        // this allows the queue item to be added once there is space (multi-threading)
        while (this.capacity == this.itemCnt) {
        }

        pq.offer(i);

        ++this.capacity;
        return true;
    }

    /*
    This functions removes our items from the priority queue, with the highest priority queue
    Input: Null
    Output: Object removed
    */
    public Item remove() {
        // only remove an item when there is one to remove
        while (this.capacity == 0) {
        }

        // if we haven't removed two in a row before, we don't need to find a specific value to remove!
        if (!this.twoInARow) {
            // if a number has been removed before and it's the same number, let's set it up so now two of the same have been removed in a row
            if (this.removedOneNum && this.prev == this.pq.peek().getPriority())
                this.twoInARow = true;

            this.prev = this.pq.peek().getPriority();
        } else {
            // wait until an element is added with the priority of one higher than the previous
            while (pq.peek().getPriority() != prev + 1) {
            }

            twoInARow = false;
            ++prev; // this number is one higher than the previous
        }

        this.removedOneNum = true; // at least one number has been removed now!
        --this.itemCnt; // total count of items is one less now
        return this.pq.poll();
    }
}
