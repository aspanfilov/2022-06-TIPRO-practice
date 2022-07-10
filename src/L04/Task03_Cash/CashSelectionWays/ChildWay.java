package L04.Task03_Cash.CashSelectionWays;

import L04.Task03_Cash.Cash;

import java.util.List;
import java.util.Random;

public class ChildWay implements CashSelectionWay {

    private final Random random;

    public ChildWay() {
        this.random = new Random();
    }

    @Override
    public Cash selectCash(List<Cash> cashes) {
        int index = this.random.nextInt(cashes.size());
        return cashes.get(index);
    }

    @Override
    public String getRepresentation() {
        return "\uD83D\uDC76";
    }

}
