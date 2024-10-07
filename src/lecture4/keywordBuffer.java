package lecture4;

import java.util.Scanner;

public class keywordBuffer
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("how many hours did you work?");
        double hours = keyboard.nextDouble();
        System.out.println("What's your pay rates");
        double payRates = keyboard.nextDouble();
        // keyboard.nextLine();
        System.out.println("What's your name");
        String name = keyboard.nextLine();

        System.out.println("Hello," + name);
        System.out.println("your pay rates is " + payRates);
        System.out.println("your work hours is " + hours);

        System.out.println("Enter your name ,pay rate, and work hours!");
        String name1 = keyboard.nextLine();
        double payRates1 = keyboard.nextDouble();
        double hours1 = keyboard.nextDouble();

        System.out.println("Hello," + name1);
        System.out.println("your pay rates is " + payRates1);
        System.out.println("your work hours is " + hours1);

    }
}
