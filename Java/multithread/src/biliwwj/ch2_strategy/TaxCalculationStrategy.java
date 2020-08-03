package biliwwj.ch2_strategy;

@FunctionalInterface
public interface TaxCalculationStrategy {
    double calculateTax(double salary, double bonus);
}
