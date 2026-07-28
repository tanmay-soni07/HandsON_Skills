/**
 * LinearSearch - Implements linear search algorithm
 * Time Complexity: O(n) - Best: O(1), Average: O(n), Worst: O(n)
 * Space Complexity: O(1)
 */
public class LinearSearch {
    
    private long comparisons;
    
    /**
     * Constructor
     */
    public LinearSearch() {
        this.comparisons = 0;
    }
    
    /**
     * Search for product by ID using linear search
     * Time Complexity: O(n)
     * @param products array of products
     * @param productId the ID to search for
     * @return the product if found, null otherwise
     */
    public Product searchById(Product[] products, int productId) {
        comparisons = 0;
        
        if (products == null || products.length == 0) {
            return null;
        }
        
        for (int i = 0; i < products.length; i++) {
            comparisons++;
            if (products[i].getProductId() == productId) {
                return products[i];
            }
        }
        
        return null;
    }
    
    /**
     * Search for product by name using linear search
     * Time Complexity: O(n)
     * @param products array of products
     * @param productName the name to search for
     * @return the product if found, null otherwise
     */
    public Product searchByName(Product[] products, String productName) {
        comparisons = 0;
        
        if (products == null || products.length == 0 || productName == null) {
            return null;
        }
        
        for (int i = 0; i < products.length; i++) {
            comparisons++;
            if (products[i].getProductName().equalsIgnoreCase(productName)) {
                return products[i];
            }
        }
        
        return null;
    }
    
    /**
     * Search for products by category using linear search
     * Time Complexity: O(n)
     * @param products array of products
     * @param category the category to search for
     * @return array of products in the category
     */
    public Product[] searchByCategory(Product[] products, String category) {
        comparisons = 0;
        
        if (products == null || products.length == 0 || category == null) {
            return new Product[0];
        }
        
        // First count matching products
        int count = 0;
        for (int i = 0; i < products.length; i++) {
            comparisons++;
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                count++;
            }
        }
        
        // Create result array
        Product[] result = new Product[count];
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                result[index++] = products[i];
            }
        }
        
        return result;
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
        return "Linear Search - Time Complexity: O(n)\n" +
               "  Best Case: O(1) - Element found at first position\n" +
               "  Average Case: O(n) - Element found in middle\n" +
               "  Worst Case: O(n) - Element not found or at end";
    }
}
