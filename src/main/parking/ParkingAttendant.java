package main.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingAttendant {
    private List<ParkingLot> parkingLotList;
    ParkingAttendant(ArrayList<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }
    public int park(Car car) {
        for(ParkingLot parkingLot :parkingLotList){
            parkingLot.isParkingSlotAvailable(){
            }
        }
        return 1;
    }
}
