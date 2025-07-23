import java.util.*;
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " | Qty: " + quantity + " | Price: " + price;
    }
}



class Inventory {
    HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.productId, p);
        System.out.println("Product added: " + p);
    }

    public void updateProduct(int productId, int quantity, double price) {
        if (products.containsKey(productId)) {
            Product p = products.get(productId);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated: " + p);
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (products.remove(productId) != null)
            System.out.println("Product deleted: ID = " + productId);
        else
            System.out.println("Product ID not found.");
    }

    public void listInventory() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inven1 = new Inventory();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPress >>");
        System.out.println("1. To add product");
        System.out.println("2. To update product");
        System.out.println("3. To delete product");
        System.out.println("4. To list inventory");
        System.out.println("0. To exit");

        while (true) {
            System.out.print("Enter choice >> ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    Product newProd = new Product(id, name, qty, price);
                    inven1.addProduct(newProd);
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int upQty = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double upPrice = sc.nextDouble();

                    inven1.updateProduct(upId, upQty, upPrice);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int delId = sc.nextInt();
                    inven1.deleteProduct(delId);
                    break;

                case 4:
                    System.out.println("---- Current Inventory ----");
                    inven1.listInventory();
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
