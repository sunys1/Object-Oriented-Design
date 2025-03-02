import java.time.LocalDateTime;

public class Payment {
    private int transactionId;
    private PaymentMethod method;
    private LocalDateTime dateOfPurchase;
    private double amount;

    public Payment(int transactionId, PaymentMethod method, LocalDateTime dateOfPurchase, double amount) {
        this.transactionId = transactionId;
        this.method = method;
        this.dateOfPurchase = dateOfPurchase;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "Payment Details: " +
                "Transaction receipt: " + transactionId +
                ", " + method.toString() +
                " -$" + amount +
                ", Date/Time: " + dateOfPurchase;
    }
}
