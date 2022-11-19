package TaxAgent;

import TaxType.IncomeTaxType;
import TaxType.TaxType;

public class PhysicalPerson extends TaxAgent {
    @Override
    public TaxType getTaxType() {

        return new IncomeTaxType();
    }

    @Override
    public String toString() {
        return "Физ. лицо";
    }
}

