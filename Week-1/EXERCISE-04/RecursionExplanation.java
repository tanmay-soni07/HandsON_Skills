/**
 * RecursionExplanation - Explains recursion concepts and benefits
 * Provides learning material for understanding recursive algorithms
 */
public class RecursionExplanation {
    
    /**
     * Get complete recursion explanation
     */
    public static String getRecursionExplanation() {
        return "UNDERSTANDING RECURSION\n" +
               "=======================\n\n" +
               
               "WHAT IS RECURSION?\n" +
               "──────────────────\n" +
               "Recursion is when a function calls itself directly or indirectly.\n" +
               "It solves a problem by breaking it into smaller subproblems of the same type.\n\n" +
               
               "KEY COMPONENTS:\n" +
               "1. BASE CASE: Condition where recursion stops (termination)\n" +
               "2. RECURSIVE CASE: Function calls itself with modified parameters\n" +
               "3. PROGRESS: Each call gets closer to the base case\n\n" +
               
               "EXAMPLE: Calculate Factorial\n" +
               "─────────────────────────────\n" +
               "fact(n) = n * fact(n-1)     // Recursive case\n" +
               "fact(0) = 1                 // Base case\n\n" +
               
               "fact(5):\n" +
               "  = 5 * fact(4)\n" +
               "  = 5 * 4 * fact(3)\n" +
               "  = 5 * 4 * 3 * fact(2)\n" +
               "  = 5 * 4 * 3 * 2 * fact(1)\n" +
               "  = 5 * 4 * 3 * 2 * 1 * fact(0)\n" +
               "  = 5 * 4 * 3 * 2 * 1 * 1\n" +
               "  = 120\n\n" +
               
               "RECURSION CALL STACK:\n" +
               "─────────────────────\n" +
               "When fact(5) is called:\n" +
               "  fact(5) waits for fact(4)\n" +
               "    fact(4) waits for fact(3)\n" +
               "      fact(3) waits for fact(2)\n" +
               "        fact(2) waits for fact(1)\n" +
               "          fact(1) waits for fact(0)\n" +
               "            fact(0) returns 1 ← Base case reached\n" +
               "          fact(1) returns 1\n" +
               "        fact(2) returns 2\n" +
               "      fact(3) returns 6\n" +
               "    fact(4) returns 24\n" +
               "  fact(5) returns 120\n";
    }
    
    /**
     * Get benefits of recursion
     */
    public static String getRecursionBenefits() {
        return "BENEFITS OF RECURSION\n" +
               "======================\n\n" +
               
               "1. SIMPLIFIES CODE\n" +
               "   ────────────────\n" +
               "   Converts complex iterative logic into simple recursive calls\n" +
               "   Example: Tree traversal is more natural with recursion\n" +
               "   Code is often cleaner and easier to understand\n\n" +
               
               "2. NATURAL FIT FOR CERTAIN PROBLEMS\n" +
               "   ─────────────────────────────────\n" +
               "   Divide and Conquer: Problems with recursive structure\n" +
               "   Examples:\n" +
               "     - Tree/Graph traversal\n" +
               "     - Binary search\n" +
               "     - Merge sort\n" +
               "     - Dynamic programming\n\n" +
               
               "3. REDUCES CODE DUPLICATION\n" +
               "   ────────────────────────\n" +
               "   Single function handles multiple levels of complexity\n" +
               "   No need to write separate loops for each level\n\n" +
               
               "4. MATHEMATICAL ELEGANCE\n" +
               "   ──────────────────────\n" +
               "   Matches mathematical definitions naturally\n" +
               "   Example: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)\n\n" +
               
               "5. EASIER TO PROVE CORRECTNESS\n" +
               "   ────────────────────────────\n" +
               "   Mathematical induction aligns with recursion\n" +
               "   Proof by induction mirrors recursive structure\n";
    }
    
    /**
     * Get disadvantages and when NOT to use recursion
     */
    public static String getRecursionDisadvantages() {
        return "DISADVANTAGES OF RECURSION\n" +
               "===========================\n\n" +
               
               "1. STACK OVERFLOW RISK\n" +
               "   ───────────────────\n" +
               "   Each recursive call uses stack memory\n" +
               "   Too many calls can overflow the stack\n" +
               "   Default Java stack: ~1000 depth\n\n" +
               
               "2. PERFORMANCE OVERHEAD\n" +
               "   ─────────────────────\n" +
               "   Function calls are expensive (setup, return)\n" +
               "   Loops are typically faster than recursion\n" +
               "   Example: O(n) loop faster than O(n) recursion\n\n" +
               
               "3. REPEATED CALCULATIONS\n" +
               "   ──────────────────────\n" +
               "   Naive recursion may calculate same subproblem multiple times\n" +
               "   Example: Fibonacci(n) recalculates Fibonacci(n-1) many times\n" +
               "   Complexity can explode: O(2^n) instead of O(n)\n\n" +
               
               "4. DIFFICULT TO DEBUG\n" +
               "   ───────────────────\n" +
               "   Stack trace can be confusing with deep recursion\n" +
               "   Hard to track which level of recursion has the bug\n\n" +
               
               "WHEN NOT TO USE RECURSION:\n" +
               "───────────────────────────\n" +
               "• Simple loops (use iteration instead)\n" +
               "• When iterative solution is simpler\n" +
               "• Large datasets (stack overflow risk)\n" +
               "• Performance-critical code (overhead)\n" +
               "• When repeated calculations occur (use memoization if needed)";
    }
    
    /**
     * Get recursion vs iteration comparison
     */
    public static String getRecursionVsIteration() {
        return "RECURSION vs ITERATION\n" +
               "======================\n\n" +
               
               "RECURSION:\n" +
               "──────────\n" +
               "Pros:\n" +
               "  ✓ Natural for problems with recursive structure\n" +
               "  ✓ Code is often cleaner and more elegant\n" +
               "  ✓ Easier to understand for certain problems\n" +
               "\n" +
               "Cons:\n" +
               "  ✗ Stack overflow risk\n" +
               "  ✗ Slower due to function call overhead\n" +
               "  ✗ Harder to debug\n" +
               "  ✗ May have repeated calculations\n\n" +
               
               "ITERATION:\n" +
               "──────────\n" +
               "Pros:\n" +
               "  ✓ No stack overflow risk\n" +
               "  ✓ Generally faster\n" +
               "  ✓ Easier to debug\n" +
               "  ✓ No repeated calculations\n" +
               "\n" +
               "Cons:\n" +
               "  ✗ Can be verbose for complex problems\n" +
               "  ✗ Less elegant code\n" +
               "  ✗ Harder to understand for some problems\n\n" +
               
               "WHEN TO USE EACH:\n" +
               "──────────────────\n" +
               "Use RECURSION for:\n" +
               "  • Tree/Graph traversal\n" +
               "  • Divide and conquer problems\n" +
               "  • Mathematical sequences\n" +
               "  • When problem naturally maps to recursion\n" +
               "\n" +
               "Use ITERATION for:\n" +
               "  • Simple loops\n" +
               "  • Performance-critical code\n" +
               "  • Large datasets\n" +
               "  • When iterative solution is simpler";
    }
}
