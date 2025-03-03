public class User {
    private int userId;
    private String userName;
    private PaymentMethod paymentMethod;

    public User(int userId, String userName, PaymentMethod paymentMethod) {
        this.userId = userId;
        this.userName = userName;
        this.paymentMethod = paymentMethod;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
