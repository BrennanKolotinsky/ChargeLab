public class Item<T> {

    private int priority;
    private T val; // generic type with any value

    public Item(int p) {
        this.priority = p;
    }

    public void setPriority2(int p) {
        this.priority = p;
    }

    public void setVal(T v) {
        this.val = v;
    }

    // named getPriority2 because thread implements a method called getPriority!
    public int getPriority2() {
        return this.priority;
    }

    public T getVal() {
        return this.val;
    }
}
