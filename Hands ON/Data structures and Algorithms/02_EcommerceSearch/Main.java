import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    // Linear Search
    public static Product linearSearch(Product[] products, String key) {

        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(key)) {
                return p;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String key) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = products[mid].productName.compareToIgnoreCase(key);

            if (result == 0)
                return products[mid];

            else if (result < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Keyboard", "Electronics"),
                new Product(103, "Mobile", "Electronics"),
                new Product(104, "Mouse", "Accessories"),
                new Product(105, "Speaker", "Audio")

        };

        System.out.println("----- Products -----");

        for (Product p : products)
            System.out.println(p);

        System.out.print("Enter Product Name to Search: ");
        String key = sc.nextLine();

        // Linear Search

        Product linearResult = linearSearch(products, key);

        if (linearResult != null) {

            System.out.println("\nProduct Found using Linear Search");
            System.out.println(linearResult);

        } else {

            System.out.println("\nProduct Not Found (Linear Search)");
        }

        // Sort for Binary Search

        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        Product binaryResult = binarySearch(products, key);

        if (binaryResult != null) {

            System.out.println("Product Found using Binary Search");
            System.out.println(binaryResult);

        } else {

            System.out.println("Product Not Found (Binary Search)");
        }

        sc.close();
    }
}