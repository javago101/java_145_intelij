package lab;

import java.text.NumberFormat;
import java.util.Scanner;

public class lab4_1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String firstName, lastName, email = "";
        System.out.println("Please enter your First Name?");
        firstName = keyboard.nextLine();
        System.out.println("Please enter your Last Name?");
        lastName = keyboard.nextLine();
        int len = lastName.length();

        if (len < 5)
        {
            char lastChar = lastName.charAt(len - 1);
            for (int i = 0; i < 5 - len; i++)
            {
                lastName += lastChar;
            }
        }

        email = firstName.charAt(0) + lastName.substring(0, 5) + "@mtsac.edu";

        email = email.toLowerCase();

        System.out.println("part1: " + email);
        // part 2
        String webEmail;

        // webEmail = email.substring(0,6) +" at mtsac dot edu";

        webEmail = email.replace("@", " at ");
        webEmail = webEmail.replace(".", " dot ");
        System.out.println("part2: " + webEmail);
    }

    public static class lab5_B
    {
        public static void main(String[] args)
        {

            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            // DecimalFormat dec_formatter = new DecimalFormat("#,###.##");
            Scanner keyboard = new Scanner(System.in);
            int adultTicketsSold_num, childTicketsSold_num;
            final int ADULT_TICKET_PRICE = 15;
            final int CHILD_TICKET_PRICE = 8;
            final double THEATER_HOLD_RATES = 0.8, DISTRIBUTOR_HOLD_RATES = 0.2;
            double total_gross, theater_profit, distributor_profit;
            String movieName;
            System.out.println("What's the name of the movie");
            movieName = keyboard.nextLine();
            System.out.print("How many adult tickets was sold?");
            adultTicketsSold_num = keyboard.nextInt();
            System.out.print("How many child tickets was sold?");
            childTicketsSold_num = keyboard.nextInt();
            total_gross = CHILD_TICKET_PRICE * childTicketsSold_num + ADULT_TICKET_PRICE * adultTicketsSold_num;
            theater_profit = total_gross * THEATER_HOLD_RATES;
            // theater_profit = dec_formatter.format(theater_profit);
            distributor_profit = total_gross * DISTRIBUTOR_HOLD_RATES;
            // distributor_profit = dec_formatter.format(distributor_profit);
            System.out.println("Gross total: " + formatter.format(total_gross));
            System.out.println("Theater's profit: " + formatter.format(theater_profit));
            System.out.println("Distributor's profit: " + formatter.format(distributor_profit));

        }
    }

}
