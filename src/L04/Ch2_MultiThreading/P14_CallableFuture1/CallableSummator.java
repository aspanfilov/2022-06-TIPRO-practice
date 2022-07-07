package L04.Ch2_MultiThreading.P14_CallableFuture1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableSummator {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int threadCount = 10;
        int value = 100; //1_000_000_000;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Long>> results = new ArrayList<>();

        int size = value / threadCount;
        for (int i = 1; i <= threadCount; i++) {
            int lastValue = size * i;
            int firstValue = lastValue - size + 1;
            results.add(executorService.submit(new Summator(firstValue, lastValue)));
        }
        executorService.shutdown();

        long sum = 0;
        for(Future<Long> future : results) {
            sum += future.get();
        }
        System.out.println(sum);



        Future<Long> future = executorService.submit(new Summator(1, 3));
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class Summator implements Callable<Long> {

    private final int firstValue;
    private final int lastValue;

    Summator(int firstValue, int lastValue) {
        this.firstValue = firstValue;
        this.lastValue = lastValue;
    }

    @Override
    public Long call() throws Exception {

        long result = 0;
        for (int i = this.firstValue; i <= this.lastValue; i++) {
            result += i;
        }
        System.out.println("Sum from " + firstValue + " to " + lastValue + " = " + result);
        return result;

    }
}
