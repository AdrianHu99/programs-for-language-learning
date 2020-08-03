package biliwwj.ch2_strategy;

public class StaffPayment {
    private double salary;
    private double bonus;
    private TaxCalculationStrategy taxCalculationStrategy;

    public StaffPayment(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public void setTaxCalculationStrategy(TaxCalculationStrategy taxCalculationStrategy) {
        this.taxCalculationStrategy = taxCalculationStrategy;
    }

    public double calculate() {
        return taxCalculationStrategy.calculateTax(salary, bonus);
    }
}
