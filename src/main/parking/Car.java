package main.parking;

public class Car {
    private String carNumber;
    Car(String carNumber){
        this.carNumber=carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return !(carNumber != null ? !carNumber.equals(car.carNumber) : car.carNumber != null);

    }

    @Override
    public int hashCode() {
        return carNumber != null ? carNumber.hashCode() : 0;
    }
}
