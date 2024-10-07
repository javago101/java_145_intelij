package lab;

import java.util.Random;
import java.util.Scanner;

public class lab7_1
{
    public static void main(String[] args)
    {
        int key, guess = -1;
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);
        key = random.nextInt(1, 1001); // 1001 is not included
        System.out.print("Please enter a number from [1-1000]: ");
        guess = keyboard.nextInt();
        System.out.println();
        while (true)
        {
            if (guess < 1 || guess > 1000)
            {
                System.out.print("The number is out of [1-1000], please try again: ");
                guess = keyboard.nextInt();
            } else
            {
                if (guess < key)
                {
                    System.out.print("It is too low! Please try again:");
                    guess = keyboard.nextInt();

                } else if (guess > key)
                {
                    System.out.print("It is too high! Please try again:");
                    guess = keyboard.nextInt();
                } else
                {
                    System.out.print("Congratulate! You got the correct answer, it is " + key);
                    break;
                }
            }
        }


    }
}
