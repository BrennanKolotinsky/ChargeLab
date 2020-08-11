public class Test {

    public static CustomPriorityQueue queue;
    public static Boolean adding;

    public static void main(String[] args) {
//        runFirstTest();
//        runSecondTest();
//        runThirdTest();
        runFourthTest();
//        runFifthTest();
    }

    /*
        This functions tests whether an item can be successfully added and removed from the custom queue
        Put a system.out.println at the end of the remove in CustomPriorityQueue and it should display 3
    */
    public static void runFirstTest() {
        queue = new CustomPriorityQueue(3);

        // create our adding thread object and start running it
        Item a = new Item(3);
        AddThread add = new AddThread(queue);
        add.waitToAdd(a);
        add.start();

        // create our removal thread object and start running it
        RemoveThread r = new RemoveThread(queue);
        r.increaseRemovals(1); // let's remove one item
        r.start();
    }

    /*
        This functions tests whether the right item can be removed (based on priority)
        Put a system.out.println at the end of the remove in CustomPriorityQueue and it should display 1 and then 3
    */
    public static void runSecondTest() {
        queue = new CustomPriorityQueue(3);

        // create our adding thread object and start running it
        Item a = new Item(3);
        Item b = new Item(1);
        Item c = new Item(7);
        AddThread add = new AddThread(queue);
        add.waitToAdd(a);
        add.waitToAdd(b);
        add.waitToAdd(c);
        add.start();

        // create our removal thread object and start running it
        RemoveThread r = new RemoveThread(queue);
        r.increaseRemovals(2); // let's remove one item
        r.start();
    }

    /*
       This functions tests whether the priority is working when two have been removed with the same priority in consecutive order
       Put a system.out.println at the end of the remove in CustomPriorityQueue and it should display 1, 1, 2 and then 1
   */
    public static void runThirdTest() {
        queue = new CustomPriorityQueue(5);

        // create our adding thread object and start running it
        Item a = new Item(1);
        Item b = new Item(1);
        Item c = new Item(1);
        Item d = new Item(2);
        AddThread add = new AddThread(queue);
        add.waitToAdd(a);
        add.waitToAdd(b);
        add.waitToAdd(c);
        add.waitToAdd(d);
        add.start();

        // create our removal thread object and start running it
        RemoveThread r = new RemoveThread(queue);
        r.increaseRemovals(4); // let's remove one item
        r.start();
    }

    /*
       This functions tests whether the multithreading elements of the priority queue are working
       An item will only be added when there is space for it!
       Put a system.out.println at the end of the remove in CustomPriorityQueue and it should display 3 and then 1
   */
    public static void runFourthTest() {
        queue = new CustomPriorityQueue(1);

        // create our adding thread object and start running it
        Item a = new Item(3);
        Item b = new Item(1);
        AddThread add = new AddThread(queue);
        add.waitToAdd(a);
        add.waitToAdd(b);
        add.start();

        // create our removal thread object and start running it
        RemoveThread r = new RemoveThread(queue);
        r.increaseRemovals(2); // let's remove one item
        r.start();
    }

    /*
       This functions tests whether the multithreading elements of the priority queue are working
       An item will only be removed after one has been added
       Put a system.out.println at the end of the remove in CustomPriorityQueue and it should display 3
    */
    public static void runFifthTest() {
        queue = new CustomPriorityQueue(1);

        // create our removal thread object and start running it
        RemoveThread r = new RemoveThread(queue);
        r.increaseRemovals(2); // let's remove one item
        r.start();

        // create our adding thread object and start running it
        Item a = new Item(3);
        AddThread add = new AddThread(queue);
        add.waitToAdd(a);
        add.start();
    }

    /*
       This functions translates success and failure
       Input: Boolean
       Output String success/fail
   */
    public static String convertTrue(Boolean stat) {
        return stat ? "Successful" : "Failed";
    }
}