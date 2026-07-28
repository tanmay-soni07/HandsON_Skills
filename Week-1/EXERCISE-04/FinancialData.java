/**
 * FinancialData class - Represents financial data for forecasting
 * Stores initial investment, growth rates, and periods
 */
public class FinancialData {
    
    private double initialAmount;
    private double annualGrowthRate;
    private int years;
    private String investmentType;
    
    /**
     * Constructor for FinancialData
     * @param initialAmount initial investment amount
     * @param annualGrowthRate annual growth rate (as percentage, e.g., 5 for 5%)
     * @param years number of years to forecast
     * @param investmentType type of investment (e.g., "Stock", "Bond", "Savings")
     */
    public FinancialData(double initialAmount, double annualGrowthRate, int years, String investmentType) {
        this.initialAmount = initialAmount;
        this.annualGrowthRate = annualGrowthRate;
        this.years = years;
        this.investmentType = investmentType;
    }
    
    // Getters
    public double getInitialAmount() {
        return initialAmount;
    }
    
    public double getAnnualGrowthRate() {
        return annualGrowthRate;
    }
    
    public int getYears() {
        return years;
    }
    
    public String getInvestmentType() {
        return investmentType;
    }
    
    /**
     * Get growth multiplier (1 + rate/100)
     * @return growth multiplier
     */
    public double getGrowthMultiplier() {
        return 1 + (annualGrowthRate / 100);
    }
    
    /**
     * String representation of financial data
     */
    @Override
    public String toString() {
        return String.format("Investment Type: %s | Initial: $%.2f | Growth Rate: %.2f%% | Years: %d",
                investmentType, initialAmount, annualGrowthRate, years);
    }
}
