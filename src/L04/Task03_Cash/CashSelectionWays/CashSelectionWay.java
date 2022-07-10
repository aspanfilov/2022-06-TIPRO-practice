package L04.Task03_Cash.CashSelectionWays;

import L04.Task03_Cash.Cash;

import java.util.List;

public interface CashSelectionWay {

    Cash selectCash(List<Cash> cashes);

    String getRepresentation();

}
