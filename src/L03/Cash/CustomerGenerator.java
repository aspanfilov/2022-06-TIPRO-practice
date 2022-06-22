package L03.Cash;

import L03.Cash.CashSelectionWays.CashSelectionWay;

import java.util.List;
import java.util.Random;

public class CustomerGenerator {

    private final Random random;
    private final List<CashSelectionWay> cashSelectionWays;
    private final int maxCustomerPurchaseCount;

    public CustomerGenerator(List<CashSelectionWay> cashSelectionWays, int maxCustomerPurchaseCount) {
        this.random = new Random();
        this.cashSelectionWays = cashSelectionWays;
        this.maxCustomerPurchaseCount = maxCustomerPurchaseCount;
    }

    public Customer getCustomer(boolean isJustComeIn) {
        int purchaseCount = getRandom(this.maxCustomerPurchaseCount, 1);
        int cashSelectionIndex = getRandom(this.cashSelectionWays.size(), 0);
        CashSelectionWay cashSelectionWay = this.cashSelectionWays.get(cashSelectionIndex);
        return new Customer(purchaseCount, cashSelectionWay, isJustComeIn);
    }

    private int getRandom(int maxValue, int offset) {
        return this.random.nextInt(maxValue) + offset;
    }



}
