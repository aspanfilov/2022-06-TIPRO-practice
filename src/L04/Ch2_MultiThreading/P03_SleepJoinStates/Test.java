package L04.Ch2_MultiThreading.P03_SleepJoinStates;

public class Test extends Thread{

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");

        var myThread = new Thread(new MyThread());
        System.out.println("myThread.getState(): " + myThread.getState());

        myThread.start();
        System.out.println("myThread.start()");
        System.out.println("myThread.getState(): " + myThread.getState());

        myThread.join();
        System.out.println("myThread.getState(): " + myThread.getState());
        System.out.println("Method main ends");
    }


}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("myThread name = " + Thread.currentThread().getName() + " begins work");
        for(int i = 0; i < 5; i++) {
            System.out.println("myThread name = " + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("myThread name = " + Thread.currentThread().getName() + " ends work");
    }
}