package ca.ood._02_parking_lot_system;

public class Main {
    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage(1, 10);
        ParkingSystem system = new ParkingSystem(garage, 10);
        Driver d1 = new Driver(1, new Car(1), "PREPAID");
        Driver d2 = new Driver(2, new Car(2), "MASTERCARD");
        Driver d3 = new Driver(3, new Car(3), "VISA");
        Driver d4 = new Driver(4, new Car(2), "DEBIT");

        d1.setBalance(80);
        system.parkVehicle(d1);
        system.parkVehicle(d2);
        system.parkVehicle(d3);
        system.parkVehicle(d4);

        system.removeVehicle(d1);
        system.removeVehicle(d2);
        system.removeVehicle(d3);
        system.removeVehicle(d4);
    }
}
