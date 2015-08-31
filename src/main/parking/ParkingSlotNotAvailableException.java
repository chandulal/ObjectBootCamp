package main.parking;

public class ParkingSlotNotAvailableException extends Exception {
    public ParkingSlotNotAvailableException(String msg) {
        super(msg);
    }
}
