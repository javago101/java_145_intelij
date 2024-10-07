package lab;

import java.util.Scanner;

public class lab7_2
{
    public static void main(String[] args)
    {
        int multiplier_bound, multiplicand_bound;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the upper bound of the multiplier: ");
        multiplier_bound = keyboard.nextInt();
        System.out.print("Enter the upper bound of the multiplicand: ");
        multiplicand_bound = keyboard.nextInt();

        for (int i = 1; i <= multiplier_bound; i++)
        {
            for ( int j = 1 ; j <= multiplicand_bound; j++)
            {
                System.out.println(i + "X" + j);
            }
        }


    }
}
