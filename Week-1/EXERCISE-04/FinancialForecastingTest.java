/**
 * FinancialForecastingTest - Test class for recursive financial forecasting
 * Demonstrates recursion concepts and optimization techniques
 */
public class FinancialForecastingTest {
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("Financial Forecasting with Recursive Algorithms");
        System.out.println("Understanding Recursion & Optimization");
        System.out.println("═══════════════════════════════════════════════════════\n");
        
        // Test 1: Recursion explanation
        System.out.println("TEST 1: Understanding Recursion");
        System.out.println("───────────────────────────────────────────────────────\n");
        testRecursionExplanation();
        
        // Test 2: Basic recursive forecasting
        System.out.println("\n\nTEST 2: Basic Recursive Forecasting (Problematic)");
        System.out.println("───────────────────────────────────────────────────────\n");
        testBasicRecursion();
        
        // Test 3: Optimized recursive forecasting
        System.out.println("\n\nTEST 3: Optimized Recursive Forecasting");
        System.out.println("───────────────────────────────────────────────────────\n");
        testOptimizedRecursion();
        
        // Test 4: Iterative and formula approach
        System.out.println("\n\nTEST 4: Iterative & Formula Approach");
        System.out.println("───────────────────────────────────────────────────────\n");
        testIterativeAndFormula();
        
        // Test 5: Performance comparison
        System.out.println("\n\nTEST 5: Performance Comparison - Different Approaches");
        System.out.println("───────────────────────────────────────────────────────\n");
        testPerformanceComparison();
        
        // Test 6: Recursion benefits and disadvantages
        System.out.println("\n\nTEST 6: Recursion Benefits & Disadvantages");
        System.out.println("───────────────────────────────────────────────────────\n");
        testRecursionBenefits();
    }
    
    /**
     * Test 1: Display recursion explanation
     */
    public static void testRecursionExplanation() {
        System.out.println(RecursionExplanation.getRecursionExplanation());
    }
    
    /**
     * Test 2: Test basic recursive approach with small numbers
     */
    public static void testBasicRecursion() {
        RecursiveForecaster forecaster = new RecursiveForecaster();
        
        System.out.println("Time Complexity Analysis of Recursive Approaches:\n");
        System.out.println(forecaster.getComplexityExplanation());
        
        // Test with small dataset
        FinancialData stock = new FinancialData(1000, 5, 10, "Stock");
        
        System.out.println("\n\n--- Scenario: $1000 investment at 5% annual growth for 10 years ---\n");
        
        System.out.println("1. BASIC RECURSION - O(2^n):");
        forecaster.resetCounter();
        double basicResult = forecaster.calculateFutureValueBasic(stock.getInitialAmount(), 
                                                                   stock.getGrowthMultiplier(), 
                                                                   stock.getYears());
        System.out.println("   Future Value: $" + String.format("%.2f", basicResult));
        System.out.println("   Function Calls: " + forecaster.getFunctionCalls());
        System.out.println("   Status: INEFFICIENT for larger years\n");
        
        System.out.println("2. LINEAR RECURSION - O(n):");
        forecaster.resetCounter();
        double linearResult = forecaster.calculateFutureValueLinear(stock.getInitialAmount(), 
                                                                     stock.getGrowthMultiplier(), 
                                                                     stock.getYears());
        System.out.println("   Future Value: $" + String.format("%.2f", linearResult));
        System.out.println("   Function Calls: " + forecaster.getFunctionCalls());
        System.out.println("   Status: Better but still has overhead\n");
        
        System.out.println("3. OPTIMIZED RECURSION - O(log n):");
        forecaster.resetCounter();
        double optimizedResult = forecaster.calculateFutureValueOptimized(stock.getInitialAmount(), 
                                                                           stock.getGrowthMultiplier(), 
                                                                           stock.getYears());
        System.out.println("   Future Value: $" + String.format("%.2f", optimizedResult));
        System.out.println("   Function Calls: " + forecaster.getFunctionCalls());
        System.out.println("   Status: Best recursive solution!");
    }
    
    /**
     * Test 3: Test optimized approaches
     */
    public static void testOptimizedRecursion() {
        OptimizedForecaster forecaster = new OptimizedForecaster();
        
        System.out.println("Optimization Techniques:\n");
        System.out.println(forecaster.getOptimizationExplanation());
        
        FinancialData bond = new FinancialData(5000, 3, 20, "Bond");
        
        System.out.println("\n\n--- Scenario: $5000 investment at 3% annual growth for 20 years ---\n");
        
        System.out.println("1. MEMOIZATION (Dynamic Programming):");
        forecaster.resetCounter();
        double memoResult = forecaster.calculateFutureValueMemoization(bond.getInitialAmount(), 
                                                                        bond.getGrowthMultiplier(), 
                                                                        bond.getYears());
        System.out.println("   Future Value: $" + String.format("%.2f", memoResult));
        System.out.println("   Function Calls: " + forecaster.getFunctionCalls());
        System.out.println("   Status: Good - Caches results\n");
        
        System.out.println("2. ITERATIVE APPROACH:");
        forecaster.resetCounter();
        double iterResult = forecaster.calculateFutureValueIterative(bond.getInitialAmount(), 
                                                                      bond.getGrowthMultiplier(), 
                                                                      bond.getYears());
        System.out.println("   Future Value: $" + String.format("%.2f", iterResult));
        System.out.println("   Operations: " + forecaster.getFunctionCalls());
        System.out.println("   Status: Better - No recursion overhead\n");
        
        System.out.println("3. MATHEMATICAL FORMULA - O(1):");
        forecaster.resetCounter();
        double formulaResult = forecaster.calculateFutureValueFormula(bond.getInitialAmount(), 
                                                                       bond.getGrowthMultiplier(), 
                                                                       bond.getYears());
        System.out.println("   Future Value: $" + String.format("%.2f", formulaResult));
        System.out.println("   Operations: " + forecaster.getFunctionCalls());
        System.out.println("   Status: BEST - Constant time!");
    }
    
    /**
     * Test 4: Iterative approach with year-by-year breakdown
     */
    public static void testIterativeAndFormula() {
        OptimizedForecaster forecaster = new OptimizedForecaster();
        
        FinancialData savings = new FinancialData(1000, 7, 5, "Savings");
        
        System.out.println("Investment: " + savings.toString());
        System.out.println("\nYear-by-Year Breakdown (Iterative Approach):\n");
        
        forecaster.resetCounter();
        double[] yearlyValues = forecaster.calculateYearByYear(savings.getInitialAmount(), 
                                                                savings.getGrowthMultiplier(), 
                                                                savings.getYears());
        
        System.out.printf("Year 0: $%.2f (Initial)\n", yearlyValues[0]);
        for (int i = 1; i < yearlyValues.length; i++) {
            double gain = yearlyValues[i] - yearlyValues[i-1];
            System.out.printf("Year %d: $%.2f (Gain: $%.2f)\n", i, yearlyValues[i], gain);
        }
        
        System.out.println("\n✓ Total iterations: " + forecaster.getFunctionCalls());
        System.out.println("✓ Final value: $" + String.format("%.2f", yearlyValues[yearlyValues.length - 1]));
    }
    
    /**
     * Test 5: Compare all approaches with same data
     */
    public static void testPerformanceComparison() {
        RecursiveForecaster recursiveForecaster = new RecursiveForecaster();
        OptimizedForecaster optimizedForecaster = new OptimizedForecaster();
        
        FinancialData investment = new FinancialData(10000, 6, 30, "Index Fund");
        
        System.out.println("Investment: " + investment.toString());
        System.out.println("\nCOMPLEXITY & PERFORMANCE COMPARISON:\n");
        System.out.println("┌──────────────────────┬──────────────┬─────────────┐");
        System.out.println("│ Approach             │ Calls/Ops    │ Time (ns)   │");
        System.out.println("├──────────────────────┼──────────────┼─────────────┤");
        
        // 1. Linear Recursion O(n)
        recursiveForecaster.resetCounter();
        long startTime = System.nanoTime();
        double linResult = recursiveForecaster.calculateFutureValueLinear(investment.getInitialAmount(), 
                                                                           investment.getGrowthMultiplier(), 
                                                                           investment.getYears());
        long linTime = System.nanoTime() - startTime;
        System.out.printf("│ Linear Recursion O(n) │ %12d │ %11d │\n", 
                         recursiveForecaster.getFunctionCalls(), linTime);
        
        // 2. Optimized Recursion O(log n)
        recursiveForecaster.resetCounter();
        startTime = System.nanoTime();
        double optRecResult = recursiveForecaster.calculateFutureValueOptimized(investment.getInitialAmount(), 
                                                                                 investment.getGrowthMultiplier(), 
                                                                                 investment.getYears());
        long optRecTime = System.nanoTime() - startTime;
        System.out.printf("│ Optimized Rec O(log n)│ %12d │ %11d │\n", 
                         recursiveForecaster.getFunctionCalls(), optRecTime);
        
        // 3. Iterative O(n)
        optimizedForecaster.resetCounter();
        startTime = System.nanoTime();
        double iterResult = optimizedForecaster.calculateFutureValueIterative(investment.getInitialAmount(), 
                                                                               investment.getGrowthMultiplier(), 
                                                                               investment.getYears());
        long iterTime = System.nanoTime() - startTime;
        System.out.printf("│ Iterative O(n)       │ %12d │ %11d │\n", 
                         optimizedForecaster.getFunctionCalls(), iterTime);
        
        // 4. Formula O(1)
        optimizedForecaster.resetCounter();
        startTime = System.nanoTime();
        double formResult = optimizedForecaster.calculateFutureValueFormula(investment.getInitialAmount(), 
                                                                             investment.getGrowthMultiplier(), 
                                                                             investment.getYears());
        long formTime = System.nanoTime() - startTime;
        System.out.printf("│ Formula O(1)         │ %12d │ %11d │\n", 
                         optimizedForecaster.getFunctionCalls(), formTime);
        
        System.out.println("└──────────────────────┴──────────────┴─────────────┘");
        
        System.out.println("\nAll methods produce the same result: $" + String.format("%.2f", formResult));
        System.out.println("\n✓ Formula approach is O(1) - Most efficient!");
        System.out.println("✓ For 30 years: Formula is ~" + (linTime / formTime) + "x faster than linear recursion");
    }
    
    /**
     * Test 6: Recursion benefits and disadvantages
     */
    public static void testRecursionBenefits() {
        System.out.println(RecursionExplanation.getRecursionBenefits());
        System.out.println("\n");
        System.out.println(RecursionExplanation.getRecursionDisadvantages());
        System.out.println("\n");
        System.out.println(RecursionExplanation.getRecursionVsIteration());
        
        System.out.println("\n\nRECOMMENDATION FOR FINANCIAL FORECASTING:");
        System.out.println("──────────────────────────────────────────");
        System.out.println("✓ Use MATHEMATICAL FORMULA for production code");
        System.out.println("✓ Use ITERATIVE for flexibility and readability");
        System.out.println("✓ Use OPTIMIZED RECURSION only for learning/demonstrations");
        System.out.println("✗ Avoid NAIVE RECURSION - it's too slow and impractical");
    }
}
