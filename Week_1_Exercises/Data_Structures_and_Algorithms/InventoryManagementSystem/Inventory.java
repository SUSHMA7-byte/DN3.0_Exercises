package Data_Structures_and_Algorithms.InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManager {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }
}

public class Inventory {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Test addProduct
        Product product1 = new Product(1, "LED TV", 10, 19.99);
        manager.addProduct(product1);
        System.out.println("Added: " + manager.getProduct(1));

        // Test updateProduct
        Product updatedProduct1 = new Product(1, "LED TV", 15, 18.99);
        manager.updateProduct(updatedProduct1);
        System.out.println("Updated: " + manager.getProduct(1));

        // Test deleteProduct
        manager.deleteProduct(1);
        System.out.println("Deleted: " + manager.getProduct(1));
    }
}
