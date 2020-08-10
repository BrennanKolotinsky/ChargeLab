public class Item<T> {

    private int priority;
    private T val; // generic type with any value

    public Item(int p) {
        this.priority = p;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    public void setVal(T v) {
        this.val = v;
    }

    public int getPriority() {
        return this.priority;
    }

    public T getVal() {
        return this.val;
    }
}
