package lecture9;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDriven_FileOperationProgram
{
    // Constant for the filename where purchases will be stored
    private static final String FILENAME = "myStoreSales.txt";

    public static void main(String[] args) {
        // Initialize the file at the start of the program
        initializeFile();
        // Start the main program loop
        runProgram();
    }

    // Method to initialize the file, creating it if it does not exist
    private static void initializeFile() {
        File file = new File(FILENAME);
        try {
            // Attempt to create a new file
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File: " + FILENAME + " already exists.");
            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur during file creation
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // Main program loop to display menu and process user choices
    private static void runProgram() {
        try (Scanner keyboard = new Scanner(System.in)) {
            int menuChoice = 0; // Variable to store user's menu choice
            while (menuChoice != 4) { // Continue until the user chooses to quit
                displayMenu(); // Display menu options
                menuChoice = getMenuChoice(keyboard); // Get user's choice
                processMenuChoice(menuChoice, keyboard); // Process the chosen option
            }
        }
    }

    // Method to display the menu options to the user
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a purchase to the file");
        System.out.println("2. Print all the purchases in the file");
        System.out.println("3. View all info for a specific customer");
        System.out.println("4. Quit the program");
        System.out.print("Enter your choice: ");
    }

    // Method to get and validate user's menu choice
    private static int getMenuChoice(Scanner keyboard) {
        while (!keyboard.hasNextInt()) { // Check if input is an integer
            System.out.println("Invalid input. Please enter a number.");
            keyboard.next(); // Consume invalid input to avoid infinite loop
        }
        return keyboard.nextInt(); // Return valid integer choice
    }

    // Method to process the user's menu choice and call appropriate functions
    private static void processMenuChoice(int choice, Scanner keyboard) {
        switch (choice) {
            case 1:
                addPurchase(keyboard); // Call method to add a purchase
                break;
            case 2:
                printAllPurchases(); // Call method to print all purchases
                break;
            case 3:
                viewCustomerInfo(keyboard); // Call method to view specific customer info
                break;
            case 4:
                System.out.println("Exiting program."); // Exit message
                break;
            default:
                System.out.println("Invalid choice! Please select a valid option."); // Handle invalid choices
        }
    }

    // Method to add a purchase entry from user input into the file
    private static void addPurchase(Scanner keyboard) {
        System.out.print("Enter the customer's first name: ");
        String customerName = keyboard.next(); // Read customer's first name

        System.out.print("Enter the item purchased: ");
        String purchasedItem = keyboard.next(); // Read purchased item

        System.out.print("Enter the cost of the item: $");
        double purchasedCost = keyboard.nextDouble(); // Read cost of purchased item

        try (FileWriter fw = new FileWriter(FILENAME, true); // Open FileWriter in append mode
             PrintWriter outputFile = new PrintWriter(fw)) { // Create PrintWriter for easy writing
            outputFile.printf("%s %s %.2f%n", customerName, purchasedItem, purchasedCost);
            System.out.println("Purchase added successfully."); // Confirmation message
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage()); // Handle IO exceptions during writing
        }
    }

    // Method to print all purchases stored in the file
    private static void printAllPurchases() {
        try (Scanner fileScanner = new Scanner(new File(FILENAME))) { // Open scanner for reading from file
            System.out.println("All purchases:");
            while (fileScanner.hasNextLine()) { // Read each line in the file until end is reached
                String line = fileScanner.nextLine();
                System.out.println(line); // Print each purchase line
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage()); // Handle IO exceptions during reading
        }
    }

    // Method to view all purchases made by a specific customer
    private static void viewCustomerInfo(Scanner keyboard) {
        System.out.print("Enter customer name: ");
        String customerName = keyboard.next(); // Read customer's name

        List<String> customerPurchases = new ArrayList<>(); // List to store purchases by this customer
        double total = 0; // Variable to keep track of total spent by customer

        try (Scanner fileScanner = new Scanner(new File(FILENAME))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(" "); // Split line into components

                if (data[0].equalsIgnoreCase(customerName)) {
                    customerPurchases.add(line); // Add purchase line if it matches customer's name
                    total += Double.parseDouble(data[2]); // Accumulate total cost for this customer
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return;
        }

        if (customerPurchases.isEmpty()) {
            System.out.println("No purchases found for " + customerName);
        } else {
            System.out.println("Purchases for " + customerName + ":");
            for (String purchase : customerPurchases) {
                System.out.println(purchase);
            }
            System.out.printf("Total spent by %s: $%.2f%n", customerName, total);
        }
    }
}
