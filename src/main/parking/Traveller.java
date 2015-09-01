package main.parking;

import java.util.ArrayList;

public class Traveller {
    final private ParkingAttendant parkingAttendant = new ParkingAttendant(new ArrayList<ParkingLot>());
    public int handOverCar(Car car) {
        return parkingAttendant.park(car);
    }
}
