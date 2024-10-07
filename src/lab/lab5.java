package lab;

import java.util.Random;
import java.util.Scanner;

public class lab5
{
    public static void main(String[] args)
    {
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);

        int lowerBound, upperBound, guessNumber;

        System.out.println("Let's play a game, give a range, and generate a number from it , then you guess it!");

        System.out.println("Please enter the lower bound");
        lowerBound = keyboard.nextInt();

        System.out.println("Please enter the higher bound");
        upperBound = keyboard.nextInt();

        int keyNumber = random.nextInt(lowerBound, upperBound);

        System.out.println("Number generated, please enter the number you guess!");
        guessNumber = keyboard.nextInt();

        if (guessNumber == keyNumber)
        {
            System.out.println("Good job, you got it correctly !");
        } else
        {
            System.out.println("Sorry, your guess is incorrectly, the correct number is " + keyNumber);
        }

    }
}
