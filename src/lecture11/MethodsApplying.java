package lecture11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class MethodsApplying
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = getFileName();
        double totalSales = getTotalSales(fileName);
        displayResults(totalSales);
    }
    public static String getFileName()
    {
        Scanner keyboard = new Scanner(System. in);
        System.out.print("Enter the name of a file containing sales information: ");
        String fileName = keyboard.nextLine();
        return fileName;
    }
    public static double getTotalSales (String fileName) throws FileNotFoundException
    {
        /**
         This method opens the file with the incoming name .
         */
        double total = 0.0; // Accumulator variable to eventually hold all sales on the file
        double sale;
        File file = new File(fileName); // Open the file for reading
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext())
        {
            sale = inputFile.nextDouble();
            total += sale; // Add the next sale to the accumulator
        }
        inputFile.close();
        return total;
    }
    public static void displayResults( double results)
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("The total sales were: $" + formatter.format(results));
    }
}
