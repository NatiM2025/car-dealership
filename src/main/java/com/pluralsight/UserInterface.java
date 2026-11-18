package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class  UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }
    public void display() {
        init();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your command: ");

            String command = scanner.nextLine();
            switch (command) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "99" -> running = false;
                default -> System.out.println("Invalid input Try again.");
            }
        }
    }
    public void processGetByPriceRequest() {
        System.out.print("Enter the lowest price: ");
        BigDecimal min = new BigDecimal(scanner.nextLine());

        System.out.print("Enter the highest price: ");
        BigDecimal max = new BigDecimal(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter the make: ");
        String make = scanner.nextLine();

        System.out.print("Enter the model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter the earliest year ");
        int min = scanner.nextInt();

        System.out.print("Enter the latest : ");
        int max = scanner.nextInt();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
        scanner.nextLine();
    }

    public void processGetByColorRequest() {
        System.out.print("Enter the color");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);

    }

    public void processGetByMileageRequest() {
        System.out.print("Enter the lowest mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the highest mileage : ");
        int max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter the type(sedan,truck,SUV,Van): ");
        String type = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter the VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Enter the year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the make: ");
        String make = scanner.nextLine();

        System.out.print("Enter the model: ");
        String model = scanner.nextLine();

        System.out.print("Enter the type (car, truck, SUV, van): ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter the color: ");
        String color = scanner.nextLine();

        System.out.print("Enter the mileage: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle added.");
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter the VIN of the vehicle to remove: ");
        String vin = scanner.nextLine();
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin().equals(vin)) {
                vehicleToRemove = vehicle;
            }
        }
        if (vehicleToRemove == null) {
            System.out.println("No vehicle found with that VIN.");
        } else {
            dealership.removeVehicle(vehicleToRemove);
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed.");
        }
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }
        private void displayVehicles(List<Vehicle> vehicles) {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.getVin() + " | " + vehicle.getYear() + " | " + vehicle.getMake() + " | " + vehicle.getModel() + " | " + vehicle.getVehicleType() + " | " +
                        vehicle.getColor() + " | " + vehicle.getOdometer() + " | " + vehicle.getPrice());
        }
    }
}