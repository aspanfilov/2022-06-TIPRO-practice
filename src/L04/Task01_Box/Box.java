package L04.Task01_Box;

public class Box {
    private int value;
    private boolean isFilled;

    public synchronized void fill(int value) {
        try {
            while (this.isFilled) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.value = value;
        this.isFilled = true;
        System.out.println("P(" + value + ")");
        notify();
    }

    public synchronized void clear() {
        try {
            while (!isFilled) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("C(" + value + ")");
        this.value = 0;
        this.isFilled = false;
        notify();
    }

}



