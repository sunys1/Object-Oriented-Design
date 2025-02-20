package ca.ood._02_parking_lot_system;

public class Driver {
    private int id;
    private Vehicle vehicle;
    private double balance = 0.0;
    private String paymentMethod;

    public Driver(int id, Vehicle vehicle, String paymentMethod) {
        this.id = id;
        this.vehicle = vehicle;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public double getBalance() {
        return balance;
    }
    public String getPaymentMethod() {return paymentMethod;}

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
