package L03.Cash.CashSelectionWays;

import L03.Cash.Cash;

import java.util.List;

public class ManWay implements CashSelectionWay {

    public ManWay() {
    }

    @Override
    public Cash selectCash(List<Cash> cashes) {

        double minServiceTime = cashes.get(0).getServiceTime();
        int minServiceTimeIndex = 0;

        for (int index = 1; index < cashes.size(); index++) {
            double serviceTime = cashes.get(index).getServiceTime();
            if (serviceTime < minServiceTime) {
                minServiceTime = serviceTime;
                minServiceTimeIndex = index;
            }
        }

        return cashes.get(minServiceTimeIndex);
    }

    @Override
    public String getSelectionName() {
        return "M";
    }
}
