package TaxAgent;

import TaxType.TaxType;
import TaxType.VATaxType;

public class OOO extends TaxAgent {
    @Override
    public TaxType getTaxType() {
        return new VATaxType();
    }

    @Override
    public String toString() {
        return "ООО";
    }
}
