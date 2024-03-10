package com.option1.automobile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
