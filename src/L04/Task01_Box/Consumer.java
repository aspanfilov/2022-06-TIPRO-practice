package L04.Task01_Box;

public class Consumer {
    private final Box box;

    public Consumer(Box box) {
        this.box = box;
    }

    public Box getBox() {
        return this.box;
    }

    public void clearBox() {
        box.clear();
    }
}
