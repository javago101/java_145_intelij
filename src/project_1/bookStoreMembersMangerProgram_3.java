package project_1;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class bookStoreMembersMangerProgram_3
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
    private static final String DATA_FILE = "bookstore_data_3.txt";
    private static final String FILE_SUBTITLE = "Bookstore Membership Rewards Program Data";

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

    // Get number of books being purchased with validation
    private static int getNumberOfBooks(Scanner scanner) {
        int numBooks;
        do {
            System.out.print("Enter the number of books being purchased (1-10): ");
            numBooks = safeNextInt(scanner);
            if (numBooks < 1 || numBooks > 10) {
                System.out.println("Invalid number of books. Please enter a number between 1 and 10.");
            }
        } while (numBooks < 1 || numBooks > 10);
        return numBooks;
    }

    // Get cost of each book
    private static double getBookCost(Scanner scanner, int bookNumber) {
        System.out.printf("Enter the cost of book %d: $", bookNumber);
        return safeNextDouble(scanner);
    }

    // Get customer's membership type
    private static String getMembershipType(Scanner scanner) {
        String membership;
        do {
            System.out.print("Enter customer membership type (non/free/paid): ");
            membership = scanner.nextLine().toLowerCase();
            if (!membership.equals("non") && !membership.equals("free") && !membership.equals("paid")) {
                System.out.println("Invalid membership type. Please enter 'non', 'free', or 'paid'.");
            }
        } while (!membership.equals("non") && !membership.equals("free") && !membership.equals("paid"));
        return membership;
    }

    // 3. Business Logic Methods
    // Process a new sale
    private static void processNewSale(Scanner scanner) {
        int numBooks = getNumberOfBooks(scanner);
        double[] bookCosts = new double[numBooks];
        for (int i = 0; i < numBooks; i++) {
            bookCosts[i] = getBookCost(scanner, i + 1);
        }
        String membership = getMembershipType(scanner);

        // Display input summary and ask for confirmation
        displayInputSummary(numBooks, bookCosts, membership);
        if (confirmSale(scanner)) {
            double subtotal = calculateSubtotal(bookCosts);
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
            System.out.println("Sale recorded successfully.");
        } else {
            System.out.println("Sale cancelled.");
        }
    }

    // Display summary of input data
    private static void displayInputSummary(int numBooks, double[] bookCosts, String membership) {
        System.out.println("\nInput Summary:");
        System.out.printf("Number of books: %d\n", numBooks);
        for (int i = 0; i < numBooks; i++) {
            System.out.printf("Cost of book %d: $%.2f\n", i + 1, bookCosts[i]);
        }
        System.out.printf("Membership type: %s\n", membership);
    }

    // Confirm sale with user
    private static boolean confirmSale(Scanner scanner) {
        System.out.print("Is this information correct? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    // Calculate subtotal for all books
    private static double calculateSubtotal(double[] bookCosts) {
        double subtotal = 0;
        for (double cost : bookCosts) {
            subtotal += cost;
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
        System.out.printf("Membership type: %s\n", membership);
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
            // Read subtitle and date
            line = reader.readLine();
            if (line == null || !line.startsWith(FILE_SUBTITLE)) {
                throw new IOException("Invalid file format: missing subtitle");
            }

            // Read and parse each data line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length != 2) {
                    continue; // Skip invalid lines
                }
                switch (parts[0]) {
                    case "Number of Sales":
                        salesCount = Integer.parseInt(parts[1]);
                        break;
                    case "Books Sold":
                        booksSold = Integer.parseInt(parts[1]);
                        break;
                    case "Total Revenue":
                        totalRevenue = Double.parseDouble(parts[1]);
                        break;
                    case "Non-members":
                        nonMembers = Integer.parseInt(parts[1]);
                        break;
                    case "Free Members":
                        freeMembers = Integer.parseInt(parts[1]);
                        break;
                    case "Paid Members":
                        paidMembers = Integer.parseInt(parts[1]);
                        break;
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file or no previous data found. Starting with fresh data.");
        }
    }

    // Save data to file with subtitle, date, and titled data
    private static void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            writer.println(FILE_SUBTITLE + " - " + getCurrentDate());
            writer.println("Number of Sales: " + salesCount);
            writer.println("Books Sold: " + booksSold);
            writer.println("Total Revenue: " + String.format("%.2f", totalRevenue));
            writer.println("Non-members: " + nonMembers);
            writer.println("Free Members: " + freeMembers);
            writer.println("Paid Members: " + paidMembers);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Get current date as a formatted string
    private static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(new Date());
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