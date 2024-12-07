public class Customer {

    public void viewAvailableCars(CarInventory inventory) {
        inventory.displayAvailableCars();
    }

    public void buyCar(CarInventory inventory, String vin) {
        for (Car car : inventory.getAvailableCars()) {
            if (car.getVin().equals(vin)) {
                car.sellCar();
                return;
            }
        }
        System.out.println("Car not found or unavailable.");
    }
}
