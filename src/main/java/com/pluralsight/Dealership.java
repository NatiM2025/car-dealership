package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.phone = phone;
        this.address = address;
        this.name = name;
        inventory = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void addVehicle (Vehicle vehicle ){
        inventory.add(vehicle);
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        ArrayList<Vehicle> arrayList = new ArrayList<>();
        for(Vehicle vehicle:inventory){

            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0){
                arrayList.add(vehicle);
            }
        }
        return arrayList;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> arrayList = new ArrayList<>();
        for(Vehicle vehicle:inventory){

            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                arrayList.add(vehicle);
            }
        }
        return arrayList;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> arrayList = new ArrayList<>();
        for(Vehicle vehicle:inventory){

            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                arrayList.add(vehicle);
            }
        }
        return arrayList;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> arrayList = new ArrayList<>();
        for(Vehicle vehicle:inventory){

            if (vehicle.getColor().equalsIgnoreCase(color)){
                arrayList.add(vehicle);
            }
        }
        return arrayList;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> arrayList = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if (vehicle.getOdometer()  >= min && vehicle.getOdometer() <= max){
                arrayList.add(vehicle);
            }
        }
        return arrayList;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList <Vehicle> arrayList = new ArrayList<>();
        for (Vehicle vehicle :inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                arrayList.add(vehicle);
            }
        }
        return arrayList;
    }
    public void removeVehicle (){

    }

}
