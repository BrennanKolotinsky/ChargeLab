import java.util.LinkedList;
import java.util.Queue;

public class AddThread extends Thread {

    private Queue<Item> itemsToAdd; // these are items waiting to be added
    private CustomPriorityQueue queue;

    public AddThread(CustomPriorityQueue q) {
        this.queue = q;
        this.itemsToAdd = new LinkedList<>();
    }

    /*
        This will start running our removal process indefinitely (unless terminated)
        Input: Null
        Output: Null
     */
    public void run() {
        try {
            // repeatedly try to remove items
            for (; ; ) {
                if (this.queue.getItemCnt() == this.queue.getCap() || this.itemsToAdd.size() == 0) {
                    Thread.sleep(1000);
                } else {
                    queue.add(itemsToAdd.poll());
                }
            }
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
    }

    /*
        This function will set us up to add an additional element into our priority queue
        Input: Item
        Output: Null
     */

    public void waitToAdd(Item i) {
        this.itemsToAdd.offer(i);
    }
}
