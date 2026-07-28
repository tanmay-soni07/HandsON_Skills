import java.util.Arrays;

/**
 * SearchAlgorithmTest - Test class for comparing search algorithms
 * Demonstrates linear vs binary search with performance analysis
 */
public class SearchAlgorithmTest {
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("E-Commerce Search Algorithm Analysis");
        System.out.println("Big O Notation & Algorithm Complexity");
        System.out.println("═══════════════════════════════════════════════════════\n");
        
        // Test 1: Big O Notation Explanation
        System.out.println("TEST 1: Big O Notation Explanation");
        System.out.println("───────────────────────────────────────────────────────\n");
        testBigONotation();
        
        // Test 2: Case Analysis
        System.out.println("\n\nTEST 2: Best, Average, Worst Case Analysis");
        System.out.println("───────────────────────────────────────────────────────\n");
        testCaseAnalysis();
        
        // Test 3: Linear Search Performance
        System.out.println("\n\nTEST 3: Linear Search Implementation & Performance");
        System.out.println("───────────────────────────────────────────────────────\n");
        testLinearSearch();
        
        // Test 4: Binary Search Performance
        System.out.println("\n\nTEST 4: Binary Search Implementation & Performance");
        System.out.println("───────────────────────────────────────────────────────\n");
        testBinarySearch();
        
        // Test 5: Performance Comparison
        System.out.println("\n\nTEST 5: Linear vs Binary Search - Performance Comparison");
        System.out.println("───────────────────────────────────────────────────────\n");
        testPerformanceComparison();
        
        // Test 6: Platform Recommendation
        System.out.println("\n\nTEST 6: E-Commerce Platform Recommendation");
        System.out.println("───────────────────────────────────────────────────────\n");
        testPlatformRecommendation();
    }
    
    /**
     * Test 1: Display Big O Notation explanation
     */
    public static void testBigONotation() {
        System.out.println(BigONotationAnalysis.getNotationExplanation());
    }
    
    /**
     * Test 2: Display case analysis explanation
     */
    public static void testCaseAnalysis() {
        System.out.println(BigONotationAnalysis.getCaseAnalysisExplanation());
    }
    
    /**
     * Test 3: Test linear search with different scenarios
     */
    public static void testLinearSearch() {
        Product[] products = createProductArray(1000);
        LinearSearch linearSearch = new LinearSearch();
        
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println(linearSearch.getTimeComplexity());
        
        // Best case: First element
        System.out.println("\n--- BEST CASE: Element at start ---");
        Product result = linearSearch.searchById(products, 1);
        System.out.println("Searching for ID: 1");
        System.out.println("Found: " + result);
        System.out.println("Comparisons: " + linearSearch.getComparisons());
        
        // Average case: Middle element
        System.out.println("\n--- AVERAGE CASE: Element in middle ---");
        result = linearSearch.searchById(products, 500);
        System.out.println("Searching for ID: 500");
        System.out.println("Found: " + result);
        System.out.println("Comparisons: " + linearSearch.getComparisons());
        
        // Worst case: Element at end
        System.out.println("\n--- WORST CASE: Element at end ---");
        result = linearSearch.searchById(products, 1000);
        System.out.println("Searching for ID: 1000");
        System.out.println("Found: " + result);
        System.out.println("Comparisons: " + linearSearch.getComparisons());
        
        // Worst case: Element not found
        System.out.println("\n--- WORST CASE: Element not found ---");
        result = linearSearch.searchById(products, 5000);
        System.out.println("Searching for ID: 5000");
        System.out.println("Found: " + result);
        System.out.println("Comparisons: " + linearSearch.getComparisons());
    }
    
    /**
     * Test 4: Test binary search with different scenarios
     */
    public static void testBinarySearch() {
        Product[] products = createProductArray(1000);
        Arrays.sort(products); // Binary search requires sorted array
        BinarySearch binarySearch = new BinarySearch();
        
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println(binarySearch.getTimeComplexity());
        
        // Best case: Middle element
        System.out.println("\n--- BEST CASE: Element at middle position ---");
        Product result = binarySearch.searchById(products, 500);
        System.out.println("Searching for ID: 500");
        System.out.println("Found: " + result);
        System.out.println("Comparisons: " + binarySearch.getComparisons());
        System.out.println("Log₂(1000) ≈ 10, actual: " + binarySearch.getComparisons());
        
        // Average case: Random element
        System.out.println("\n--- AVERAGE CASE: Element at random position ---");
        result = binarySearch.searchById(products, 250);
        System.out.println("Searching for ID: 250");
        System.out.println("Found: " + result);
        System.out.println("Comparisons: " + binarySearch.getComparisons());
        
        // Worst case: Element not found
        System.out.println("\n--- WORST CASE: Element not found ---");
        result = binarySearch.searchById(products, 5000);
        System.out.println("Searching for ID: 5000");
        System.out.println("Found: " + result);
        System.out.println("Comparisons: " + binarySearch.getComparisons());
    }
    
    /**
     * Test 5: Compare performance of both algorithms
     */
    public static void testPerformanceComparison() {
        Product[] unsorted = createProductArray(100000);
        Product[] sorted = unsorted.clone();
        Arrays.sort(sorted);
        
        LinearSearch linearSearch = new LinearSearch();
        BinarySearch binarySearch = new BinarySearch();
        
        System.out.println("Dataset size: 100,000 products\n");
        
        // Test 1: Search for element in middle
        System.out.println("--- Searching for element in middle (ID: 50000) ---");
        long startTime = System.nanoTime();
        linearSearch.searchById(unsorted, 50000);
        long linearTime = System.nanoTime() - startTime;
        long linearComps = linearSearch.getComparisons();
        
        startTime = System.nanoTime();
        binarySearch.searchById(sorted, 50000);
        long binaryTime = System.nanoTime() - startTime;
        long binaryComps = binarySearch.getComparisons();
        
        System.out.println("Linear Search:");
        System.out.println("  Comparisons: " + linearComps);
        System.out.println("  Time: " + linearTime + " ns");
        System.out.println("\nBinary Search:");
        System.out.println("  Comparisons: " + binaryComps);
        System.out.println("  Time: " + binaryTime + " ns");
        System.out.println("\nComparison Reduction: " + (linearComps / binaryComps) + "x fewer comparisons");
        
        // Test 2: Search for non-existent element
        System.out.println("\n--- Searching for non-existent element (ID: 999999) ---");
        startTime = System.nanoTime();
        linearSearch.searchById(unsorted, 999999);
        linearTime = System.nanoTime() - startTime;
        linearComps = linearSearch.getComparisons();
        
        startTime = System.nanoTime();
        binarySearch.searchById(sorted, 999999);
        binaryTime = System.nanoTime() - startTime;
        binaryComps = binarySearch.getComparisons();
        
        System.out.println("Linear Search:");
        System.out.println("  Comparisons: " + linearComps);
        System.out.println("  Time: " + linearTime + " ns");
        System.out.println("\nBinary Search:");
        System.out.println("  Comparisons: " + binaryComps);
        System.out.println("  Time: " + binaryTime + " ns");
        System.out.println("\nComparison Reduction: " + (linearComps / binaryComps) + "x fewer comparisons");
    }
    
    /**
     * Test 6: Platform recommendation
     */
    public static void testPlatformRecommendation() {
        System.out.println(BigONotationAnalysis.getSearchComparison());
        System.out.println("\n");
        System.out.println(BigONotationAnalysis.getPlatformRecommendation());
    }
    
    /**
     * Create a sample product array
     * @param size number of products to create
     * @return array of products
     */
    private static Product[] createProductArray(int size) {
        Product[] products = new Product[size];
        
        String[] categories = {"Electronics", "Clothing", "Books", "Home", "Sports"};
        
        for (int i = 0; i < size; i++) {
            int id = i + 1;
            String name = "Product_" + id;
            String category = categories[i % categories.length];
            double price = 10 + (i % 990);
            
            products[i] = new Product(id, name, category, price);
        }
        
        return products;
    }
}
