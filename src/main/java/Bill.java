import TaxAgent.TaxAgent;
import TaxType.TaxType;

import java.math.BigDecimal;

public class Bill {
    public TaxAgent taxAgent;
    private final BigDecimal amount;
    private final TaxService taxService;

    public Bill(TaxAgent taxAgent, BigDecimal amount, TaxService taxService) {
        this.taxAgent = taxAgent;
        this.amount = amount;
        this.taxService = taxService;
    }

    public BigDecimal payTaxes() {
        TaxType taxType = taxAgent.getTaxType();
        BigDecimal taxAmont = taxType.calculateTaxFor(amount);
        taxService.payOut(taxAgent, taxAmont);
        return taxAmont;
    }
}
