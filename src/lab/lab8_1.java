package lab;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class lab8_1
{
    public static void main(String[] args) throws IOException
    {
        int num1, num2 = 0;
        String choice = "y";
        Scanner keyboard = new Scanner(System.in);
        FileWriter writer =  new FileWriter("results.txt" , true);

        do
        {

            System.out.print("Enter the first number: ");
            num1 = keyboard.nextInt();
            System.out.print("Enter the secong number: ");
            num2 = keyboard.nextInt();
            writer.write(num1 + " + " + num2 + " = " + (num1 + num2) +"\n");
            System.out.print("Do you want to add more numbers? (y/n): ");
            choice = keyboard.next();
            writer.close();

        }while(choice.equalsIgnoreCase("y"));



    }
}
