package L04.Task01_Box;

public class Main {
    private static final int STEP_COUNT = 10;

    public static void main(String[] args) {

        var box = new Box();
        var producer = new Producer(box);
        var consumer = new Consumer(box);

        var producerThread = new ProducerThread(producer, STEP_COUNT);
        var consumerThread = new ConsumerThread(consumer, STEP_COUNT);

        producerThread.start();
        consumerThread.start();

    }
}

class ProducerThread extends Thread {
    private final Producer producer;
    private final int stepCount;

    ProducerThread(Producer producer, int stepCount) {
        this.producer = producer;
        this.stepCount = stepCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.stepCount; i++) {
            this.producer.fillBox();
        }
    }
}

class ConsumerThread extends Thread {
    private final Consumer consumer;
    private final int stepCount;

    ConsumerThread(Consumer consumer, int stepCount) {
        this.consumer = consumer;
        this.stepCount = stepCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.stepCount; i++) {
            this.consumer.clearBox();
        }
    }

}
