public class Manager extends Salesperson {
    public Manager(String employeeID, String name) {
        super(employeeID, name);
    }

    public void removeCar(CarInventory inventory, String vin) {
        inventory.removeCar(vin);
    }
}

