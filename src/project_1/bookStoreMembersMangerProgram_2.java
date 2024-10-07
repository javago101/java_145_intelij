package project_1;
import java.io.*;
import java.util.Scanner;

public class bookStoreMembersMangerProgram_2
{
    // Constants
    private static final double TAX_RATE = 0.0925;
    private static final double PAID_MEMBER_DISCOUNT = 0.10;
    private static final int POINTS_ONE_BOOK = 5;
    private static final int POINTS_TWO_BOOKS = 15;
    private static final int POINTS_THREE_BOOKS_FREE = 30;
    private static final int POINTS_THREE_BOOKS_PAID = 50;
    private static final int POINTS_FOUR_PLUS_BOOKS_FREE = 60;
    private static final int POINTS_FOUR_PLUS_BOOKS_PAID = 100;
    private static final String DATA_FILE = "bookstore_data_2.txt";

    // Sales tracking variables
    private static int salesCount = 0;
    private static int booksSold = 0;
    private static double totalRevenue = 0;
    private static int nonMembers = 0;
    private static int freeMembers = 0;
    private static int paidMembers = 0;

    // 1. Main Program Flow
    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            try {
                if (choice == 1) {
                    processNewSale(scanner);
                } else if (choice == 2) {
                    displaySalesInfo();
                } else if (choice == 3) {
                    saveData();
                    displayTotalRevenue();
                    System.exit(0);
                } else {
                    throw new IllegalArgumentException("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 2. User Input Methods
    // Get user's menu choice
    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice (1-3): ");
        return safeNextInt(scanner);
    }

    // Get number of books being purchased
    private static int getNumberOfBooks(Scanner scanner) {
        System.out.print("Enter the number of books being purchased: ");
        return safeNextInt(scanner);
    }

    // Get cost of each book
    private static double getBookCost(Scanner scanner, int bookNumber) {
        System.out.printf("Enter the cost of book %d: $", bookNumber);
        return safeNextDouble(scanner);
    }

    // Get customer's membership type
    private static String getMembershipType(Scanner scanner) {
        System.out.print("Enter customer membership type (non/free/paid): ");
        return scanner.nextLine().toLowerCase();
    }

    // 3. Business Logic Methods
    // Process a new sale
    private static void processNewSale(Scanner scanner) {
        int numBooks = getNumberOfBooks(scanner);
        double subtotal = calculateSubtotal(scanner, numBooks);
        String membership = getMembershipType(scanner);

        double tax = subtotal * TAX_RATE;
        double finalCost = subtotal + tax;
        double discount = 0;
        int points = calculatePoints(numBooks, membership);

        if (membership.equals("paid")) {
            discount = subtotal * PAID_MEMBER_DISCOUNT;
            finalCost -= discount;
            paidMembers++;
        } else if (membership.equals("free")) {
            freeMembers++;
        } else {
            nonMembers++;
        }

        displaySaleSummary(numBooks, subtotal, tax, finalCost, discount, points, membership);
        updateSalesStatistics(numBooks, finalCost);
    }

    // Calculate subtotal for all books
    private static double calculateSubtotal(Scanner scanner, int numBooks) {
        double subtotal = 0;
        for (int i = 0; i < numBooks; i++) {
            subtotal += getBookCost(scanner, i + 1);
        }
        return subtotal;
    }

    // Calculate points earned based on number of books and membership type
    private static int calculatePoints(int numBooks, String membership) {
        if (membership.equals("non")) return 0;

        if (numBooks == 1) return POINTS_ONE_BOOK;
        if (numBooks == 2) return POINTS_TWO_BOOKS;
        if (numBooks == 3) return membership.equals("paid") ? POINTS_THREE_BOOKS_PAID : POINTS_THREE_BOOKS_FREE;
        return membership.equals("paid") ? POINTS_FOUR_PLUS_BOOKS_PAID : POINTS_FOUR_PLUS_BOOKS_FREE;
    }

    // Update sales statistics after each sale
    private static void updateSalesStatistics(int numBooks, double finalCost) {
        salesCount++;
        booksSold += numBooks;
        totalRevenue += finalCost;
    }

    // 4. Output Methods
    // Display main menu
    private static void displayMenu() {
        System.out.println("\nBookstore Membership Rewards Program");
        System.out.println("1. Enter a new customer sale");
        System.out.println("2. View sales information");
        System.out.println("3. Quit");
    }

    // Display summary of a sale
    private static void displaySaleSummary(int numBooks, double subtotal, double tax, double finalCost, double discount, int points, String membership) {
        System.out.println("\nSale Summary:");
        System.out.printf("Number of books: %d\n", numBooks);
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax: $%.2f\n", tax);
        System.out.printf("Final cost: $%.2f\n", finalCost);
        if (membership.equals("paid")) {
            System.out.printf("Amount saved: $%.2f\n", discount);
        }
        System.out.printf("Points earned: %d\n", points);
    }

    // Display overall sales information
    private static void displaySalesInfo() {
        System.out.println("\nSales Information:");
        System.out.printf("Number of sales: %d\n", salesCount);
        System.out.printf("Number of books sold: %d\n", booksSold);
        System.out.printf("Total revenue: $%.2f\n", totalRevenue);
        System.out.printf("Non-members: %d\n", nonMembers);
        System.out.printf("Free members: %d\n", freeMembers);
        System.out.printf("Paid members: %d\n", paidMembers);
    }

    // Display total revenue
    private static void displayTotalRevenue() {
        System.out.printf("\nTotal revenue for today: $%.2f\n", totalRevenue);
    }

    // 5. File Operations
    // Load data from file
    private static void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    salesCount = Integer.parseInt(data[0]);
                    booksSold = Integer.parseInt(data[1]);
                    totalRevenue = Double.parseDouble(data[2]);
                    nonMembers = Integer.parseInt(data[3]);
                    freeMembers = Integer.parseInt(data[4]);
                    paidMembers = Integer.parseInt(data[5]);
                    System.out.println("Data loaded successfully.");
                } else {
                    throw new IOException("Invalid data format in file.");
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("No previous data found or error reading file. Starting with fresh data.");
        }
    }

    // Save data to file
    private static void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            writer.printf("%d,%d,%.2f,%d,%d,%d",
                    salesCount, booksSold, totalRevenue, nonMembers, freeMembers, paidMembers);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // 6. Error Handling Methods
    // Safely get an integer input
    private static int safeNextInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // Safely get a double input
    private static double safeNextDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}