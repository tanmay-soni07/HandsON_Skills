import java.util.Arrays;

/**
 * BinarySearch - Implements binary search algorithm
 * Time Complexity: O(log n) - Best: O(1), Average: O(log n), Worst: O(log n)
 * Space Complexity: O(1) for iterative, O(log n) for recursive
 * Prerequisite: Array must be sorted
 */
public class BinarySearch {
    
    private long comparisons;
    
    /**
     * Constructor
     */
    public BinarySearch() {
        this.comparisons = 0;
    }
    
    /**
     * Binary search for product by ID (iterative approach)
     * Time Complexity: O(log n)
     * @param products sorted array of products
     * @param productId the ID to search for
     * @return the product if found, null otherwise
     */
    public Product searchById(Product[] products, int productId) {
        comparisons = 0;
        
        if (products == null || products.length == 0) {
            return null;
        }
        
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;
            
            int midId = products[mid].getProductId();
            
            if (midId == productId) {
                return products[mid];
            } else if (midId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return null;
    }
    
    /**
     * Binary search for product by ID (recursive approach)
     * Time Complexity: O(log n)
     * @param products sorted array of products
     * @param productId the ID to search for
     * @return the product if found, null otherwise
     */
    public Product searchByIdRecursive(Product[] products, int productId) {
        comparisons = 0;
        return searchByIdRecursiveHelper(products, productId, 0, products.length - 1);
    }
    
    /**
     * Helper method for recursive binary search
     */
    private Product searchByIdRecursiveHelper(Product[] products, int productId, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        comparisons++;
        
        int midId = products[mid].getProductId();
        
        if (midId == productId) {
            return products[mid];
        } else if (midId < productId) {
            return searchByIdRecursiveHelper(products, productId, mid + 1, right);
        } else {
            return searchByIdRecursiveHelper(products, productId, left, mid - 1);
        }
    }
    
    /**
     * Find the position of a product ID in sorted array
     * Time Complexity: O(log n)
     * @param products sorted array of products
     * @param productId the ID to find
     * @return index of product, or -1 if not found
     */
    public int findPosition(Product[] products, int productId) {
        comparisons = 0;
        
        if (products == null || products.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;
            
            int midId = products[mid].getProductId();
            
            if (midId == productId) {
                return mid;
            } else if (midId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    /**
     * Get the number of comparisons made
     * @return number of comparisons
     */
    public long getComparisons() {
        return comparisons;
    }
    
    /**
     * Get time complexity information
     * @return time complexity details
     */
    public String getTimeComplexity() {
        return "Binary Search - Time Complexity: O(log n)\n" +
               "  Best Case: O(1) - Element found at middle position\n" +
               "  Average Case: O(log n) - Divide and conquer approach\n" +
               "  Worst Case: O(log n) - Element not found\n" +
               "  Prerequisite: Array must be sorted";
    }
}
