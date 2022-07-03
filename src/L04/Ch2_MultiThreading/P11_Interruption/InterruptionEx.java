package L04.Ch2_MultiThreading.P11_Interruption;

public class InterruptionEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");

        InterruptedThread interruptedThread = new InterruptedThread();
        interruptedThread.start();

        Thread.sleep(2000);
        System.out.println("1000 milis out");

        //Отправляем запрос на прерывание потока
        interruptedThread.interrupt();

        interruptedThread.join();
        System.out.println("main ends");
    }
}

class InterruptedThread extends Thread{
    double sqrtSum = 0;

    @Override
    public void run() {
        for(int i = 1; i<= 1_000_000_000; i++) {
            //Прерываем работу потока по запросу извне
            if (isInterrupted()) {
                System.out.println("Поток хотят прервать");
                System.out.println("Мы убедились что состояние всех объектов нормальное" +
                        " и завершили работу потока");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                //InterruptedException - это исключение выбрасывается,
                // когда поток хотят прервать во время длительной операции sleep() или join().
                System.out.println("Поток хотят прервать во время сна." +
                        "Давайте завершим его работу");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}
