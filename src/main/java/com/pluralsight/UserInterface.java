package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class  UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }
    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1 - Find vehicles within a price range");
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

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {
    }

    public void processGetByColorRequest() {
    }

    public void processGetByMileageRequest() {
    }

    public void processGetByVehicleTypeRequest() {
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
    }

    public void processRemoveVehicleRequest() {
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