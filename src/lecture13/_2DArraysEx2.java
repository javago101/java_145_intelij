package lecture13;

import java.util.Scanner;

public class _2DArraysEx2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        final int ROWS = 4;
        final int COLS = 3;
        double[][] scores = {
                {7.5, 8.1, 9.2},
                {7.6, 8.1, 8.2},
                {6.8, 7.5, 7.9},
                {6.5, 6.7, 7.1}
        };
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                System.out.println("Enter a score: ");
                scores[row][col] = keyboard.nextDouble();
            }
        }
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
                System.out.println(scores[row][col]);
        }
    }
}
