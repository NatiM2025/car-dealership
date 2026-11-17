package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private String inventory;

    public Dealership getDealership() {
        String filename = "inventory.csv";
        BufferedReader bufferedReader;
       Dealership dealership = null;


        {
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
                        vehicle = new Vehicle(Integer.parseInt(vehiclePart[0]),Integer.parseInt(vehiclePart[1]),
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
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership){

    }


}
