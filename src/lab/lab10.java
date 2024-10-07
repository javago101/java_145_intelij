package lab;

import java.io.*;
import java.util.Scanner;

import static lecture11.MethodsApplying.getFileName;

public class lab10
{
    /*
    Write a Java program that allows the user to create and maintain
    a list of contact names and phone numbers on a file named contacts.txt.
    In the file, store a contact's phone number in the line after their name.
    This will allow contact names to be more than one word.

In a while loop, continually ask the user what option they would like to choose:

Call a method named printContacts.
In this method, print the entire list in a nicely formatted way.

Call a method named getNumber.
In this method, ask the user to enter a name.
If the name is found in the file, return the phone number (as a String).
 Otherwise, return an empty string to signify the contact wasn’t found.
 Back in main, print out either the contact’s phone number or a message telling the user that contact doesn’t exist.

Call a method named addContact.
In this method, add a contact to the file.
Ask the user for a name and phone number. Append these values to the end of the contact list.
Quit the program.

Hint: Open the file in the required mode at the start of each method
and close the connection to the file at the end of each method.
Choose a submission type







     */
    private static final String FILE_NAME = "lab10_contact.txt";

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Print all contacts");
            System.out.println("2. Get a contact's number");
            System.out.println("3. Add a new contact");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1)
            {
                printContacts();
            } else if (choice == 2)
            {
                System.out.print("Enter the contact name: ");
                String name = scanner.nextLine();
                String number = getNumber(name);
                if (!number.equals(""))
                {
                    System.out.println("Phone number: " + number);
                } else
                {
                    System.out.println("Contact not found.");
                }
            } else if (choice == 3)
            {
                addContact();
            } else if (choice == 4)
            {
                System.out.println("Goodbye!");
            } else
            {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void printContacts() throws IOException
    {
        File file = new File(FILE_NAME);
        Scanner fileScanner = new Scanner(file);
        String name;
        String number;

        System.out.println("\nContact List:");
        while (fileScanner.hasNextLine())
        {
            name = fileScanner.nextLine();
            number = fileScanner.nextLine();
            System.out.println(name + ": " + number);
        }

        fileScanner.close();
    }

    private static String getNumber(String name) throws IOException
    {
        File file = new File(FILE_NAME);
        Scanner fileScanner = new Scanner(file);
        String currentName;
        String currentNumber;

        while (fileScanner.hasNextLine())
        {
            currentName = fileScanner.nextLine();
            currentNumber = fileScanner.nextLine();
            if (currentName.equalsIgnoreCase(name))
            {
                fileScanner.close();
                return currentNumber;
            }
        }

        fileScanner.close();
        return "";
    }

    private static void addContact() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String number = scanner.nextLine();

        FileWriter writer = new FileWriter(FILE_NAME, true);
        writer.write(name + "\n");
        writer.write(number + "\n");
        writer.close();

        System.out.println("Contact added successfully.");
    }
}
