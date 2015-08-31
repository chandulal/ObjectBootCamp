package main.parking;

import junit.framework.TestCase;
import org.junit.Test;

public class ParkingLotTest extends TestCase {
    public void testParkingLotWhenParkingSlotIsAvailable(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car hondaCity = new Car("MH14-6745");
        int receiptId = parkingLot.park(hondaCity);
        assertTrue(receiptId > 0);
    }
    @Test(expected = ParkingSlotNotAvailableException.class)
    public void testParkingLotWhenParkingIsFull(){
        ParkingLot parkingLot = new ParkingLot(0);
        Car hondaCity = new Car("MH14-6745");
        parkingLot.park(hondaCity);
    }
    public void testParkingLotForTakingACar(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car hondaCity = new Car("MH14-6745");
        int receiptId = parkingLot.park(hondaCity);
        assertTrue(hondaCity.equals(parkingLot.takeCar(receiptId)));
    }

    @Test(expected = CarNotPresentException.class)
    public void testParkingLotForTakingACarWithoutPark(){
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.takeCar(-5);
    }
    public void testParkingLotWhenParkingTwoCars(){
        ParkingLot parkingLot = new ParkingLot(2);
        Car hondaCity = new Car("MH14-6745");
        Car i10 = new Car("MH14 1000");
        int receiptIdForHondaCity = parkingLot.park(hondaCity);
        int receiptIdForI10 = parkingLot.park(i10);
        assertTrue(hondaCity.equals(parkingLot.takeCar(receiptIdForHondaCity)));
        assertTrue(i10.equals(parkingLot.takeCar(receiptIdForI10)));
    }
}