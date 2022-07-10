package L04.Task03_Cash;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class StoreEmulator {

    private final List<Cash> cashes;
    private final CustomerGenerator customerGenerator;
    private int customerCount;
    private final int stepCount;

    private static final String INITIAL_STATE = "Initial state";
    private static final String NEW_CUSTOMER = "New customer added";
    private static final String QUEUES_SERVED = "Queues served";

    private static final int LONG_OPERATION_TIME = 2000;

    public StoreEmulator(List<Cash> cashes, CustomerGenerator customerGenerator, int customerCount, int stepCount) {
        this.cashes = cashes;
        this.customerGenerator = customerGenerator;
        this.customerCount = customerCount;
        this.stepCount = stepCount;
    }

    public void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(this.cashes.size() + 1);

        try {
            executorService.execute(new NewCustomerThread(LONG_OPERATION_TIME));
            Thread.sleep(LONG_OPERATION_TIME / 4);

            for (Cash cash : cashes) {
                executorService.execute(new CashThread(cash, LONG_OPERATION_TIME));
                Thread.sleep(LONG_OPERATION_TIME / 10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public void start_old() {
        System.out.println(this.getInfo(INITIAL_STATE));

        IntStream.range(1, this.stepCount + 1).forEach(stepNumber -> {
            System.out.println(getStepLine(stepNumber));

            Optional<Customer> nextCustomer = generateNextCustomer();
            nextCustomer.ifPresent(customer -> {
                Cash cash = customer.selectCash(this.cashes);
                cash.addToQueue(customer);
                System.out.println(this.getInfo(NEW_CUSTOMER));
            });

            this.cashes.forEach(Cash::serveQueue);
            System.out.println(this.getInfo(QUEUES_SERVED));

            nextCustomer.ifPresent(Customer::dropJustCameInFlag);
        });
    }

    private Optional<Customer> generateNextCustomer() {
        if (this.customerCount == 0) {
            return Optional.empty();
        }
        this.customerCount--;
        return Optional.of(this.customerGenerator.getCustomer(true));
    }

    public String getStepLine(int stepNumber) {
        return String.format("Step %d/%d.......................................................",
                stepNumber, this.stepCount);
    }

    public String getInfo(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Store(left=%d) [%s]\n", this.customerCount, title));
        this.cashes.forEach(cash ->
                sb.append(String.format("   %s\n", cash.getInfo())));
        return sb.toString();
    }
}

class CashThread extends Thread {
    private final Cash cash;
    private final int longOperationTime;

    CashThread(Cash cash, int longOperationTime) {
        this.cash = cash;
        this.longOperationTime = longOperationTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                cash.serveQueue();

                System.out.println(cash.getInfo());
                sleep(longOperationTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class NewCustomerThread extends Thread {
    private final int longOperationTime;

    NewCustomerThread(int longOperationTime) {
        this.longOperationTime = longOperationTime;
    }

    @Override
    public void run() {
        try {
            int stepNumber = 0;
            while (true) {
                stepNumber++;
                System.out.println(getStepLine(stepNumber));
                sleep(longOperationTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getStepLine(int stepNumber) {
        return String.format(">> Step %d.......................................................",
                stepNumber);
    }
}