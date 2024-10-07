package lecture9;

import java.io.File;
import java.util.Scanner;

public class searchFile

{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What student's grade would you like to see? ");
        String name = keyboard.nextLine();
        boolean studentFound = false;
        Scanner inputFile = new Scanner(System.in);
        while (inputFile.hasNext())
        {
            // See if next name in file matches the name the user entered.
            String name2 = inputFile.nextLine();
            if (name2.equalsIgnoreCase(name))
            {
                // Names match! Next line in file contains this student's grade
                System.out.println("Student's grade is " + inputFile.nextLine());
                studentFound = true;
                break;
            }
            inputFile.nextLine(); // Student not found yet. Move Scanner past next score
        }
    }
}
