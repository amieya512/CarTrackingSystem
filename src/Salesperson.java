public class Salesperson {
    private String name;
    private String employeeID;

    public Salesperson(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public void sellCar(Car car) {
        if (car.checkAvailability()) {
            car.sellCar();
            System.out.println(name + " (Employee ID: " + employeeID + ") sold the car with VIN: " + car.getVin());
        } else {
            System.out.println("Car is already sold.");
        }
    }

    public void addCar(CarInventory inventory, Car car) {
        inventory.addCar(car);
        System.out.println(name + " (Employee ID: " + employeeID + ") added a new car to the inventory.");
    }
}



