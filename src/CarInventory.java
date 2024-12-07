import java.util.ArrayList;

public class CarInventory {
    private ArrayList<Car> cars;

    public CarInventory() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added: " + car.getDetails());
    }

    public void removeCar(String vin) {
        cars.removeIf(car -> car.getVin().equals(vin));
        System.out.println("Car with VIN " + vin + " removed.");
    }

    public ArrayList<Car> getAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.checkAvailability()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : getAvailableCars()) {
            System.out.println(car.getDetails());
        }
    }
}
