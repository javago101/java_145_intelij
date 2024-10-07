package lecture11;

import java.util.Scanner;

public class isValidMethod
{
    public static void main(String[] args)
    {
        int num = 50;
        while (true)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Please enter your scores:");
            num = keyboard.nextInt();

            if (!isValid(num))
            {
                System.out.println("invalid input!");
                continue;
            }

            System.out.println("Your scores is: " + num);
        }
    }

    public static boolean isValid(int val)
    {
        return val >= 1 && val <= 100;
    }
}
