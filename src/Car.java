public class Car {
    private String make;
    private String model;
    private int year;
    private double price;
    private String vin;
    private boolean availability;

    public Car(String make, String model, int year, double price, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.vin = vin;
        this.availability = true; // Initially available
    }

    public void sellCar() {
        this.availability = false;
        System.out.println("Car sold: " + this.vin);
    }

    public void updateDetails(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        System.out.println("Details updated for car: " + this.vin);
    }

    public boolean checkAvailability() {
        return this.availability;
    }

    public String getDetails() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year +
               ", Price: $" + price + ", VIN: " + vin + ", Available: " + availability;
    }

    public String getVin() {
        return vin;
    }
}

