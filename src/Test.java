import java.util.*;

public class Test {

    public static void main(String[] args) {
        runFirstTest();
        runSecondTest();
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



    public static String convertTrue(Boolean stat) {
        return stat ? "Successful" : "Failed";
    }
}