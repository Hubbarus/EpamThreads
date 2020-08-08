import java.util.Date;

public class WaitingCar extends Car {

    public WaitingCar(String name) {
        super(name);
        this.creatingTime = new Date();
        this.waitingTime = 1000 * 20; // 10 seconds
    }
}
