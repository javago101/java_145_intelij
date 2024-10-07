package lecture8;

import java.util.Scanner;

public class meunDisplay
{
    public static void main(String[] args)
    {
        int lastGrade = 88;
        String nextAssignment = "Do problems 81, 83, 85, and 87 in chapter 3";
        String assignmentHint = "Ask your professor for help if you get stuck!";
        int choice = 0;
        Scanner keyboard = new Scanner(System.in);
        do
        {
            System.out.println("Enter 1 to see the next homework assignment");
            System.out.println("Enter 2 for your grade on the last assignment. ");
            System.out.println("Enter 3 for assignment hints.");
            System.out.println("Enter 4 to quit.");
            choice = keyboard.nextInt();
            // if/else statement from the next slide goes here!
            if (choice == 1)
            {
                System.out.println(nextAssignment);
            }
            else if (choice == 2)
            {
                System.out.println("Your grade is: " +
                        lastGrade);
            }
            else if (choice == 3)
            {
                System.out.println(assignmentHint);
            }
            else if (choice == 4)
            {
                System.out.println("Quitting Program");
            }
            else
            {
                System.out.println("Incorrect entry!");
            }
        } while (choice != 4);
        System.out.println("Quitting Program");

    }
}
