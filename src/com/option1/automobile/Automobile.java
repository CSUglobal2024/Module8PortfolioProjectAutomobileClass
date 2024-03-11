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

    // Getters and setters

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

 // Method to list vehicle information
    public String[] listVehicleInformation() {
        String[] info = new String[5];
        info[0] = "Make: " + make;
        info[1] = "Model: " + model;
        info[2] = "Color: " + color;
        info[3] = "Year: " + year;
        info[4] = "Mileage: " + mileage;
        return info;
    }
    
 // Method to update vehicle attributes
    public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        try {
            // Update the attributes with the new values
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;

            // Return success message
            return "Vehicle attributes updated successfully.";
        } catch (Exception e) {
            // Return failure message if an exception occurs
            return "Failed to update vehicle attributes: " + e.getMessage();
        }
    }

}
