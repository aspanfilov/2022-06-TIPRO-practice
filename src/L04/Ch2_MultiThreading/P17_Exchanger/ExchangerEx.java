package L04.Ch2_MultiThreading.P17_Exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    //Exchanger - это синхронизатор, позволяющий обмениваться данными между двумя потоками,
    //обеспечивает то, что оба потока получат информацию друг от друга одновременно

    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        BestFriend bestFriend1 = new BestFriend("Ivan",
                List.of(Action.NOJNICI, Action.BUMAGA, Action.NOJNICI), exchanger);
        BestFriend bestFriend2 = new BestFriend("Petr",
                List.of(Action.BUMAGA, Action.KAMEN, Action.KAMEN), exchanger);

        bestFriend1.start();
        bestFriend2.start();

    }

}

enum Action {
    KAMEN, NOJNICI, BUMAGA;
}

class BestFriend extends Thread {
    private final String name;
    private final List<Action> myActions;
    private final Exchanger<Action> exchanger;


    BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
    }

    private void whoWins(Action myAction, Action friendAction) {
        if ((myAction == Action.BUMAGA && friendAction == Action.KAMEN)
            || (myAction == Action.KAMEN && friendAction == Action.NOJNICI)
            || (myAction == Action.NOJNICI && friendAction == Action.BUMAGA))
        {
            System.out.println(name + " WINS!!!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for(Action action : myActions) {
            try {
                //Отправляем свое действие в exchanger и ожидаем ответное действие.
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
