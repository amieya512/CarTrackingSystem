import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarInventory inventory = new CarInventory();
        preloadInventory(inventory); // Add preloaded cars silently

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Car Tracking System!");
            System.out.println("Are you an:");
            System.out.println("1. Employee");
            System.out.println("2. Customer");
            System.out.println("3. Quick Test");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            if (userType == 1) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter your 5-digit employee ID: ");
                String employeeID = scanner.nextLine();

                if (!employeeID.matches("\\d{5}")) {
                    System.out.println("Invalid ID. Please enter exactly 5 digits.");
                    continue;
                }

                Salesperson salesperson = new Salesperson(name, employeeID);
                handleEmployeeMenu(scanner, salesperson, inventory);
            } else if (userType == 2) {
                Customer customer = new Customer();
                handleCustomerMenu(scanner, customer, inventory);
            } else if (userType == 3) {
                quickTest(inventory);
            } else if (userType == 4) {
                System.out.println("Goodbye!");
                scanner.close(); // Close Scanner here
                return;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void preloadInventory(CarInventory inventory) {
        inventory.addCar(new Car("Toyota", "Corolla", 2020, 20000, "VIN12345"));
        inventory.addCar(new Car("Honda", "Civic", 2021, 22000, "VIN67890"));
        inventory.addCar(new Car("Ford", "Focus", 2019, 18000, "VIN54321"));
    }

    private static void quickTest(CarInventory inventory) {
        System.out.println("\n=== Quick Test Mode ===");

        Salesperson salesperson = new Salesperson("Alice", "12345");
        System.out.println("\nAdding cars...");
        salesperson.addCar(inventory, new Car("Chevrolet", "Malibu", 2022, 25000, "VIN56789"));
        salesperson.addCar(inventory, new Car("Nissan", "Altima", 2023, 28000, "VIN67891"));

        System.out.println("\nMarking a car as sold...");
        salesperson.sellCar(inventory.getAvailableCars().get(0)); // Mark first available car as sold

        System.out.println("\nRemoving a car...");
        inventory.removeCar("VIN54321"); // Remove car with VIN54321

        System.out.println("\nAvailable cars after employee actions:");
        inventory.displayAvailableCars();

        Customer customer = new Customer();
        System.out.println("\nViewing available cars as a customer:");
        customer.viewAvailableCars(inventory);

        System.out.println("\nBuying a car as a customer...");
        customer.buyCar(inventory, "VIN56789"); // Customer buys a car

        System.out.println("\nAvailable cars after customer actions:");
        inventory.displayAvailableCars();

        System.out.println("\n=== Quick Test Complete ===");
    }

    private static void handleEmployeeMenu(Scanner scanner, Salesperson salesperson, CarInventory inventory) {
        while (true) {
            System.out.println("\nEmployee Menu:");
            System.out.println("1. Add a new car");
            System.out.println("2. Mark a car as sold");
            System.out.println("3. Remove a car");
            System.out.println("4. View available cars");
            System.out.println("5. Return to main menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter Make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Year (numerical values only): ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Price (numerical values only): ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline after nextDouble()
                    System.out.print("Enter VIN: ");
                    String vin = scanner.nextLine();

                    Car car = new Car(make, model, year, price, vin);
                    salesperson.addCar(inventory, car);
                    break;

                case 2:
                    System.out.print("Enter VIN of car to mark as sold: ");
                    String soldVin = scanner.nextLine();
                    for (Car c : inventory.getAvailableCars()) {
                        if (c.getVin().equals(soldVin)) {
                            salesperson.sellCar(c);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter VIN of car to remove: ");
                    String removeVin = scanner.nextLine();
                    inventory.removeCar(removeVin);
                    break;

                case 4:
                    inventory.displayAvailableCars();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleCustomerMenu(Scanner scanner, Customer customer, CarInventory inventory) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View available cars");
            System.out.println("2. Buy a car");
            System.out.println("3. Return to main menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            switch (choice) {
                case 1:
                    customer.viewAvailableCars(inventory);
                    break;

                case 2:
                    System.out.print("Enter VIN of car to buy: ");
                    String vin = scanner.nextLine();
                    customer.buyCar(inventory, vin);
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}




