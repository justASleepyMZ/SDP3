// PaymentProcessor.java
public class PaymentProcessor {
    public boolean processPayment(String paymentDetails) throws PaymentException {
        // Simulate payment processing
        System.out.println("Processing payment with details: " + paymentDetails);
        if (paymentDetails.equals("InvalidCard")) {
            throw new PaymentException("Payment declined! Invalid payment details.");
        }
        // Assuming payment is successful
        System.out.println("Payment processed successfully.");
        return true;
    }
}
