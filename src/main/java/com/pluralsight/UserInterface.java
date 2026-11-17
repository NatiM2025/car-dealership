package com.pluralsight;

import java.util.List;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
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
    }

    public void processAddVehicleRequest() {
    }

    public void processRemoveVehicleRequest() {
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.getDealership();
    }
    private void displayVehicles(List<Vehicle> vehicleList){

    }
}