package lecture12;

import java.util.Scanner;

public class arraysExercise
{
    public static void main(String[] args)
    {
        /*
        Let’s write a program that asks the user how many test scores they would like to
        enter into the program.
        In a loop, we’ll ask the user for one score per iteration.
F       inally, we’ll use an enhanced for loop to print the values that were entered
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many test scores?: ");
        int numScores = keyboard.nextInt();

        int[] scores = new int[numScores];

        for(int i = 0; i < numScores; i++)
        {
            System.out.print("Enter the next score: ");
            scores[i] = keyboard.nextInt();
        }

        for(int score : scores)
        {
            System.out.print(score + " ");
        }
    }
}
