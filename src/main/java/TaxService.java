import TaxAgent.TaxAgent;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxService {
    public void payOut(TaxAgent taxAgent, BigDecimal taxAmont) {
        System.out.println(taxAgent + " уплатил налог в размере " + taxAmont.setScale(2, RoundingMode.CEILING) +
                " рублей");
    }
}
