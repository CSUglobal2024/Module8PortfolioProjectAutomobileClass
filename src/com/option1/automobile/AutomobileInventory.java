package com.option1.automobile;

class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public Automobile() {}

    // Parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Getters for make and model
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    // Method to add a new vehicle
    public String addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added successfully.";
        } catch (Exception e) {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // Method to list vehicle information
    public String[] listVehicleInformation() {
        try {
            String[] info = {make, model, color, String.valueOf(year), String.valueOf(mileage)};
            return info;
        } catch (Exception e) {
            return new String[]{"Failed to list vehicle information: " + e.getMessage()};
        }
    }

    // Method to remove a vehicle
    public String removeVehicle() {
        try {
            make = null;
            model = null;
            color = null;
            year = 0;
            mileage = 0;
            return "Vehicle removed successfully.";
        } catch (Exception e) {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    // Method to update vehicle attributes
    public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle attributes updated successfully.";
        } catch (Exception e) {
            return "Failed to update vehicle attributes: " + e.getMessage();
        }
    }

    // Override toString method to display vehicle information
    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Mileage: " + mileage;
    }
}
