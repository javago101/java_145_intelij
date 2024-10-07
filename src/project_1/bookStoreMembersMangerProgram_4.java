package project_1;

import java.io.*;
import java.util.Scanner;

public class bookStoreMembersMangerProgram_4 {
    // Constants
    private static final double TAX_RATE = 0.0925;
    private static final double PAID_MEMBER_DISCOUNT = 0.10;
    private static final int POINTS_ONE_BOOK = 5;
    private static final int POINTS_TWO_BOOKS = 15;
    private static final int POINTS_THREE_BOOKS_FREE = 30;
    private static final int POINTS_THREE_BOOKS_PAID = 50;
    private static final int POINTS_FOUR_PLUS_BOOKS_FREE = 60;
    private static final int POINTS_FOUR_PLUS_BOOKS_PAID = 100;

    // Sales tracking variables
    private static int salesCount = 0;
    private static int booksSold = 0;
    private static double totalRevenue = 0;
    private static int nonMembers = 0;
    private static int freeMembers = 0;
    private static int paidMembers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    processNewSale(scanner);
                    break;
                case 2:
                    displaySalesInfo();
                    break;
                case 3:
                    displayTotalRevenue();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== Bookstore Membership Rewards Program =====");
        System.out.println("1. Enter a new customer sale");
        System.out.println("2. View sales information");
        System.out.println("3. Quit");
        System.out.println("===============================================");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice (1-3): ");
        return safeNextInt(scanner);
    }

    private static void processNewSale(Scanner scanner) {
        int numBooks = getNumberOfBooks(scanner);
        double[] bookCosts = getBookCosts(scanner, numBooks);
        String membership = getMembershipType(scanner);

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

        displaySaleSummary(numBooks, bookCosts, subtotal, tax, finalCost, discount, points, membership);
        if (confirmSale(scanner)) {
            updateSalesStatistics(numBooks, finalCost);
            System.out.println("Sale recorded successfully.");
        } else {
            System.out.println("Sale cancelled.");
        }
    }

    private static int getNumberOfBooks(Scanner scanner) {
        int numBooks;
        do {
            System.out.print("Enter the number of books being purchased: ");
            numBooks = safeNextInt(scanner);
            if (numBooks <= 0) {
                System.out.println("Please enter a positive number of books.");
            }
        } while (numBooks <= 0);

        return numBooks;
    }

    private static double[] getBookCosts(Scanner scanner, int numBooks) {
        double[] costs = new double[numBooks];
        for (int i = 0; i < numBooks; i++) {
            System.out.printf("Enter the cost of book %d: $", i + 1);
            costs[i] = safeNextDouble(scanner);
        }
        return costs;
    }

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

    private static double calculateSubtotal(double[] bookCosts) {
        double subtotal = 0;
        for (double cost : bookCosts) {
            subtotal += cost;
        }
        return subtotal;
    }

    private static int calculatePoints(int numBooks, String membership) {
        if (membership.equals("non")) return 0;

        if (numBooks == 1) return POINTS_ONE_BOOK;
        if (numBooks == 2) return POINTS_TWO_BOOKS;
        if (numBooks == 3) return membership.equals("paid") ? POINTS_THREE_BOOKS_PAID : POINTS_THREE_BOOKS_FREE;
        return membership.equals("paid") ? POINTS_FOUR_PLUS_BOOKS_PAID : POINTS_FOUR_PLUS_BOOKS_FREE;
    }

    private static void displaySaleSummary(int numBooks, double[] bookCosts, double subtotal, double tax, double finalCost, double discount, int points, String membership) {
        System.out.println("\n===== Sale Summary =====");
        System.out.printf("Number of books: %d\n", numBooks);
        for (int i = 0; i < numBooks; i++) {
            System.out.printf("Book %d cost: $%.2f\n", i + 1, bookCosts[i]);
        }
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax: $%.2f\n", tax);
        System.out.printf("Final cost: $%.2f\n", finalCost);
        if (membership.equals("paid")) {
            System.out.printf("Amount saved: $%.2f\n", discount);
        }
        System.out.printf("Points earned: %d\n", points);
        System.out.printf("Membership type: %s\n", membership);
        System.out.println("========================");
    }

    private static boolean confirmSale(Scanner scanner) {
        System.out.print("Confirm this sale? (y/n): ");
        return safeNextChar(scanner) == 'y';
    }

    private static void updateSalesStatistics(int numBooks, double finalCost) {
        salesCount++;
        booksSold += numBooks;
        totalRevenue += finalCost;
    }

    private static void displaySalesInfo() {
        System.out.println("\n===== Sales Information =====");
        System.out.printf("Number of sales: %d\n", salesCount);
        System.out.printf("Number of books sold: %d\n", booksSold);
        System.out.printf("Total revenue: $%.2f\n", totalRevenue);
        System.out.printf("Non-members: %d\n", nonMembers);
        System.out.printf("Free members: %d\n", freeMembers);
        System.out.printf("Paid members: %d\n", paidMembers);
        System.out.println("=============================");
    }

    private static void displayTotalRevenue() {
        System.out.printf("\nTotal revenue for today: $%.2f\n", totalRevenue);
    }

    private static int safeNextInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static double safeNextDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static char safeNextChar(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.length() == 1 && (input.charAt(0) == 'y' || input.charAt(0) == 'n')) {
                    return input.charAt(0);
                } else {
                    System.out.print("Please enter 'y' or 'n': ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter 'y' or 'n': ");
            }
        }
    }
}