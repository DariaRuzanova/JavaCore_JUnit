package TaxType;

import java.math.BigDecimal;

public class ProgressiveTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        BigDecimal multiplier = (amount.compareTo(BigDecimal.valueOf(100_000)) < 0) ? BigDecimal.valueOf(0.1) : BigDecimal.valueOf(0.15);
        return amount.multiply(multiplier);
    }
}
