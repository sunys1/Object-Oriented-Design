package ca.ood._02_parking_lot_system;

//import java.util.Calendar;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents the parking lot system that the user interacts with
 */
public class ParkingSystem {
    private final ParkingGarage garage;
    private Map<Integer, LocalDateTime> duration = new HashMap<>(); //key:driverId, value:entryTime
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private int hourRate;


    public ParkingSystem(ParkingGarage garage, int hourRate) {
        this.garage = garage;
        this.hourRate = hourRate;
    }

    public boolean parkVehicle(Driver driver) {
        int driverId = driver.getId();
        LocalDateTime entryTime = LocalDateTime.now();
        boolean isParked = garage.parkingVehicle(driver.getVehicle());

        // record the entry time
        if(isParked){
            duration.put(driverId, entryTime);
            System.out.println("Driver " + driverId + " parked at " + entryTime.format(FORMATTER) + ".");
        }

        return isParked;
    }

    public boolean removeVehicle(Driver driver) {
        int driverId = driver.getId();
        if(!duration.containsKey(driverId)) {
            return false;
        }

        // for testing purpose, generate random hours between 1-24 to simulate hours in real-world
        Random random = new Random();
        int gapHours = random.nextInt(24) + 1;

        // calculate parking fee
        LocalDateTime entryTime = duration.get(driverId);
        LocalDateTime exitTime = entryTime.plusHours(gapHours);
        //        LocalDateTime exitTime = LocalDateTime.now();
        Duration timeParked = Duration.between(entryTime, exitTime);
        Long hours = timeParked.toHours();
        Long minutes = timeParked.toMinutes();
        double parkingFee = (minutes / 60.0) * hourRate;

        // check payment method and charge
        String paymentMethod = driver.getPaymentMethod();
        boolean isPaid = false;
        Scanner scanner = new Scanner(System.in);
        int newMethod;

        while(!isPaid){
            if (paymentMethod.equals(PaymentMethod.PREPAID.toString())) {
                double driverBalance = driver.getBalance();
                if (parkingFee <= driverBalance) {
                    isPaid = true;
                    driver.setBalance(driverBalance - parkingFee);
                    System.out.println("Payment Successful! Driver " + driverId + "'s new balance: $" + driver.getBalance() + ".");
                }else{
                    System.out.println("Insufficient Funds! Prepaid Payment Failed. Your balance: $" + driverBalance
                            + ". Your parking fee: $" + parkingFee + ".");
                    System.out.println("Please add funds or use a different payment method:\n"
                            + "1. Add Funds\n" + "2. Use a different payment method");

                    newMethod = scanner.nextInt();
                    // I suppose normally drivers would add funds through a mobile app or web app.
                    // But here is just to demo the simplified logic of adding funds, updating balance, and re-validating payment
                    if (newMethod == 1) {
                        System.out.print("How much do you want to add to your balance? : ");
                        double fund = scanner.nextDouble();
                        driver.setBalance(driverBalance + fund);
                    }else if(newMethod == 2) {
                        System.out.print("Please choose from the following payment methods:\n"
                        + "1. MASTERCARD\n" + "2. VISA\n" + "2. DEBIT\n");

                        newMethod = scanner.nextInt();

                        if (newMethod == 1) {
                            paymentMethod = PaymentMethod.MASTERCARD.toString();
                        }else if(newMethod == 2) {
                            paymentMethod = PaymentMethod.VISA.toString();
                        }else if (newMethod == 3) {
                            paymentMethod = PaymentMethod.DEBIT.toString();
                        }
                        // Update driver payment method
                        driver.setPaymentMethod(paymentMethod);
                    }
                }
            }else{ // Pay by MASTERCARD, VISA, or DEBIT
                isPaid = true;
                System.out.print("Payment Successful! ");
            }
         }

        System.out.println("Driver " + driverId + " exited at " + exitTime.format(FORMATTER) +
                ". Duration: " + hours + " hours, " + minutes % 60 + " minutes. Parking fee: $" + parkingFee
                + " paid by " + driver.getPaymentMethod() + ".");

        scanner.close();
        duration.remove(driverId);
        return garage.removeVehicle(driver.getVehicle());
    }
}
