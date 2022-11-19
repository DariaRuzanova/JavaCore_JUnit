import TaxAgent.IndividualEnterpreneur;
import TaxAgent.OOO;
import TaxAgent.PhysicalPerson;
import TaxAgent.ZAO;
import TaxType.IncomeTaxType;
import TaxType.ProgressiveTaxType;
import TaxType.VATaxType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class TaxTypeTests {

    @BeforeAll
    public static void setupAll() {
        System.out.println("All tests started");
    }

    @AfterAll
    public static void teardownAll() {
        System.out.println("All tests ended");
    }

    @Test
    public void incomeTaxTypeTest() {
        IncomeTaxType incomeTaxType = new IncomeTaxType();
        BigDecimal amount = BigDecimal.valueOf(85000.29);
        BigDecimal expected = BigDecimal.valueOf(11050.0377);

        BigDecimal result = incomeTaxType.calculateTaxFor(amount);

        assertEquals(0, expected.compareTo(result));

    }

    @Test
    public void VATaxTypeTest() {
        VATaxType vaTaxType = new VATaxType();
        BigDecimal amount = BigDecimal.valueOf(3500000.78);
        BigDecimal expected = BigDecimal.valueOf(630000.1404);

        BigDecimal result = vaTaxType.calculateTaxFor(amount);

        assertEquals(0, expected.compareTo(result));
    }

    @Test
    public void ProgressiveTaxTypeTest() {
        ProgressiveTaxType progressiveTaxType = new ProgressiveTaxType();
        BigDecimal[] amounts = {BigDecimal.valueOf(80000.80), BigDecimal.valueOf(500000.80)};
        BigDecimal[] expecteds = {BigDecimal.valueOf(8000.08), BigDecimal.valueOf(75000.12)};
        for (int i = 0; i < 2; i++) {
            BigDecimal amount = amounts[i];
            BigDecimal expected = expecteds[i];

            BigDecimal result = progressiveTaxType.calculateTaxFor(amount);

            assertEquals(0, expected.compareTo(result));
        }
    }

    @Test
    public void billTest() {
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
        BigDecimal[] expecteds = {BigDecimal.valueOf(11050.0377),
                BigDecimal.valueOf(75000.1200),
                BigDecimal.valueOf(630000.1404),
                BigDecimal.valueOf(8000.080),
                BigDecimal.valueOf(900000.1152)};

        for (int i = 0; i < bills.length; i++) {
            BigDecimal taxes = bills[i].payTaxes();
            BigDecimal expected = expecteds[i];

            assertEquals(0, expected.compareTo(taxes));
        }


    }
}
