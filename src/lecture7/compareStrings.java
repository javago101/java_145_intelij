package lecture7;

import java.util.Scanner;

public class compareStrings
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String quit = "";
        System.out.print("Enter a name: ");
        String name1 = keyboard.nextLine();
        System.out.print("Enter another name: ");
        String name2 = keyboard.nextLine();
        if (name1.equals(name2))
            System.out.println("The names are the same!");
        else
            System.out.println("The names are not the same!");

        while(!quit.equalsIgnoreCase("quit")){
            System.out.println("Enter 'quit' to quit:");
            quit = keyboard.nextLine();
        }

    }
}
