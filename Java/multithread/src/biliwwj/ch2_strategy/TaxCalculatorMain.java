package biliwwj.ch2_strategy;

public class TaxCalculatorMain {

    public static void main(String[] args) {
        StaffPayment tax1 = new StaffPayment(10000, 2000);
        TaxCalculationStrategy taxStrategy = new SimpleTaxCalculationStrategy();
        tax1.setTaxCalculationStrategy(taxStrategy);

        System.out.println(tax1.calculate());
    }
}
