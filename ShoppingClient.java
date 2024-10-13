// ShoppingClient.java
public class ShoppingClient {
    public static void main(String[] args) {
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        // Simulate a customer placing an order without a discount
        shoppingFacade.placeOrder("Laptop", "CreditCard", "New York");

        System.out.println();

        // Simulate a customer placing an order with a discount
        shoppingFacade.placeOrderWithDiscount("Phone", "CreditCard", "Los Angeles");

        System.out.println();

        // Simulate a customer with payment failure
        shoppingFacade.placeOrder("Tablet", "InvalidCard", "Chicago");
    }
}
