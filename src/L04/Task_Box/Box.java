package L04.Task_Box;

public class Box {
    private int value;
    private boolean isFilled;

    public void fill(int value) {
        this.value = value;
        this.isFilled = true;
        System.out.println("P(" + value + ")");
    }

    public synchronized boolean isFilled() {
        return isFilled;
    }

    public synchronized void clear() {
        System.out.println("C(" + value + ")");
        this.value = 0;
        this.isFilled = false;
    }


}



