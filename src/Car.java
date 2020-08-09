import java.util.Date;

public abstract class Car implements Runnable {
    private String name;
    long waitingTime;
    Date creatingTime;
    private final long PARKING_TIME_MILLIS = 3000;
    private boolean isParked;
    private boolean wasParked;
    private Date parkingTime;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isWaiting() {
        Date now = new Date();
        return now.getTime() - creatingTime.getTime() < waitingTime;
    }

    private boolean isStillParked() {
        Date now = new Date();
        return now.getTime() - parkingTime.getTime() < PARKING_TIME_MILLIS;
    }

    private void park() {
        for (int i = 0; i < Parking.lots.length; i++) {
            if (Parking.lots[i] == null) {
                System.out.println(getName() + " parked!");
                isParked = true;
                wasParked = true;
                Parking.numberOfParkedCars++;
                parkingTime = new Date();
                Parking.lots[i] = this;
                break;
            }
        }
    }

    private void leaveParkingLot() {
        if (isParked) {
            for (int i = 0; i < Parking.lots.length; i++) {
                if (Parking.lots[i] == this) {
                    isParked = false;
                    Parking.lots[i] = null;
                    System.out.println(getName() + " left the parking");
                }
            }
        }
    }

    @Override
    public void run() {
        synchronized (Parking.lots) {
            while (isWaiting()) {
                if (!isParked) {
                    park();
                    break;
                }
            }
        }

        synchronized (Parking.lots) {
            while (isParked) {
                if (!isStillParked()) {
                    leaveParkingLot();
                    break;
                }
            }
        }

        if (!isWaiting() && !wasParked) {
            Parking.numberOfGoneCars++;
            System.out.println(this.getName() + " gone away!");
        }
    }

}
