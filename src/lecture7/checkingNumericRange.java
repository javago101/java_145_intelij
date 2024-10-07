package lecture7;

import java.util.Scanner;

public class checkingNumericRange
{
    public static void main(String[] args)
    {
        int x;
        Scanner keyboard = new Scanner(System. in);
        System.out.print("Enter a number between 20 and 40: ");
        x = keyboard.nextInt();
        while (x < 20 || x > 40)
        {
            System.out.println(x + " is not in the acceptable range!");
            System.out.print( "Please enter again!");
            x = keyboard.nextInt();
        }
        System.out.println(x + " is in the acceptable range!");
        System.out.print("Enter a year: ");

        int year = keyboard.nextInt();
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
        {
            System.out.println("That is a leap year");
        }
        else
        {
            System.out.println("That is not a leap year");
        }
    }
}
