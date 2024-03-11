package com.option1.automobile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Automobile> inventory = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nAutomobile Inventory Program");
            System.out.println("1. List all vehicles");
            System.out.println("2. Add a new vehicle");
            System.out.println("3. Remove a vehicle");
            System.out.println("4. Update a vehicle");
            System.out.println("5. Print vehicles and their info to a file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    listAllVehicles(inventory);
                    break;
                case 2:
                    addNewVehicle(scanner, inventory);
                    break;
                case 3:
                    removeVehicle(scanner, inventory);
                    break;
                case 4:
                    updateVehicle(scanner, inventory);
                    break;
                case 5:
                    printToFile(inventory);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }

        scanner.close();
    }
    
    public static void printToFile(ArrayList<Automobile> automobiles) {
        String filePath = "C:\\Temp\\Autos.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Automobile auto : automobiles) {
                writer.write("Make: " + auto.getMake() + "\n");
                writer.write("Model: " + auto.getModel() + "\n");
                writer.write("Color: " + auto.getColor() + "\n");
                writer.write("Year: " + auto.getYear() + "\n");
                writer.write("Mileage: " + auto.getMileage() + "\n\n");
            }
            System.out.println("Information printed to file successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while printing to file: " + e.getMessage());
        }
    }

    private static void listAllVehicles(ArrayList<Automobile> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            for (Automobile automobile : inventory) {
                String[] info = automobile.listVehicleInformation();
                for (String data : info) {
                    System.out.println(data);
                }
                System.out.println(); // Add an empty line between vehicles
            }
        }
    }

    private static void addNewVehicle(Scanner scanner, ArrayList<Automobile> inventory) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter mileage: ");
        int mileage = scanner.nextInt();

        Automobile newVehicle = new Automobile(make, model, color, year, mileage);
        inventory.add(newVehicle);
        System.out.println("Vehicle added successfully.");
    }

    private static void removeVehicle(Scanner scanner, ArrayList<Automobile> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            System.out.print("Enter index of vehicle to remove: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (index >= 0 && index < inventory.size()) {
                inventory.remove(index);
                System.out.println("Vehicle removed successfully.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    private static void updateVehicle(Scanner scanner, ArrayList<Automobile> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            System.out.print("Enter index of vehicle to update: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (index >= 0 && index < inventory.size()) {
                System.out.print("Enter new make: ");
                String make = scanner.nextLine();
                System.out.print("Enter new model: ");
                String model = scanner.nextLine();
                System.out.print("Enter new color: ");
                String color = scanner.nextLine();
                System.out.print("Enter new year: ");
                int year = scanner.nextInt();
                System.out.print("Enter new mileage: ");
                int mileage = scanner.nextInt();

                Automobile updatedVehicle = inventory.get(index);
                updatedVehicle.updateVehicleAttributes(make, model, color, year, mileage);
                System.out.println("Vehicle updated successfully.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

   
}
