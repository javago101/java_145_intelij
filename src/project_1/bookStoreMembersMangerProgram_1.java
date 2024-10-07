package project_1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class bookStoreMembersMangerProgram_1
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

    // Sales tracking variables
    private static int salesCount = 0;
    private static int booksSold = 0;
    private static double totalRevenue = 0;
    private static int nonMembers = 0;
    private static int freeMembers = 0;
    private static int paidMembers = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice)
            {
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

    private static void displayMenu()
    {
        System.out.println("\nBookstore Membership Rewards Program");
        System.out.println("1. Enter a new customer sale");
        System.out.println("2. View sales information");
        System.out.println("3. Quit");
    }

    private static int getUserChoice(Scanner scanner)
    {
        System.out.print("Enter your choice (1-3): ");
        return safeNextInt(scanner);
    }

    private static void processNewSale(Scanner scanner)
    {
        int numBooks = getNumberOfBooks(scanner);
        double subtotal = calculateSubtotal(scanner, numBooks);
        String membership = getMembershipType(scanner);

        double tax = subtotal * TAX_RATE;
        double finalCost = subtotal + tax;
        double discount = 0;
        int points = calculatePoints(numBooks, membership);

        if (membership.equals("paid"))
        {
            discount = subtotal * PAID_MEMBER_DISCOUNT;
            finalCost -= discount;
            paidMembers++;
        } else if (membership.equals("free"))
        {
            freeMembers++;
        } else
        {
            nonMembers++;
        }

        displaySaleSummary(numBooks, subtotal, tax, finalCost, discount, points, membership);
        updateSalesStatistics(numBooks, finalCost);
    }

    private static int getNumberOfBooks(Scanner scanner)
    {
        char tem1 = 'n';
        int tem2 = 0;
        do
        {

            System.out.print("Enter the number of books being purchased: ");
            tem2 = safeNextInt(scanner);
            System.out.print("Are you sure the book number of you put is correct(y/n):");
            tem1 = safeNextChar(scanner);
        } while (tem1 != 'y');

        return tem2;

    }

    private static double calculateSubtotal(Scanner scanner, int numBooks)
    {
        double subtotal = 0;
        for (int i = 0; i < numBooks; i++)
        {
            System.out.printf("Enter the cost of book %d: $", i + 1);
            subtotal += safeNextDouble(scanner);
        }
        return subtotal;
    }

    private static String getMembershipType(Scanner scanner)
    {
        System.out.print("Enter customer membership type (non/free/paid): ");
        return scanner.nextLine().toLowerCase();
    }

    private static int calculatePoints(int numBooks, String membership)
    {
        if (membership.equals("non")) return 0;

        if (numBooks == 1) return POINTS_ONE_BOOK;
        if (numBooks == 2) return POINTS_TWO_BOOKS;
        if (numBooks == 3) return membership.equals("paid") ? POINTS_THREE_BOOKS_PAID : POINTS_THREE_BOOKS_FREE;
        return membership.equals("paid") ? POINTS_FOUR_PLUS_BOOKS_PAID : POINTS_FOUR_PLUS_BOOKS_FREE;
    }

    private static void displaySaleSummary(int numBooks, double subtotal, double tax, double finalCost, double discount, int points, String membership)
    {
        System.out.println("\nSale Summary:");
        System.out.printf("Number of books: %d\n", numBooks);
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax: $%.2f\n", tax);
        System.out.printf("Final cost: $%.2f\n", finalCost);
        if (membership.equals("paid"))
        {
            System.out.printf("Amount saved: $%.2f\n", discount);
        }
        System.out.printf("Points earned: %d\n", points);
    }

    private static void updateSalesStatistics(int numBooks, double finalCost)
    {
        salesCount++;
        booksSold += numBooks;
        totalRevenue += finalCost;
    }

    private static void displaySalesInfo()
    {
        System.out.println("\nSales Information:");
        System.out.printf("Number of sales: %d\n", salesCount);
        System.out.printf("Number of books sold: %d\n", booksSold);
        System.out.printf("Total revenue: $%.2f\n", totalRevenue);
        System.out.printf("Non-members: %d\n", nonMembers);
        System.out.printf("Free members: %d\n", freeMembers);
        System.out.printf("Paid members: %d\n", paidMembers);
    }

    private static void displayTotalRevenue()
    {
        System.out.printf("\nTotal revenue for today: $%.2f\n", totalRevenue);
    }

    private static int safeNextInt(Scanner scanner)
    {
        while (true)
        {
            try
            {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static double safeNextDouble(Scanner scanner)
    {
        while (true)
        {
            try
            {
                return Double.parseDouble(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static char safeNextChar(Scanner scanner)
    {
        while (true)
        {
            try
            {
                String input = scanner.next();
                if (input.length() == 1)
                {
                    return input.charAt(0);
                } else
                {
                    System.out.print("Please enter a single character: ");
                }
            }
            catch (Exception e)
            {
                System.out.print("Invalid input. Please enter a single character: ");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}