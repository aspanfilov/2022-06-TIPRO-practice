package L03.Cash;

import java.util.Queue;

public class Cash {

    private final int speed;
    private final Queue<Customer> queue;

    public Cash(int speed, Queue<Customer> queue) {
        this.speed = speed;
        this.queue = queue;
    }

    public void serveQueue() {
        int cashResource = this.speed;
        while (cashResource > 0 && !this.queue.isEmpty()) {
            Customer nextCustomer = this.queue.element();
            cashResource = serveCustomer(nextCustomer, cashResource);
            if (nextCustomer.getPurchaseCount() == 0) {
                this.queue.remove();
            }
        }
    }

    public void addToQueue(Customer customer) {
        this.queue.add(customer);
    }

    public int getQueueSize() {
        return this.queue.size();
    }

    public double getServiceTime() {
        int queuePurchaseCount = this.queue.stream().mapToInt(Customer::getPurchaseCount).sum();
        return (double) queuePurchaseCount / (double) this.speed;
    }

    private int serveCustomer(Customer customer, int cashResource) {
        int newCashResource;
        if (cashResource > customer.getPurchaseCount()) {
            newCashResource = cashResource - customer.getPurchaseCount();
            customer.setPurchaseCount(0);
        } else {
            newCashResource = 0;
            int newPurchaseCount = customer.getPurchaseCount() - cashResource;
            customer.setPurchaseCount(newPurchaseCount);
        }
        return newCashResource;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cash(spd=%d size=%d time=%.1f): ",
                this.speed, this.getQueueSize(), this.getServiceTime()));
        this.queue.forEach(customer ->
                sb.append(customer.getInfo()).append(" "));
        return sb.toString();
    }

}
