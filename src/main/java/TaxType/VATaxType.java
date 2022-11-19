package TaxType;

import java.math.BigDecimal;

public class VATaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.18));
    }
}
