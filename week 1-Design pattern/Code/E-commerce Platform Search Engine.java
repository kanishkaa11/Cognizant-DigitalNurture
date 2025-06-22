import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Footwear"),
                new Product(103, "Mobile", "Electronics"),
                new Product(104, "Watch", "Accessories")
        };

        Product result1 = Product.linearSearch(products, "Mobile");
        System.out.println("Linear Search Result: " + result1);

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        Product result2 = Product.binarySearch(products, "Mobile");
        System.out.println("Binary Search Result: " + result2);
    }
}
