package TaxAgent;

import TaxType.TaxType;
import TaxType.VATaxType;

public class ZAO extends TaxAgent {
    @Override
    public TaxType getTaxType() {

        return new VATaxType();
    }

    @Override
    public String toString() {
        return "ЗАО";
    }
}
