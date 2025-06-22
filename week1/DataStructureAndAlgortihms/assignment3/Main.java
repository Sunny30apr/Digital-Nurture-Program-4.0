import  java.util.*;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "[" + orderId + "] " + customerName + " | Total: $" + totalPrice;
    }
}

class Sorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}




public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(1001, "Alice", 300.0),
                new Order(1002, "Bob", 150.5),
                new Order(1003, "Charlie", 450.75),
                new Order(1004, "Diana", 99.99)
        };

        System.out.println("🔹 Before Sorting:");
        printOrders(orders);

        Sorter.bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        printOrders(orders);

        Order[] orders2 = {
                new Order(1001, "Alice", 300.0),
                new Order(1002, "Bob", 150.5),
                new Order(1003, "Charlie", 450.75),
                new Order(1004, "Diana", 99.99)
        };

        Sorter.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\n🔹 After Quick Sort:");
        printOrders(orders2);
    }

    static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
