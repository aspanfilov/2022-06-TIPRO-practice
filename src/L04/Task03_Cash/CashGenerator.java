package L04.Task03_Cash;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CashGenerator {

    private final Random random;
    private final CustomerGenerator customerGenerator;
    private int currentCashNumber = 0;

    public CashGenerator(CustomerGenerator customerGenerator) {
        this.random = new Random();
        this.customerGenerator = customerGenerator;
    }

    public List<Cash> getCashes(int cashCount, int maxCashSpeed, int cashQueueLimit, int maxCashDefaultQueueSize) {
        List<Cash> cashes = new ArrayList<>();
        for (int i = 0; i < cashCount; i++) {
            Cash cash = getCash(maxCashSpeed, cashQueueLimit, maxCashDefaultQueueSize);
            cashes.add(cash);
        }
        return cashes;
    }

    private Cash getCash(int maxCashSpeed, int cashQueueLimit, int maxDefaultQueueSize) {
        int cashSpeed = getRandom(maxCashSpeed);
        BlockingQueue<Customer> queue = getDefaultQueue(cashQueueLimit, maxDefaultQueueSize);
        return new Cash(getCurrentCashNumber(), cashSpeed, queue);
    }

    private BlockingQueue<Customer> getDefaultQueue(int cashQueueLimit, int maxDefaultQueueSize) {
        BlockingQueue<Customer> defaultQueue = new ArrayBlockingQueue<>(cashQueueLimit);
        if (maxDefaultQueueSize > 0) {
            int defaultQueueSize = getRandom(maxDefaultQueueSize);
            for (int i = 0; i < defaultQueueSize; i++) {
                defaultQueue.add(this.customerGenerator.getCustomer(false));
            }
        }
        return defaultQueue;
    }

    private int getRandom(int maxValue) {
        return this.random.nextInt(maxValue) + 1;
    }

    private int getCurrentCashNumber() {
        this.currentCashNumber++;
        return this.currentCashNumber;
    }

}
