package L03.Cash;

import L03.Cash.CashSelectionWays.CashSelectionWay;

import java.util.List;

public class Customer {

    private int purchaseCount;
    private final CashSelectionWay cashSelectionWay;
    private boolean isJustCameIn;

    public Customer(int purchaseCount, CashSelectionWay cashSelectionWay, boolean isJustComeIn) {
        this.purchaseCount = purchaseCount;
        this.cashSelectionWay = cashSelectionWay;
        this.isJustCameIn = isJustComeIn;
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        if (purchaseCount > this.purchaseCount) {
            throw new IllegalArgumentException(
                    "Set purchase count " + purchaseCount + " more than it was: " + this.purchaseCount);
        }
        if (purchaseCount < 0) {
            throw new IllegalArgumentException(
                    "Set negative purchase count: " + purchaseCount);
        }
        this.purchaseCount = purchaseCount;
    }

    public Cash selectCash(List<Cash> cashes) {
        if (cashes.isEmpty()) {
            throw new IllegalArgumentException("list of cashes is empty");
        }
        return this.cashSelectionWay.selectCash(cashes);
    }

    public void dropJustCameInFlag() {
        this.isJustCameIn = false;
    }

    public String getInfo() {
        return (this.isJustCameIn ? "+ " : "") +
                this.cashSelectionWay.getRepresentation() +
                "(" + this.purchaseCount + ")";
    }

}
