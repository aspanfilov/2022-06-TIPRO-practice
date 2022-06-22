package L03.Cash;

import L03.Cash.CashSelectionWays.ChildWay;
import L03.Cash.CashSelectionWays.ManWay;
import L03.Cash.CashSelectionWays.WomanWay;

import java.util.List;

public class Main {

    private static final int MAX_CUSTOMER_PURCHASE_COUNT = 5;
    private static final int STORE_CUSTOMER_COUNT = 20;
    private static final int STORE_STEP_COUNT = 30;

    private static final int CASH_COUNT = 4;
    private static final int MAX_CASH_SPEED = 3;
    private static final int MAX_CASH_DEFAULT_QUEUE_SIZE = 5;

    public static void main(String[] args) {

        var cashSelectionWays = List.of(
                new ChildWay(),
                new WomanWay(),
                new ManWay()
        );

        var customerGenerator = new CustomerGenerator(cashSelectionWays, MAX_CUSTOMER_PURCHASE_COUNT);
        var cashGenerator = new CashGenerator(customerGenerator);

        var cashes = cashGenerator.getCashes(CASH_COUNT, MAX_CASH_SPEED, MAX_CASH_DEFAULT_QUEUE_SIZE);
        var store = new StoreEmulator(cashes, customerGenerator, STORE_CUSTOMER_COUNT, STORE_STEP_COUNT);

        store.start();

    }

}
