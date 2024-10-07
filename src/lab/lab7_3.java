package lab;

import java.util.Random;
import java.util.Scanner;

public class lab7_3
{
    public static void main(String[] args)
    {
        int choice = 0, a = 0, b = 0, key = 0, ans = 0 ,trackT= 0, trackA = 0;
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);
        do

        {
            System.out.println("Enter 1 solve a addition problem");
            System.out.println("Enter 2 solve a cubtraction problem ");
            System.out.println("Enter 3 solve a multiplication problem");
            System.out.println("Enter 4 to quit.");
            System.out.print("Enter your choice here: ");
            choice = keyboard.nextInt();
            if (choice == 1)
            {
                a = random.nextInt(-999, 1000);
                b = random.nextInt(-999, 1000);
                System.out.println("Please solve the problem : (" + a + ")+(" + b+")");
                ans = keyboard.nextInt();
                key = a + b;
                if (ans == key)
                {
                    System.out.println("Congratulate! You made it!");
                    trackT += 1;
                    trackA += 1;

                } else
                {
                    System.out.println("Sorry, your answer is wrong! The correct answer is " + key);
                    trackA += 1;

                }

            } else if (choice == 2)
            {
                a = random.nextInt(-999, 1000);
                b = random.nextInt(-999, 1000);
                System.out.println("Please solve the problem : (" + a + ") - (" + b +")");
                ans = keyboard.nextInt();
                key = a - b;
                if (ans == key)
                {
                    System.out.println("Congratulate! You made it!");
                    trackT += 1;
                    trackA += 1;

                } else
                {
                    System.out.println("Sorry, your answer is wrong! The correct answer is " + key);
                    trackA += 1;
                }
            } else if (choice == 3)
            {
                a = random.nextInt(-99, 100);
                b = random.nextInt(-99, 100);
                System.out.println("Please solve the problem : (" + a + ") * (" + b +")");
                ans = keyboard.nextInt();
                key = a * b;
                if (ans == key)
                {
                    System.out.println("Congratulate! You made it!");
                    trackT += 1;
                    trackA += 1;

                } else
                {
                    System.out.println("Sorry, your answer is wrong! The correct answer is " + key);
                    trackA += 1;
                }
            } else if (choice != 4)
            {
                System.out.println("Invalid input!");
            }
        } while (choice != 4);
        System.out.println("Quit the program successfully, you answerd totally " + trackA + " problems, and " + trackT + " of them are correctly!");
    }
}
