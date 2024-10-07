package lab;

import java.util.Scanner;

public class lab3
{
    public static void main(String[] args)
    {
        int priceA , priceB, priceC;
        int amountSaleA, amountSaleB, amountSaleC;
        double revenueA, revenueB, revenueC , total_revenue;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How much is a seat in section A?");
        priceA = keyboard.nextInt() ;
        System.out.print("How much is a seat in section B?");
        priceB = keyboard.nextInt() ;
        System.out.print("How much is a seat in section C?");
        priceC = keyboard.nextInt() ;
        System.out.print("How many seats were sold  in section A?");
        amountSaleA  = keyboard.nextInt() ;
        System.out.print("How many seats were sold  in section B?");
        amountSaleB  = keyboard.nextInt() ;
        System.out.print("How many seats were sold  in section C?");
        amountSaleC  = keyboard.nextInt() ;
        System.out.println();
        System.out.println("Revenue:");
        System.out.print("\n");
        System.out.println("Section A: $"  + (double)priceA * amountSaleA);
        System.out.println("Section B: $"  + (double)priceB * amountSaleB);
        System.out.println("Section C: $"  + (double)priceC * amountSaleC);
        total_revenue =(double)priceA * amountSaleA +(double)priceB * amountSaleB +(double)priceC * amountSaleC;
        // System.out.println("Total: $"  + (double)(priceC * amountSaleC +priceB * amountSaleB +priceC * amountSaleC) );
        System.out.println("Total: $"  + total_revenue );
    }
}
