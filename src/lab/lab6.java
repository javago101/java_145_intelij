package lab;

import java.text.NumberFormat;
import java.util.Scanner;

public class lab6
{
    public static void main(String[] args)
    {
        double distance, weight, cost;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        // price, weight and distance gap
        final double P1 = 0.50;
        final double P2 = 1.10;
        final double P3 = 1.75;
        final double P4 = 2.00;

        final int W1 = 3;
        final int W2 = 7;
        final int W3 = 15;
        final int W4 = 20;

        final int GAP = 200;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please tell us how far you'd like to ship(miles)? ==>");
        distance = keyboard.nextDouble();

        while( distance < 0 ) {
            System.out.print("The distance can't be negative, please try again? ==>");
            distance = keyboard.nextDouble();
        }
        while( distance < 10 ){
            System.out.print("Sorry it's too close to ship, please try again ==>");
            distance = keyboard.nextDouble();
        }
        while( distance > 3000 ){
            System.out.print("Sorry it's too far to ship!  please try again ==>");
            distance = keyboard.nextDouble();
        }
        System.out.print( "Please tell us the weight of your packages(kg)? ==>");
        weight = keyboard.nextDouble();
        while( weight < 0 ) {
            System.out.print("The weight can't be negative, please try again ==>");
            weight = keyboard.nextDouble();
        }
        while( weight > W4 ){
            System.out.print("Sorry it's too heavy to ship, please try again! ==>");
            weight = keyboard.nextDouble();
        }
        if(weight <= W1){
            // cost = P1 * distance / GAP;
            cost = P1 * distance / GAP;
        }
        else if (weight >W1 && weight <= W2 ){
            // cost = P1 * W1 / GAP + (weight-W1) * distance / GAP;
            cost = P2 * distance / GAP;
        }
        else if (weight >W2 && weight <= W3 ){
            //cost = P1 * W1 / GAP + P2 * (W3 - W2) * P2 / GAP + (weight-W3) * distance / GAP;
            cost = P3 * distance / GAP;
        }
        else{
            // cost = P1 * W1 / GAP + P2 * (W3 - W2) * P2 / GAP  + P3 *(W4 - W3)/ GAP+ (weight-W4) * distance / GAP;
            cost = P4 * distance / GAP;
        }
        System.out.println();
        System.out.println("Your shipment info as below:");
        System.out.println("ship distance: " + distance + "miles");
        System.out.println("package weight: " + weight + "kg");
        System.out.println("ship cost:" +formatter.format(cost));
    }
}
