package lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lab8_2
{
    private static final String FILENAME = "myStoreSales.txt";

    public static void main(String[] args) throws IOException
    {
        // key map => Reformat Code => "option + shift + F"
        File file = new File(FILENAME);

        try
        {
            if (file.createNewFile())
            {
                System.out.println("File created: " + file.getName());
            } else
            {
                System.out.println("File:" + FILENAME + " already exists.");
            }

        }
        catch (IOException e)
        {
            System.out.println("Error creating file.");
            e.printStackTrace();
        }
        Scanner keyboard = new Scanner(System.in);
        Scanner inputFile = new Scanner(FILENAME);
        // delete a line of code => "command + delete"
        double purchased_cost;
        int menu_choice = 0;
        while (menu_choice != 4)
        {
            // display the menu
            System.out.println("\nMenu:");
            System.out.println("Enter 1 Add a purchase to the file ,");
            System.out.println("Enter 2 Print all the purchases in the file, ");
            System.out.println("Enter 3 View all info for a specific customer, ");
            System.out.println("Enter 4 to quit the program!");
            System.out.print("Enter your choice here: ");
            menu_choice = keyboard.nextInt();

            // menu choices
            if (menu_choice == 1)
            {
                // add a purchase
                System.out.println("Enter the first name of the customer: ");
                String customer_fname = keyboard.next();
                System.out.println("Enter the item of the customer purchased: ");
                String purchased_item = keyboard.next();
                System.out.println("Enter the cost of the item purchased :");
                purchased_cost = keyboard.nextDouble();

                try (FileWriter fw = new FileWriter(FILENAME, true);
                     PrintWriter outputFile = new PrintWriter(fw))
                {
                    outputFile.println(customer_fname + " " + purchased_item + " " + purchased_cost);
                    System.out.println("Purchase added successfully.");
                }
                catch (IOException e)
                {
                    System.out.println("Error writing to file.");
                    e.printStackTrace();
                }

            } else if (menu_choice == 2)
            {
                //Print all purchases
                try
                {
                    Scanner fileScanner = new Scanner(new File(FILENAME));
                    System.out.println("All purchases: ");
                    while (fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error reading from file");
                }
            } else if (menu_choice == 3)
            {
                // view specific customer info
                System.out.print("Enter customer name: ");
                String customerName = keyboard.next();
                try
                {
                    Scanner fileScanner = new Scanner(new File(FILENAME));
                    double total = 0;
                    boolean found = false;

                    System.out.println("Purchases for" + customerName + ":");
                    while (fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();
                        String[] data = line.split(" ");
                        String name = data[0];
                        String item = data[1];
                        double cost = Double.parseDouble(data[2]);
                        if (name.equalsIgnoreCase(customerName))
                        {
                            found = true;
                            System.out.println(name + " bought " + item + " for $" + cost);
                            total += cost;
                        }
                    }
                    if (found)
                    {
                        System.out.println("Total spent by " + customerName + ":$" + total);
                    } else
                    {
                        System.out.println("Customer not found!");
                    }
                    fileScanner.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error reading from file");
                }

            } else if (menu_choice == 4)
            {
                // Exit the program
                System.out.println("Exiting program.");
            } else
            {
                // invalid choice
                System.out.println("Invaild choice! Please select a valid option.");
            }
        }
        keyboard.close();
    }
}
