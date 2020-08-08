import java.util.Date;

public class NormalCar extends Car {
    public NormalCar(String name) {
        super(name);
        this.creatingTime = new Date();
        this.waitingTime = 1000 * 10; // 5 seconds
    }
}
