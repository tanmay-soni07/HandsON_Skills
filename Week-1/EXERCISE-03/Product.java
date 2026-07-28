/**
 * Product class - Represents a product in the e-commerce platform
 * Contains attributes for searching: productId, productName, category
 */
public class Product implements Comparable<Product> {
    
    private int productId;
    private String productName;
    private String category;
    private double price;
    
    /**
     * Constructor for Product
     * @param productId unique identifier for product
     * @param productName name of the product
     * @param category category of the product
     * @param price price of the product
     */
    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
    
    // Getters
    public int getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }
    
    /**
     * Compare products by productId for sorting
     * @param other the product to compare with
     * @return comparison result
     */
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
    
    /**
     * String representation of product
     */
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Category: %s | Price: $%.2f",
                productId, productName, category, price);
    }
    
    /**
     * Equality check based on productId
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId == product.productId;
    }
}
