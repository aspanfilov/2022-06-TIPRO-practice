package L04.Ch2_MultiThreading.P04_Volatile;

public class Control {
    private volatile boolean b = true;

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean getB() {
        return this.b;
    }
}
