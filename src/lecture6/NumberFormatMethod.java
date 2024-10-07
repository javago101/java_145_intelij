package lecture6;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.NumberFormat;

public class NumberFormatMethod
{
    public static void main(String[] args)
    {
        // Part1
        System.out.println("Part 1:");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner keyboard = new Scanner(System.in);
        double purchaseAmount , taxRate;
        System.out.print("How much was your purchase? $");
        purchaseAmount = keyboard.nextDouble();
        System.out.print("What is the tax rate? (i.e. enter 12.5 if tax rate is 12.5%): ");
        taxRate = keyboard.nextDouble();
        double total = purchaseAmount + purchaseAmount * (taxRate / 100);
        System.out.println("$" + total);
        System.out.println("You spent " + formatter.format(total));

        System.out.println();

        // Part 2
        System.out.println("Part 2:");
        DecimalFormat dec_formatter = new DecimalFormat("#,###.##");
        System.out.println(dec_formatter.format(96.666666667));
    }
}
