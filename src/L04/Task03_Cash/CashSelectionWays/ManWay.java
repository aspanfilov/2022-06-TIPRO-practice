package L04.Task03_Cash.CashSelectionWays;

import L04.Task03_Cash.Cash;

import java.util.List;

public class ManWay implements CashSelectionWay {

    public ManWay() {
    }

    @Override
    public Cash selectCash(List<Cash> cashes) {

        float minServiceTime = cashes.get(0).getServiceTime();
        int minServiceTimeIndex = 0;

        for (int index = 1; index < cashes.size(); index++) {
            float serviceTime = cashes.get(index).getServiceTime();
            if (serviceTime < minServiceTime) {
                minServiceTime = serviceTime;
                minServiceTimeIndex = index;
            }
        }

        return cashes.get(minServiceTimeIndex);
    }

    @Override
    public String getRepresentation() {
        return "\uD83D\uDC68";
    }
}
