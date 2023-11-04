package inventoryPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class IMS {
    private ArrayList<Product> products = new ArrayList<>(); // ArrayList to store products
    private Scanner scanner = new Scanner(System.in); // Scanner for user input

    // Method to add a product to the inventory
    public void addProduct(int productId, String productName, int stockQuantity, double price) {
        Product newProduct = new Product(productId, productName, stockQuantity, price);
        products.add(newProduct);
        System.out.println("Product added successfully.");
    }

    // Method to modify a product in the inventory
    public void modifyProduct(int productId, String newName, int newStockQuantity, double newPrice) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setProductName(newName);
                product.setStockQuantity(newStockQuantity);
                product.setPrice(newPrice);
                System.out.println("Product modified successfully.");
                return;
            }
        }
        System.out.println("Product ID not found.");
    }

    // Method to remove a product from the inventory
    public void removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                products.remove(i);
                System.out.println("Product removed successfully.");
                return;
            }
        }
        System.out.println("Product ID not found.");
    }

    // Method to display all products available in the inventory
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Products available in stock:");
            for (Product product : products) {
                System.out.println("ID: " + product.getProductId() + ", Name: " + product.getProductName() +
                        ", Stock Quantity: " + product.getStockQuantity() + ", Price: " + product.getPrice());
            }
        }
    }

    // Main method to run the inventory management system
    public static void main(String[] args) {
        IMS inventorySystem = new IMS(); // Create an instance of IMS
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Modify Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Stock Quantity: ");
                    int stockQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    inventorySystem.addProduct(productId, productName, stockQuantity, price);
                    break;
                case 2:
                    System.out.print("Enter Product ID to modify: ");
                    int modifyId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Stock Quantity: ");
                    int newStock = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();
                    inventorySystem.modifyProduct(modifyId, newName, newStock, newPrice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventorySystem.removeProduct(removeId);
                    break;
                case 4:
                    inventorySystem.displayAllProducts();
                    break;
                case 5:
                    System.out.println("Exiting the Inventory Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
