// ShoppingFacade.java
public class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;
    private DiscountService discountService;

    public ShoppingFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
        discountService = new DiscountService();
    }

    public void placeOrder(String productName, String paymentDetails, String location) {
        System.out.println("Placing order for: " + productName);

        // Step 1: Search for product
        String result = productCatalog.searchProduct(productName);
        System.out.println(result);

        // Step 2: Check product availability
        if (!inventoryManager.checkStock(productName)) {
            System.out.println("Product is out of stock!");
            return;
        }

        // Step 3: Process payment
        try {
            if (!paymentProcessor.processPayment(paymentDetails)) {
                System.out.println("Payment failed!");
                return;
            }
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Step 4: Update inventory
        inventoryManager.updateInventory(productName);

        // Step 5: Calculate and handle shipping
        double shippingCost = shippingService.calculateShipping(location);
        System.out.println("Shipping cost: $" + shippingCost);
        shippingService.shipOrder(productName);

        System.out.println("Order placed successfully for " + productName + "!");
    }

    public void placeOrderWithDiscount(String productName, String paymentDetails, String location) {
        double price = 1000;  // Example product price
        double discountedPrice = discountService.applyDiscount(productName, price);
        System.out.println("Discounted price: $" + discountedPrice);
        placeOrder(productName, paymentDetails, location);
    }
}
