package L03.Cash.CashSelectionWays;

import L03.Cash.Cash;

import java.util.List;

public interface CashSelectionWay {

    Cash selectCash(List<Cash> cashes);

    String getSelectionName();

}
