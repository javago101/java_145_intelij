package lecture9;

import java.io.*;
import java.util.Scanner;

public class thePrintWriter
{
    public static void main(String[] args) throws IOException
    {
        File myFile;
        Scanner keyboard = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(new FileWriter("myStoreSales.txt",true));
        printWriter.println("Aiden Milk 9.00");
        while (true)
        {

            String fileName = keyboard.nextLine();
            myFile = new File(fileName);
            if (myFile.exists())
            {
                // User entered name of an existing file
                break;
            }
            System.out.println("Unable to find file!");
        }
        Scanner inputFile = new Scanner(myFile);
        while (inputFile.hasNext())
            System.out.println(inputFile.nextLine());
        inputFile.close();
    }
}
