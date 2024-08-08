import java.util.Arrays;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class Main {

    // Linear Search Algorithm
    public static Product linearSearch(Product[] products, int searchId) {
        for (Product product : products) {
            if (product.getProductId() == searchId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search Algorithm
    public static Product binarySearch(Product[] products, int searchId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == searchId) {
                return products[mid];
            } else if (products[mid].getProductId() < searchId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    private static void printProduct(Product product) {
        if (product != null) {
            System.out.println("Found: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Table", "Furniture"),
                new Product(2, "Laptop", "Electronic Gadget"),
                new Product(3, "Mobile Phone", "Electronic Gadget")
        };

        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        System.out.println("Testing Linear Search:");
        Product result = linearSearch(products, 3);
        printProduct(result);

        System.out.println("\nTesting Binary Search:");
        result = binarySearch(products, 3);
        printProduct(result);
    }
}
