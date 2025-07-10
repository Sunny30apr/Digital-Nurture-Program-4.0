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
        return "[" + productId + "] " + productName + " (" + category + ")";
    }
}

class Search {

    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == id) return products[mid];
            else if (products[mid].productId < id) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}




public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(103, "Keyboard", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Mouse", "Electronics"),
                new Product(104, "T-Shirt", "Fashion"),
                new Product(107, "Ball", "Sports")
        };
        System.out.println();
        System.out.println("Product list");
        for (Product prd: products){
            System.out.println(prd);
        }
        System.out.println();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter product id (-1 to exit) >> ");
            int id = sc.nextInt();
            if(id==-1)
                break;
            System.out.println("Linear Search for ID >>" + id);
            Product found1 = Search.linearSearch(products, id);
            System.out.println(found1 != null ? found1 : "Product not found");
            Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

            System.out.println("Binary Search for ID >> " + id);
            Product found2 = Search.binarySearch(products, id);
            System.out.println(found2 != null ? found2 : "Product not found");
        }
    }
}
