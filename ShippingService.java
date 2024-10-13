// ShippingService.java
public class ShippingService {
    public double calculateShipping(String location) {
        // Simulate shipping cost calculation
        System.out.println("Calculating shipping for: " + location);
        return 5.99;  // Flat rate for simplicity
    }

    public void shipOrder(String productName) {
        // Simulate shipping the product
        System.out.println("Shipping product: " + productName);
    }
}
