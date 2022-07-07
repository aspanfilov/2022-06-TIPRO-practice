package L04.Ch2_MultiThreading.P14_CallableFuture1;

import java.util.concurrent.*;

public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Factorial2(5));
        try {
            System.out.println("Хотим получить результат факториала");
            System.out.println("future.isDone(): " + future.isDone());
            //Получаем результат из future
            factorialResult = future.get(); //Здесь текущий поток будет заблокирован пока не получит результат
            System.out.println("future.isDone(): " + future.isDone());
            System.out.println("Получили результат факториала");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class Factorial2 implements Callable<Integer> {
    //Callable работает только с ExecutorService (Отдельно создать Thread не получится)

    private final int f;

    public Factorial2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        if (f <= 0) {
            throw new Exception("Incorrect number");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }
}
