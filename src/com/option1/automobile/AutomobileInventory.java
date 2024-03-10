import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
}

public class Main {
    public static void main(String[] args) {
        try {
            Automobile automobile = new Automobile("Toyota", "Camry", "Red", 2020, 5000);
            
            // List initial vehicle information
            System.out.println("Initial Vehicle Information:");
            String[] initialInfo = automobile.listVehicleInformation();
            for (String info : initialInfo) {
                System.out.println(info);
            }

            // Remove vehicle
            System.out.println(automobile.removeVehicle());

            // Add a new vehicle
            System.out.println(automobile.addVehicle("Honda", "Accord", "Blue", 2019, 8000));

            // List new vehicle information
            System.out.println("\nNew Vehicle Information:");
            String[] newInfo = automobile.listVehicleInformation();
            for (String info : newInfo) {
                System.out.println(info);
            }

            // Update vehicle
            System.out.println(automobile.updateVehicleAttributes("Ford", "Fusion", "Silver", 2018, 10000));

            // List updated vehicle information
            System.out.println("\nUpdated Vehicle Information:");
            String[] updatedInfo = automobile.listVehicleInformation();
            for (String info : updatedInfo) {
                System.out.println(info);
            }

            // Prompt user to print information to a file
            System.out.println("\nDo you want to print the information to a file? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("Y")) {
                printToFile(updatedInfo);
                System.out.println("Information printed to file successfully.");
            } else {
                System.out.println("File printing cancelled.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    // Method to print information to a file
    public static void printToFile(String[] info) {
        try {
            FileWriter writer = new FileWriter("C:\\Temp\\Autos.txt");
            for (String line : info) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred while printing to file: " + e.getMessage());
        }
    }
}

