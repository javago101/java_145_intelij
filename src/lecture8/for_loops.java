package lecture8;

import java.util.Scanner;

public class for_loops
{
    public static void main(String[] args)
    {
        // create the variable before the loop before use it
        Scanner keyboard = new Scanner(System.in);
        int total = 0;
        int num;
        for ( int i =0 ; i < 10; i ++ ) // i is a local variable within the for loop
        {
            System.out.print("Enter a negative number(or a non-negative number to quit): ");
            num = keyboard.nextInt();
            if (num >= 0)
            {
                System.out.println("You entered " + i + " numbers");
                break;
            }
            total += num;
        }

        System.out.println("Total: " + total);
    }
}
