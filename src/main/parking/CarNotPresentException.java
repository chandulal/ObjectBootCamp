package main.parking;

public class CarNotPresentException extends Throwable {
    public CarNotPresentException(String msg) {
        super(msg);
    }
}
