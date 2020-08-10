import java.util.*;

public class Test {

    public static void main(String[] args) {
        runFirstTest();
        runSecondTest();
        runThirdTest();
    }

    /*
        This functions tests whether an item can be successfully added and removed from the custom queue
    */
    public static void runFirstTest() {
        CustomPriorityQueue queue = new CustomPriorityQueue(3);

        Item a = new Item(1);
        queue.add(a);
        Item rem = queue.remove();
        System.out.println("Test one " + convertTrue(rem.getPriority() == 1));
    }

    /*
        This functions tests whether the right item can be removed (based on priority)
    */
    public static void runSecondTest() {
        CustomPriorityQueue queue = new CustomPriorityQueue(3);

        Item b = new Item(3);
        Item c = new Item(1);
        Item d = new Item(7);

        queue.add(b);
        queue.add(c);
        queue.add(d);

        System.out.println("Test Two " + convertTrue( queue.remove().getPriority() == 1 && queue.remove().getPriority() == 3));
    }

    /*
       This functions tests whether the multithreading elements of the priority queue are working
       An item will only be added when there is space for it!
   */
    public static void runThirdTest() {
        CustomPriorityQueue queue = new CustomPriorityQueue(2);

        Item b = new Item(3);
        Item c = new Item(1);

        queue.add(b);
        queue.add(c);

        System.out.println(queue.getItemCnt());

        // second item removed should be 1, because there is only capacity for it to be added after the first is removed!
//        System.out.println("Test Three " + convertTrue( queue.remove().getPriority() == 3 && queue.remove().getPriority() == 1));
    }

    public static String convertTrue(Boolean stat) {
        return stat ? "Successful" : "Failed";
    }
}