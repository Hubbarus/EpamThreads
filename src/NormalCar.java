import java.util.Date;

public class NormalCar extends Car {

    public NormalCar(String name) {
        super(name);
        this.creatingTime = new Date();
        this.waitingTime = 1000 * 5; // 5 seconds
    }
}
