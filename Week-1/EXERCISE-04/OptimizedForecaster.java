import java.util.HashMap;
import java.util.Map;

/**
 * OptimizedForecaster - Implements optimized financial forecasting
 * Uses Memoization and Dynamic Programming to optimize recursion
 * Time Complexity: O(n) with memoization
 */
public class OptimizedForecaster {
    
    private long functionCalls;
    private Map<String, Double> memoCache;
    
    /**
     * Constructor
     */
    public OptimizedForecaster() {
        this.functionCalls = 0;
        this.memoCache = new HashMap<>();
    }
    
    /**
     * Calculate future value using MEMOIZATION (Dynamic Programming)
     * Time Complexity: O(n) - Each year calculated once
     * Space Complexity: O(n) - Cache storage
     * 
     * Stores previously calculated values to avoid recalculation
     * 
     * @param initialAmount the initial investment
     * @param growthMultiplier the growth multiplier
     * @param yearsRemaining remaining years
     * @return future value
     */
    public double calculateFutureValueMemoization(double initialAmount, double growthMultiplier, int yearsRemaining) {
        // Create cache key
        String key = yearsRemaining + "_" + growthMultiplier;
        
        // Check if already calculated
        if (memoCache.containsKey(key)) {
            return memoCache.get(key) * initialAmount;
        }
        
        functionCalls++;
        
        // Base case
        if (yearsRemaining == 0) {
            return initialAmount;
        }
        
        // Recursive case with memoization
        double result = growthMultiplier * calculateFutureValueMemoization(initialAmount, growthMultiplier, yearsRemaining - 1);
        
        // Store in cache
        memoCache.put(key, result / initialAmount);
        
        return result;
    }
    
    /**
     * Calculate future value using ITERATIVE APPROACH (No Recursion)
     * Time Complexity: O(n) - Linear
     * Space Complexity: O(1) - Constant space
     * 
     * Most efficient and practical approach
     * Avoids recursion overhead entirely
     * 
     * @param initialAmount the initial investment
     * @param growthMultiplier the growth multiplier
     * @param years number of years
     * @return future value
     */
    public double calculateFutureValueIterative(double initialAmount, double growthMultiplier, int years) {
        double futureValue = initialAmount;
        
        for (int i = 0; i < years; i++) {
            functionCalls++;
            futureValue *= growthMultiplier;
        }
        
        return futureValue;
    }
    
    /**
     * Calculate future value using MATHEMATICAL FORMULA (Most Efficient)
     * Time Complexity: O(1) - Constant time
     * Space Complexity: O(1) - Constant space
     * 
     * Direct calculation: FutureValue = Initial * (1 + rate)^years
     * Uses Math.pow() for exponentiation
     * 
     * @param initialAmount the initial investment
     * @param growthMultiplier the growth multiplier
     * @param years number of years
     * @return future value
     */
    public double calculateFutureValueFormula(double initialAmount, double growthMultiplier, int years) {
        functionCalls++;
        return initialAmount * Math.pow(growthMultiplier, years);
    }
    
    /**
     * Calculate future value using ITERATIVE with tracking
     * Shows year-by-year breakdown
     * 
     * @param initialAmount the initial investment
     * @param growthMultiplier the growth multiplier
     * @param years number of years
     * @return array of values for each year
     */
    public double[] calculateYearByYear(double initialAmount, double growthMultiplier, int years) {
        double[] yearlyValues = new double[years + 1];
        yearlyValues[0] = initialAmount;
        
        for (int i = 1; i <= years; i++) {
            functionCalls++;
            yearlyValues[i] = yearlyValues[i - 1] * growthMultiplier;
        }
        
        return yearlyValues;
    }
    
    /**
     * Get the number of function calls made
     * @return number of calls
     */
    public long getFunctionCalls() {
        return functionCalls;
    }
    
    /**
     * Reset function call counter and cache
     */
    public void resetCounter() {
        functionCalls = 0;
        memoCache.clear();
    }
    
    /**
     * Get optimization techniques explanation
     */
    public String getOptimizationExplanation() {
        return "OPTIMIZATION TECHNIQUES FOR RECURSION\n" +
               "======================================\n\n" +
               
               "PROBLEM: Naive recursion can be O(2^n) or worse\n\n" +
               
               "SOLUTION 1: MEMOIZATION (Top-Down Dynamic Programming)\n" +
               "──────────────────────────────────────────────────────\n" +
               "Concept: Cache/store previously calculated results\n" +
               "Implementation: HashMap to store computed values\n" +
               "Time: O(n) - Each subproblem solved once\n" +
               "Space: O(n) - Cache storage\n" +
               "Improvement: 2^n → O(n) for overlapping subproblems\n\n" +
               
               "SOLUTION 2: ITERATIVE APPROACH (Eliminate Recursion)\n" +
               "────────────────────────────────────────────────────\n" +
               "Concept: Use loops instead of recursion\n" +
               "Implementation: For loop to calculate iteratively\n" +
               "Time: O(n) - Linear\n" +
               "Space: O(1) - No recursion stack\n" +
               "Advantage: No stack overflow risk, cleaner\n\n" +
               
               "SOLUTION 3: MATHEMATICAL FORMULA (Optimal)\n" +
               "───────────────────────────────────────────\n" +
               "Concept: Use direct mathematical formula\n" +
               "Formula: FutureValue = Initial * (1 + rate)^years\n" +
               "Time: O(1) - Constant time\n" +
               "Space: O(1) - No extra storage\n" +
               "Best For: Financial calculations\n\n" +
               
               "COMPLEXITY COMPARISON:\n" +
               "For 30 years:\n" +
               "  Naive Recursion: O(2^30) = ~1 billion calls\n" +
               "  Linear Recursion: O(30) = 30 calls\n" +
               "  Optimized Recursion: O(log 30) = ~5 calls\n" +
               "  Memoization: O(30) = 30 calls\n" +
               "  Iterative: O(30) = 30 operations\n" +
               "  Formula: O(1) = 1 operation ← BEST!";
    }
}
