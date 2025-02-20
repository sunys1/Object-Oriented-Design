package ca.ood._02_parking_lot_system;

/**
 * Represents a garage with 1 or multiple floors
 */
public class ParkingGarage {
    private ParkingFloor[] floors;

    public ParkingGarage(int floorCount, int spotPerFloor) {
        floors = new ParkingFloor[floorCount];
        for(int i = 0; i < floorCount; i++) {
            floors[i] = new ParkingFloor(spotPerFloor);
        }
    }

    public boolean parkingVehicle(Vehicle vehicle) {
        for(ParkingFloor floor : floors) {
            if(floor.parkingVehicle(vehicle)){
                return true;
            }
        }

        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for(ParkingFloor floor : floors) {
            if(floor.getVehicleSpots(vehicle) != null){
                floor.removeVehicle(vehicle);
                return true;
            }
        }

        return false;
    }
}

