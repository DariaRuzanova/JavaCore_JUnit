import TaxAgent.IndividualEnterpreneur;
import TaxAgent.OOO;
import TaxAgent.PhysicalPerson;
import TaxAgent.ZAO;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PhysicalPerson physicalPerson = new PhysicalPerson();
        IndividualEnterpreneur individualEnterpreneur = new IndividualEnterpreneur();
        OOO ooo = new OOO();
        ZAO zao = new ZAO();

        TaxService taxService = new TaxService();

        Bill[] bills = new Bill[]{
                new Bill(physicalPerson, new BigDecimal("85000.29"), taxService),
                new Bill(individualEnterpreneur, new BigDecimal("500000.80"), taxService),
                new Bill(ooo, new BigDecimal("3500000.78"), taxService),
                new Bill(individualEnterpreneur, new BigDecimal("80000.80"), taxService),
                new Bill(zao, new BigDecimal("5000000.64"), taxService)
        };
        for (Bill bill : bills) {
            bill.payTaxes();

        }
    }
}
