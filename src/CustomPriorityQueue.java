import java.util.*;

public class CustomPriorityQueue {

    private int capacity;
    private int itemCnt; // this is the number of items we have stored currently
    private int prev; // this is the previous val
    public boolean requiredPriority; // this is a boolean to track whether the next value removed needs to be the prev + 1
    private PriorityQueue<Integer> pq; // this is a priority queue we will store the items in
    private HashSet<Integer> st; // this contains numbers that have been added an odd amount of times!
    private HashMap<Integer, LinkedList<Item>> map; // this will track all of the items under each priority

    public CustomPriorityQueue(int cap) {
        if (cap <= 0)
            System.out.println("Entered an invalid capacity!");

        this.capacity = cap;
        this.itemCnt = 0;
        this.pq  = new PriorityQueue<>((a, b) -> a - b); // sort by priority using lambda expressions -- lowest valued items first
        this.map = new HashMap<>();
        this.st = new HashSet<>();
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

        this.map.putIfAbsent(i.getPriority(), new LinkedList<>()); // create a new linkedlist under this number to add nums to if it doesn't exist
        this.map.get(i.getPriority()).offer(i); // add the item
        pq.offer(i.getPriority());
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
        while (this.getItemCnt() == 0) {
        }

        Item rem;

        // if we have removed two of the same priority let's wait until the next priority is available to remove it
        if (this.requiredPriority) {
            // wait until this key exists to remove it
            while (!this.map.containsKey(prev + 1) || this.map.get(prev + 1).size() == 0) {
            }

            rem = this.map.get(prev + 1).poll(); // remove the item that was just added
            if (map.get(prev + 1).size() == 0)
                this.map.remove(prev + 1);
        } else {
            // clean up smaller priority mappings that don't have items attached any longer
            while (!this.map.containsKey(this.pq.peek()) || this.map.get(this.pq.peek()).size() == 0)
                pq.poll();

            int curr = pq.poll();
            rem = this.map.get(curr).poll(); // remove the item that was just added
            if (map.get(curr).size() == 0)
                this.map.remove(curr);
        }

        updateSet(rem.getPriority());
        --this.itemCnt; // total count of items is one less now
        return rem;
    }

    /*
        This functions will update variables to track whether two of the same value have been set in a row
        Input: Integer The priority of the number we are removing
        Output: Null
    */
    public void updateSet(int val) {
        // if a number has been removed before and it's the same number, let's set it up so now two of the same have been removed in a row
        if (this.st.contains(val)) {
            this.prev = val;
            this.st.remove(val);
            this.requiredPriority = true;
        } else {
            this.st.add(val); // this number has now been added an odd number of times
            this.requiredPriority = false;
        }
    }

    public int getItemCnt() {
        return this.itemCnt;
    }
}
