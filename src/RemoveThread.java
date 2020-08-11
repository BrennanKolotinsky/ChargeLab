public class RemoveThread extends Thread {

    private int itemsToRemove; // this is the number of items waiting to be removed
    private CustomPriorityQueue queue;

    public RemoveThread(CustomPriorityQueue q) {
        this.queue = q;
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
                if (queue.getItemCnt() == 0 || this.itemsToRemove == 0) {
                    Thread.sleep(1000);
                } else {
                    queue.remove();
                    this.itemsToRemove--;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
    }

    /*
        This function will set us up to remove x number of additional elements
        Input: Integer number to increase the removal
        Output: Null
     */
    public void increaseRemovals(int i) {
        this.itemsToRemove += i;
    }
}