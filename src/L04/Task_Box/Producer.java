package L04.Task_Box;

import java.util.Random;

public class Producer {
    private final Box box;
    private final Random random;

    public Producer(Box box) {
        this.box = box;
        this.random = new Random();
    }

    public Box getBox() {
        return this.box;
    }

    public void fillBox() {
        box.fill(random.nextInt(10)+1);
    }
}
