package managementsystem;

import java.util.*;

class ShoppingCart {
    private final Map<String, Double> productPrices = new HashMap<>(); // Stores product prices
    private final Map<String, Integer> cart = new LinkedHashMap<>(); // Maintains order of added items

    // Add product and its price to the system
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display cart in order of addition
    public void displayCartOrder() {
        System.out.println("Cart (Added Order): " + cart);
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (String product : cart.keySet()) {
            sortedByPrice.put(productPrices.get(product), product);
        }
        System.out.println("Cart (Sorted by Price): " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.8);
        cart.addProduct("Orange", 2.0);
        cart.addProduct("Grapes", 2.5);

        // Adding items to cart
        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 5);
        cart.addToCart("Orange", 3);

        // Display cart order
        cart.displayCartOrder();

        // Display sorted by price
        cart.displaySortedByPrice();
    }
}
