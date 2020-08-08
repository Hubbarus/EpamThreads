
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarParking {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new WaitingCar("Volvo " + i), "Volvo " + i);
            Thread t1 = new Thread(new NormalCar("Volkswagen " + i), "Volkswagen " + i);
            Thread t2 = new Thread(new HurringCar("Ferrari " + i), "Ferrari " + i);
            t.start();
            t1.start();
            t2.start();
        }
    }
}
