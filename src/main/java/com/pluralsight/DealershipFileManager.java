package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
// reads, saves and removes list of vehicles from the csv file
public class DealershipFileManager {

    private String inventory;
    String filename = "inventory.csv";
    public Dealership getDealership() {

        BufferedReader bufferedReader;
       Dealership dealership = null;

            try {
                String item;
                boolean empty = false;
                bufferedReader = new BufferedReader(new FileReader(filename));
                String title = bufferedReader.readLine();
                String[] part = title.split("\\|");
                dealership = new Dealership(part[0],part[1],part[2]);

                while (!empty) {
                    Vehicle vehicle;
                    item = bufferedReader.readLine();
                    if (item != null) {
                        String[] vehiclePart = item.split("\\|");
                        vehicle = new Vehicle((vehiclePart[0]),Integer.parseInt(vehiclePart[1]),
                                vehiclePart[2],vehiclePart[3],vehiclePart[4],vehiclePart[5],Integer.parseInt(vehiclePart[6]),new BigDecimal(vehiclePart[7]));
                        dealership.addVehicle(vehicle);
                    } else {
                        empty = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(" Something went wrong " + e);
                ;
            }

        return dealership;
    }
    // saves list of Vehicles to the file
    public void saveDealership(Dealership dealership){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            bufferedWriter.write(dealership.getName()+ "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bufferedWriter.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()){
                bufferedWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType()
                        + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Something Went wrong " + e);;
        }

    }


}
