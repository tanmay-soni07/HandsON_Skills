import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Integer, Product> inventory = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    // Add Product
    public static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product product = new Product(id, name, quantity, price);

        inventory.put(id, product);

        System.out.println("Product Added Successfully.\n");
    }

    // Update Product
    public static void updateProduct() {

        System.out.print("Enter Product ID to Update: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {

            sc.nextLine();

            System.out.print("Enter New Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            Product p = inventory.get(id);

            p.setProductName(name);
            p.setQuantity(quantity);
            p.setPrice(price);

            System.out.println("Product Updated Successfully.\n");

        } else {
            System.out.println("Product Not Found.\n");
        }
    }

    // Delete Product
    public static void deleteProduct() {

        System.out.print("Enter Product ID to Delete: ");
        int id = sc.nextInt();

        if (inventory.remove(id) != null) {
            System.out.println("Product Deleted Successfully.\n");
        } else {
            System.out.println("Product Not Found.\n");
        }
    }

    // Display Products
    public static void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty.\n");
            return;
        }

        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    updateProduct();
                    break;

                case 3:
                    deleteProduct();
                    break;

                case 4:
                    displayProducts();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.\n");
            }
        }
    }
}