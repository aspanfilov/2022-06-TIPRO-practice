package L03.Cash.CashSelectionWays;

import L03.Cash.Cash;

import java.util.List;

public class WomanWay implements CashSelectionWay {

    public WomanWay() {
    }

    @Override
    public Cash selectCash(List<Cash> cashes) {

        int minQueueSize = cashes.get(0).getQueueSize();
        int minQueueSizeIndex = 0;

        for (int index = 1; index < cashes.size(); index++) {
            int queueSize = cashes.get(index).getQueueSize();
            if (queueSize < minQueueSize) {
                minQueueSize = queueSize;
                minQueueSizeIndex = index;
            }
        }

        return cashes.get(minQueueSizeIndex);
    }

    @Override
    public String getRepresentation() {
        return "\uD83D\uDC67";
    }
}
