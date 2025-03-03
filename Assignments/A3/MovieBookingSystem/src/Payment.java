import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private PaymentMethod method;
    private LocalDateTime dateOfPurchase;
    private double amount;
    private PaymentStatus status = PaymentStatus.PENDING;

    public Payment(String paymentId, PaymentMethod method, LocalDateTime dateOfPurchase, double amount) {
        this.paymentId = paymentId;
        this.method = method;
        this.dateOfPurchase = dateOfPurchase;
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
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

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Payment Details: " + "\n" +
                "Transaction receipt: " + paymentId + "\n" +
                method +
                " -$" + amount +
                "\nDate/Time: " + dateOfPurchase + "\n" +
                "Status: " + status + "\n";
    }
}
