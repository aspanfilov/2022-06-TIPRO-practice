package L03.Task01_Cash.CashSelectionWays;

import L03.Task01_Cash.Cash;

import java.util.List;

public interface CashSelectionWay {

    Cash selectCash(List<Cash> cashes);

    String getRepresentation();

}
