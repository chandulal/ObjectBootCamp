package main.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<Integer,Car> parkingCatalog = new HashMap<>();
    private List<Integer> freeSlotList = new ArrayList<>();
    private int parkingSize;

    ParkingLot(int parkingSize){
        this.parkingSize = parkingSize;
    }

    public int park(Car car){
        int slot=0;
        if(isParkingSlotAvailable()){
            slot = getEmptySlot();
            parkingCatalog.put(slot, car);
        }
        else{
            try {
                throw new ParkingSlotNotAvailableException("Parking is Full");
            } catch (ParkingSlotNotAvailableException e) {
                System.out.println(e.getMessage());
            }
        }
        return slot;
    }

    private boolean isParkingSlotAvailable(){
        if(parkingCatalog.size() < parkingSize || freeSlotList.size() != 0)
            return true;
        else return false;
    }

    private int getEmptySlot() {
        if(parkingCatalog.size() < parkingSize)
            return parkingCatalog.size() + 1;
        else {
            int size = freeSlotList.size();
            int slot = freeSlotList.get(size-1);
            freeSlotList.remove(size-1);
            return slot;
        }
    }

    public Car takeCar(int slotNumber) {
        Car car = null;
        if(parkingCatalog.containsKey(slotNumber)){
            freeSlotList.add(slotNumber);
             car = parkingCatalog.get(slotNumber);
            return car;
        }
        else{
            try {
                throw new CarNotPresentException("Car not Present in this parking");
            } catch (CarNotPresentException e) {
                System.out.println(e.getMessage());
            }
        }
        return car ;
    }
}
