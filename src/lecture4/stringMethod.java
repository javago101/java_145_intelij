package lecture4;

import java.util.Scanner;

public class stringMethod
{
    public static void main(String[] args)
    {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your phone number with the format:(###) ###-####");
        String phoneNumber = keyboard.nextLine();
        String areaCode = phoneNumber.substring(1,4);
        String extension = phoneNumber.substring(10,14);

        System.out.println("Your phone number is " + phoneNumber);
        System.out.println("The area code is " + areaCode);
        System.out.println("The extension code is " + extension);
    }
}

