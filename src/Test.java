import java.util.*;

public class Test {

    public static void main(String[] args) {
        runFirstTest();
    }

    public static void runFirstTest() {
        CustomPriorityQueue queue = new CustomPriorityQueue(1);

        Item a = new Item(1);
        queue.add(a);
        System.out.println(a.getPriority());
    }
}