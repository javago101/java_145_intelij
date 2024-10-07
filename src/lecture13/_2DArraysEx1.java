package lecture13;

import java.util.Scanner;

public class _2DArraysEx1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        double[][] scores = new double[3][4];
        double[][] heights = {
                {7.5, 8.1, 9.2},
                {7.6, 8.1, 8.2},
                {6.8, 7.5, 7.9},
                {6.5, 6.7, 7.1}
        };
        double[] first = scores[0];
        //Print first roe
        for(int i =0 ; i < scores[0].length; i++)
        {
            System.out.println(scores[0][i] + " ");
        }

        // Allow the user to fill up the array
        for(int i = 0; i < scores.length ; i++)
        {
            for( int j = 0 ; j < scores[i].length; j++)
            {
                System.out.print("Enter score #: " + (j+1) + " for student #:" + (i + 1) + ": ");
                scores[i][j] = keyboard.nextDouble();
            }
        }

        //Print first row
        for(int i =0 ; i < scores[0].length; i++)
        {
            System.out.println(scores[0][i] + " ");
        }
    }
}
