package lecture6;

import java.util.Scanner;

public class loopControl
{
    public static void main(String[] args)
    {
        //  if(BooleanExpression) statement;
        //  if(BooleanExpression) { block1 };

        /*
        if(BooleanExpression1) { block1 };
        if(BooleanExpression2) { block2 };
        else { block3}
        */
        double score1, score2, score3, average;
        Scanner keyboard = new Scanner(System. in);

        System.out.println("This program averages 3 test scores");
        // Ask the user to enter their three test scores.

        System.out.println("Enter Score #1: ");
        score1 = keyboard.nextDouble();

        System.out.println("Enter Score #2: ");
        score2 = keyboard.nextDouble();

        System.out.println("Enter Score #3: ");
        score3 = keyboard.nextDouble();

        average = (score1 + score2 + score3) / 3.0 ;

        System.out.println("Your average score:" + average );

        if (average >= 95)
            System.out.println("Good job!");
    }
}
