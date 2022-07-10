package L04.Ch2_MultiThreading.P04_Volatile.VolatileTest;

import java.io.IOException;

public class CopierImpl implements Copier, Cancelable {

//    private volatile boolean cancelFlag;
    private boolean cancelFlag;

    public CopierImpl(boolean cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    @Override
    public void cancel() {
        this.cancelFlag = true;
    }

    @Override
    public void inc() {
        int result = 0;
        while (!this.cancelFlag) {
            result++;
        }
        System.out.println("result = " + result);
    }

}
