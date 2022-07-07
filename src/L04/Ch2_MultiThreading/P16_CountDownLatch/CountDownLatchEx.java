package L04.Ch2_MultiThreading.P16_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    //CountDownLatch - это синхронизатор, позволяющий любому количеству потоков ждать,
    // пока  не завершится определенное количество операций.
    //В конструктор CountDownLatch нужно передавать количество операций,
    //которые должны завершится, чтобы потоки продолжили свою работу

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);

        System.out.println("Market staff came to work");
        countDownLatch.countDown();
        System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
    }

    private static void everythisIsReady() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("Everything is ready, so lets open market");
        countDownLatch.countDown();
        System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);

        System.out.println("Market is opened");
        countDownLatch.countDown();
        System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {

        new Friend("Ivan", countDownLatch);
        new Friend("Petr", countDownLatch);
        new Friend("Sidr", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Gogi", countDownLatch);

        marketStaffIsOnPlace();
        everythisIsReady();
        openMarket();

    }

}

class Friend extends Thread {
    private final String name;
    private final CountDownLatch countDownLatch;

    Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;

        this.start();
    }

    @Override
    public void run() {

        try {
            countDownLatch.await(); //Если счетчик > 0, наш поток будет заблокирован до тех пор пока счетчик не станет = 0
            System.out.println(name + " приступил к закупкам");
            sleep(2000);
            System.out.println(name + " завершил покупки");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
