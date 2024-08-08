package Data_Structures_and_Algorithms.FinancialForecasting;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years <= 0) {
            return initialValue;
        } else {
            return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
        }
    }

    public static void main(String[] args) {
        // Example usage
        double initialValue = 1000.0; // Initial investment
        double annualGrowthRate = 0.05; // 5% growth rate
        int forecastYears = 10; // Number of years to forecast

        double futureValue = calculateFutureValue(initialValue, annualGrowthRate, forecastYears);
        System.out.printf("The future value after %d years is: $%.2f%n", forecastYears, futureValue);
    }
}
