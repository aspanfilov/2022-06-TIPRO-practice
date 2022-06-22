package L03.Cash;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class StoreEmulator {

    private final List<Cash> cashes;
    private final CustomerGenerator customerGenerator;
    private int customerCount;
    private final int stepCount;

    private static final String INITIAL_STATE = "Initial state";
    private static final String NEW_CUSTOMER = "New customer added";
    private static final String QUEUES_SERVED = "Queues served";

    public StoreEmulator(List<Cash> cashes, CustomerGenerator customerGenerator, int customerCount, int stepCount) {
        this.cashes = cashes;
        this.customerGenerator = customerGenerator;
        this.customerCount = customerCount;
        this.stepCount = stepCount;
    }

    public void start() {
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
