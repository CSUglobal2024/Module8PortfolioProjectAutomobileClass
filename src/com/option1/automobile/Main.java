package com.option1.automobile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Automobile> inventory = new ArrayList<>(); // ArrayList to store Automobile objects
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                // Display menu options
                System.out.println("Menu:");
                System.out.println("1. Add a car");
                System.out.println("2. Remove a car");
                System.out.println("3. Display all cars");
                System.out.println("4. Search for a car");
                System.out.println("5. Exit");

                // Prompt user for choice
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1: // Add a car
                        System.out.println("Enter make, model, color, year, and mileage of the car:");
                        System.out.print("Make: ");
                        String make = scanner.nextLine();
                        System.out.print("Model: ");
                        String model = scanner.nextLine();
                        System.out.print("Color: ");
                        String color = scanner.nextLine();
                        System.out.print("Year: ");
                        int year = scanner.nextInt();
                        System.out.print("Mileage: ");
                        int mileage = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Automobile newCar = new Automobile(make, model, color, year, mileage);
                        inventory.add(newCar);
                        System.out.println("Car added successfully.");
                        break;

                    case 2: // Remove a car
                        System.out.println("Enter make and model of the car to remove:");
                        System.out.print("Make: ");
                        String removeMake = scanner.nextLine();
                        System.out.print("Model: ");
                        String removeModel = scanner.nextLine();
                        boolean removed = false;
                        for (Automobile car : inventory) {
                            if (car.getMake().equalsIgnoreCase(removeMake) && car.getModel().equalsIgnoreCase(removeModel)) {
                                inventory.remove(car);
                                System.out.println("Car removed successfully.");
                                removed = true;
                                break;
                            }
                        }
                        if (!removed) {
                            System.out.println("Car not found in inventory.");
                        }
                        break;

                    case 3: // Display all cars
                        System.out.println("Inventory:");
                        for (Automobile car : inventory) {
                            System.out.println(car);
                        }
                        break;

                    case 4: // Search for a car
                        System.out.println("Enter make and model of the car to search:");
                        System.out.print("Make: ");
                        String searchMake = scanner.nextLine();
                        System.out.print("Model: ");
                        String searchModel = scanner.nextLine();
                        boolean found = false;
                        for (Automobile car : inventory) {
                            if (car.getMake().equalsIgnoreCase(searchMake) && car.getModel().equalsIgnoreCase(searchModel)) {
                                System.out.println("Car found:");
                                System.out.println(car);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Car not found in inventory.");
                        }
                        break;

                    case 5: // Exit
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}