package lab;

import java.util.Scanner;

public class lab9_1
{
    /*
    Write a Java program that asks the user to enter three test scores.
     The program should display the average of the three scores and the student’s final letter grade.
     Include the following methods in your program:
        calcAverage: Accepts three test scores as arguments and returns their average.
        determineGrade: Accepts a single score as an argument and returns a letter grade for the score,
        based on the following grading scale: 90-100: A, 80-89: B, 70-79: C, 60-69: D, below 60: F
        In your main method, print out the results returned from the method.
        Suppose the user enters 90, 85, 80 for the test scores.
    Your output should look something like this: “The average score is 85 and the overall grade is B”
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        double score1 = 0, score2 = 0, score3 = 0;
        while (true)
        {
            System.out.println("Enter your last 3 test score:");
            score1 = keyboard.nextDouble();
            score2 = keyboard.nextDouble();
            score3 = keyboard.nextDouble();
            if ((!isValid(score1)) || (!isValid(score2)) || (!isValid(score3)))
            {
                System.out.println("invalid input!");
                continue;
            } else
            {
                break;
            }
        }

        double ave_score = calcAverage(score1, score2, score3);
        System.out.println("Your avarge score is: " + ave_score +" and your final grade is:" + determineGrade(ave_score));


    }

    public static double calcAverage(double a, double b, double c)
    {
        return (a + b + c) / 3.0;
    }

    public static char determineGrade(double a)
    {
        if (a <= 60)
            return 'F';
        else if (a <= 70)
            return 'D';
        else if (a <= 80)
            return 'C';
        else if (a <= 90)
            return 'B';
        else
            return 'A';
    }

    public static boolean isValid(double val)
    {
        return val >= 0 && val <= 100;
    }
}
