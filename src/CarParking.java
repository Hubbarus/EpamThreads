import java.util.concurrent.TimeUnit;

public class CarParking {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new WaitingCar("Volvo " + i), "Volvo " + i);
            Thread t1 = new Thread(new NormalCar("Volkswagen " + i), "Volkswagen " + i);
            Thread t2 = new Thread(new HurringCar("Ferrari " + i), "Ferrari " + i);
            t.start();
            t1.start();
            t2.start();
            Parking.numberOfTotalCars += 3;
        }

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nTotal cars: " + Parking.numberOfTotalCars);
        System.out.println("Parked cars: " + Parking.numberOfParkedCars);
        System.out.println("Gone cars: " + Parking.numberOfGoneCars);
    }
}
