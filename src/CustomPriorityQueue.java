import java.util.*;

public class CustomPriorityQueue {

    private int capacity;
    private int itemCnt; // this is the number of items we have stored currently
    private int prev; // this is the previous val
    private boolean requiredPriority; // this is a boolean to track whether the next value removed needs to be the prev + 1
    private PriorityQueue<Item> pq; // this is a priority queue we will store the items in
    private HashSet<Integer> st; // this contains numbers that have been added an odd amount of times!

    public CustomPriorityQueue(int cap) {
        if (cap <= 0)
            System.out.println("Entered an invalid capacity!");

        this.capacity = cap;
        this.itemCnt = 0;
        this.pq  = new PriorityQueue<>((a, b) -> a.getPriority() - b.getPriority()); // sort by priority using lambda expressions -- lowest valued items first
        st = new HashSet<>();
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

        ++this.itemCnt;
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
        if (this.requiredPriority)
            while (pq.peek().getPriority() != prev + 1) {
            }

        // if a number has been removed before and it's the same number, let's set it up so now two of the same have been removed in a row
        if (this.st.contains(this.pq.peek().getPriority())) {
            this.prev = this.pq.peek().getPriority();
            this.requiredPriority = true;
        } else {
            this.st.add(this.pq.peek().getPriority()); // this number has now been added an odd number of times
            this.requiredPriority = false;
        }

        --this.itemCnt; // total count of items is one less now
        return this.pq.poll();
    }

    public int getCap() {
        return this.capacity;
    }

    public int getItemCnt() {
        return this.itemCnt;
    }
}
