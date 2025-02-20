package ca.ood._02_parking_lot_system;

import java.util.HashMap;
import java.util.Map;
/**
 * Represents a floor of a garage
 */
public class ParkingFloor {
    private int[] spots;
    private Map<Vehicle, int[]> vehicleMap;

    public ParkingFloor(int spotCount) {
        spots = new int[spotCount];
        vehicleMap = new HashMap<>();
    }

    public boolean parkingVehicle(Vehicle vehicle) {
        int size = vehicle.getSpotSize();
        int l = 0, r = 0;
        while (r < spots.length) {
            if(spots[r] != 0){
                l = r + 1;
            }
            if(r - l + 1 == size){
                for(int i = l; i <= r; i++){
                    spots[i] = 1;
                }

                vehicleMap.put(vehicle, new int[]{l, r});
                return true;
            }
            r++;
        }
        return false;
    }

    public int[] getVehicleSpots(Vehicle vehicle) {
        return vehicleMap.get(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        int[] spotsTaken = vehicleMap.get(vehicle);
        for (int i = spotsTaken[0]; i < spotsTaken[1]; i++) {
            spots[i] = 0;
        }

        vehicleMap.remove(vehicle);
    }
}
