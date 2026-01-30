import java.util.*;

class PartA_Prg1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Double>> storeProducts = new HashMap<>();
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("0. Enter store and product details");
            System.out.println("1. Display all products of a store");
            System.out.println("2. Display highest priced product of a store");
            System.out.println("3. Display stores containing a product");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    addProducts(storeProducts);
                    break;
                case 1:
                    displayProduct(storeProducts);
                    break;
                case 2:
                    displayProductWithHighestPrice(storeProducts);
                    break;
                case 3:
                    displayStoresContainingProduct(storeProducts);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option... try again.");
            }
        }
    }
    public static void addProducts(HashMap<String, HashMap<String, Double>> storeProducts) {
        System.out.println("Enter store ID:");
        String storeId = scanner.next();
        HashMap<String, Double> products =
                storeProducts.getOrDefault(storeId, new HashMap<>());
        while (true) {
            System.out.println("Enter product name (or 'done' to finish):");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("done"))
                break;
            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            products.put(productName, price);
        }
        storeProducts.put(storeId, products);
        System.out.println("Products added successfully.");
    }
    public static void displayProduct(HashMap<String, HashMap<String, Double>> storeProducts) {
        System.out.println("Enter store ID:");
        String storeId = scanner.next();
        if (!storeProducts.containsKey(storeId)) {
            System.out.println("Store not found.");
            return;
        }
        System.out.println("Products in store " + storeId + ":");
        for (Map.Entry<String, Double> entry : storeProducts.get(storeId).entrySet()) {
            System.out.println("Product: " + entry.getKey() + " | Price: " + entry.getValue());
        }
    }
    public static void displayProductWithHighestPrice(HashMap<String, HashMap<String, Double>> storeProducts) {
        System.out.println("Enter store ID:");
        String storeId = scanner.next();
        if (!storeProducts.containsKey(storeId)) {
            System.out.println("Store not found.");
            return;
        }
        String highestProduct = null;
        double highestPrice = Double.NEGATIVE_INFINITY;
        for (Map.Entry<String, Double> entry : storeProducts.get(storeId).entrySet()) {
            if (entry.getValue() > highestPrice) {
                highestPrice = entry.getValue();
                highestProduct = entry.getKey();
            }
        }
        System.out.println("Highest priced product:");
        System.out.println(highestProduct + " → " + highestPrice);
    }
    public static void displayStoresContainingProduct(HashMap<String, HashMap<String, Double>> storeProducts) {
        System.out.println("Enter product name:");
        String productName = scanner.next();
        boolean found = false;
        for (Map.Entry<String, HashMap<String, Double>> store : storeProducts.entrySet()) {
            if (store.getValue().containsKey(productName)) {
                System.out.println("Store ID: " + store.getKey() +
                        " | Price: " + store.getValue().get(productName));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No store contains this product.");
        }
    }
}
