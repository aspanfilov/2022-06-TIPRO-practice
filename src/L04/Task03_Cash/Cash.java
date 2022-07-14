package L04.Task03_Cash;

import java.util.concurrent.BlockingQueue;

public class Cash {

    private final int cashNumber;
    private final int speed;
    private final BlockingQueue<Customer> queue;

    public Cash(int cashNumber, int speed, BlockingQueue<Customer> queue) {
        this.cashNumber = cashNumber;
        this.speed = speed;
        this.queue = queue;
    }

    public void serveQueue() throws InterruptedException {
        int cashResource = this.speed;

        while (cashResource > 0 && !this.queue.isEmpty()) {
            Customer nextCustomer = this.queue.element();
            cashResource =
                    serveCustomerAndGetCashResource(nextCustomer, cashResource);
            if (nextCustomer.getPurchaseCount() == 0) {
                this.queue.take();
            }
        }
    }

    public void addToQueue(Customer customer) throws InterruptedException {
        this.queue.put(customer);
    }

    public int getQueueSize() {
        return this.queue.size();
    }

    public float getServiceTime() {
        int queuePurchaseCount = this.queue.stream().mapToInt(Customer::getPurchaseCount).sum();
        return (float) queuePurchaseCount / (float) this.speed;
    }

    public int getCashNumber() {
        return cashNumber;
    }

    private int serveCustomerAndGetCashResource(Customer customer, int cashResource) {
        if (cashResource <= customer.getPurchaseCount()) {
            int newPurchaseCount = customer.getPurchaseCount() - cashResource;
            customer.setPurchaseCount(newPurchaseCount);
            return 0;
        }
        int newCashResource = cashResource - customer.getPurchaseCount();
        customer.setPurchaseCount(0);
        return newCashResource;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Cash%d (spd=%d size=%d time=%.1f): ",
                Thread.currentThread().getName(),
                this.cashNumber, this.speed, this.getQueueSize(), this.getServiceTime()));
        this.queue.forEach(customer ->
                sb.append(customer.getInfo()).append(" "));
        return sb.toString();
    }

}
