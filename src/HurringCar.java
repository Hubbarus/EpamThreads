import java.util.Date;

public class HurringCar extends Car {

    public HurringCar(String name) {
        super(name);
        this.creatingTime = new Date();
        this.waitingTime = 1000 * 2; // 2 seconds
    }
}
