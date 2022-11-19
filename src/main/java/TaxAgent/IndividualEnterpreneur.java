package TaxAgent;

import TaxType.ProgressiveTaxType;
import TaxType.TaxType;

public class IndividualEnterpreneur extends TaxAgent {
    @Override
    public TaxType getTaxType() {
        return new ProgressiveTaxType();
    }

    @Override
    public String toString() {
        return "ИП";
    }
}
