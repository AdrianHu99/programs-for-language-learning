package biliwwj.ch2_strategy;

public class SimpleTaxCalculationStrategy implements TaxCalculationStrategy {
    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculateTax(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
