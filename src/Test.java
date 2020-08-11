public class Test {

    public static CustomPriorityQueue queue;
    public static Boolean adding;

    public static void main(String[] args) {
        runFirstTest();
        runSecondTest();
//        runThirdTest();
//        runFourthTest();
    }

    /*
        This functions tests whether an item can be successfully added and removed from the custom queue
    */
    public static void runFirstTest() {
        queue = new CustomPriorityQueue(3);

        Item a = new Item(1);
        queue.waitToAdd(a);
        queue.increaseRemovals(1); // let's remove one item
        queue.start();
//        System.out.println("Test one " + convertTrue(rem.getPriority2() == 1));
    }

    /*
        This functions tests whether the right item can be removed (based on priority)
    */
    public static void runSecondTest() {
        queue = new CustomPriorityQueue(3);

//        Item a = new Item(3);
//        Item b = new Item(1);
//        Item c = new Item(7);
//
//        queue.itemsToAdd.offer(a);
//        queue.itemsToAdd.offer(b);
//        queue.itemsToAdd.offer(c);

//        System.out.println("Test Two " + convertTrue( queue.remove().getPriority2() == 1 && queue.remove().getPriority2() == 3));
    }

    /*
       This functions tests whether the priority is working when two have been removed with the same priority in consecutive order
   */
//    public static void runThirdTest() {
//        queue = new CustomPriorityQueue(5);
//
//        Item b = new Item(1);
//        Item c = new Item(1);
//        Item d = new Item(1);
//        Item e = new Item(2);
//
//        queue.add(b);
//        queue.add(c);
//        queue.add(d);
//        queue.add(e);
//
//        queue.remove();
//        queue.remove();
//
//        // Third item removed should be 2 -- because we have had two consecutive ones in a row
//        System.out.println("Test Three " + convertTrue( queue.remove().getPriority2() == 2 && queue.remove().getPriority2() == 1));
//    }
//
//    /*
//       This functions tests whether the multithreading elements of the priority queue are working
//       An item will only be added when there is space for it!
//   */
//    public static void runFourthTest() {
//        queue = new CustomPriorityQueue(2);
//
//        Item b = new Item(3);
//        Item c = new Item(1);
//
//        queue.add(b);
//        queue.add(c);
//
//        // second item removed should be 1, because there is only capacity for it to be added after the first is removed!
////        System.out.println("Test Four " + convertTrue( queue.remove().getPriority2() == 3 && queue.remove().getPriority2() == 1));
//    }

    /*
       This functions translates success and failure
       Input: Boolean
       Output String success/fail
   */
    public static String convertTrue(Boolean stat) {
        return stat ? "Successful" : "Failed";
    }
}