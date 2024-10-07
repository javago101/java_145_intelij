package lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class lab9
{
    public static void main(String[] args)
    {
        double a =0, b =0;
        Scanner keyboard = new Scanner(System.in);
        while(true)
        {

            System.out.println("Enter two number you want to operate:");
            a = keyboard.nextDouble();
            b = keyboard.nextDouble();
            keyboard.nextLine();
            displayRes(a, b);
            System.out.print("Enter another operation (or 'q' to quit): ");
            String entry = keyboard.nextLine();
            if (entry.equalsIgnoreCase( "q"))
                break;
        }

    }
    public static Double getProduct(double a , double b)
    {
        return a * b; //Return statement must be the last statement in a method or a if-statement block
        /*
        When a return statement is reached, the method it’s located in immediately stops executing.
            ● Therefore, the final statement in this method is unreachable.
            ● This is a syntax error and a program containing this method won’t run
         */
    }
    public static Double getAdd(double a , double b)
    {
        return a + b;
    }
    public static Double getSubtract(double a , double b)
    {
        return a - b;
    }
    public static void displayRes(double a, double b)
    {
        DecimalFormat dec_formatter = new DecimalFormat("#,###.##");
        System.out.println("The sum of " + a +" and " + b+ " is: " + dec_formatter.format(getAdd(a,b)));
        System.out.println("The subtract of " + a +" and "+ b + " is: " +dec_formatter.format(getSubtract(a,b)));
        System.out.println("The product of " + a +" and " + b + " is: " + dec_formatter.format(getProduct(a,b)));
    }

}
