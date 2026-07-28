/**
 * RecursiveForecaster - Implements recursive financial forecasting
 * Time Complexity: O(2^n) - Exponential (inefficient, shown for learning)
 * Shows problems with naive recursion
 */
public class RecursiveForecaster {
    
    private long functionCalls;
    
    /**
     * Constructor
     */
    public RecursiveForecaster() {
        this.functionCalls = 0;
    }
    
    /**
     * Calculate future value using basic recursion
     * Time Complexity: O(2^n) - EXPONENTIAL (very slow!)
     * Space Complexity: O(n) - Recursion call stack
     * 
     * Formula: FutureValue(n) = Initial * (1 + rate)^n
     * Recursive: FutureValue(n) = FutureValue(n-1) * (1 + rate)
     * 
     * @param initialAmount the initial investment
     * @param growthMultiplier the growth multiplier (1 + rate)
     * @param yearsRemaining remaining years to calculate
     * @return future value after yearsRemaining
     */
    public double calculateFutureValueBasic(double initialAmount, double growthMultiplier, int yearsRemaining) {
        functionCalls++;
        
        // Base case: no more years
        if (yearsRemaining == 0) {
            return initialAmount;
        }
        
        // Recursive case: multiply by growth and recurse
        return calculateFutureValueBasic(initialAmount * growthMultiplier, growthMultiplier, yearsRemaining - 1);
    }
    
    /**
     * Calculate future value using power-based recursion
     * Time Complexity: O(n) - Linear recursion
     * Better approach: divides by multiplying at each level
     * 
     * @param initialAmount the initial investment
     * @param growthMultiplier the growth multiplier
     * @param yearsRemaining remaining years
     * @return future value
     */
    public double calculateFutureValueLinear(double initialAmount, double growthMultiplier, int yearsRemaining) {
        functionCalls++;
        
        // Base case
        if (yearsRemaining == 0) {
            return initialAmount;
        }
        
        // Linear recursion
        return growthMultiplier * calculateFutureValueLinear(initialAmount, growthMultiplier, yearsRemaining - 1);
    }
    
    /**
     * Calculate future value using power recursion (divide and conquer)
     * Time Complexity: O(log n) - Logarithmic recursion
     * Most efficient recursive approach
     * 
     * Uses: (1+r)^n = ((1+r)^(n/2))^2
     * 
     * @param initialAmount the initial investment
     * @param growthMultiplier the growth multiplier
     * @param yearsRemaining remaining years
     * @return future value
     */
    public double calculateFutureValueOptimized(double initialAmount, double growthMultiplier, int yearsRemaining) {
        functionCalls++;
        
        // Base cases
        if (yearsRemaining == 0) {
            return initialAmount;
        }
        if (yearsRemaining == 1) {
            return initialAmount * growthMultiplier;
        }
        
        // Divide and conquer approach
        if (yearsRemaining % 2 == 0) {
            // Even: (1+r)^n = ((1+r)^(n/2))^2
            double halfValue = calculateFutureValueOptimized(initialAmount, growthMultiplier, yearsRemaining / 2);
            return halfValue * halfValue / initialAmount;
        } else {
            // Odd: (1+r)^n = (1+r) * (1+r)^(n-1)
            return growthMultiplier * calculateFutureValueOptimized(initialAmount, growthMultiplier, yearsRemaining - 1);
        }
    }
    
    /**
     * Get the number of function calls made
     * @return number of calls
     */
    public long getFunctionCalls() {
        return functionCalls;
    }
    
    /**
     * Reset function call counter
     */
    public void resetCounter() {
        functionCalls = 0;
    }
    
    /**
     * Get time complexity explanation
     */
    public String getComplexityExplanation() {
        return "RECURSIVE FORECASTING - TIME COMPLEXITY\n" +
               "=========================================\n\n" +
               
               "1. BASIC RECURSION: O(2^n) - EXPONENTIAL\n" +
               "   FutureValue(n) = FutureValue(n-1) * rate\n" +
               "   Problem: Recalculates same values\n" +
               "   For 30 years: ~1 billion function calls!\n" +
               "   Status: TOO SLOW - Not practical\n\n" +
               
               "2. LINEAR RECURSION: O(n) - LINEAR\n" +
               "   FutureValue(n) = growthMultiplier * FutureValue(n-1)\n" +
               "   Improvement: Simpler recursion\n" +
               "   For 30 years: 30 function calls\n" +
               "   Status: Better but still has overhead\n\n" +
               
               "3. OPTIMIZED RECURSION: O(log n) - LOGARITHMIC\n" +
               "   FutureValue(n) = FutureValue(n/2) * FutureValue(n/2)\n" +
               "   Uses divide and conquer\n" +
               "   For 30 years: ~5 function calls\n" +
               "   Status: OPTIMAL - Best recursive solution";
    }
}
