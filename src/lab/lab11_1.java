package lab;

import java.util.Random;
import java.util.Scanner;

public class lab11_1
{
    public static void main(String[] args)
    {
        /*
        Write a Java that randomly generates the five winning numbers for a lottery.
        In main, create two arrays with five indexes,
        one named winningNums to hold the winning numbers,
        one called userNums to hold the user’s input.
Call a void method named generateNumbers and pass winningNums.
In this method:
Generate five integers that range from 1 to 99. Store the generated numbers in winningNums.
Although duplicates might be generated, you may ignore that for now.
Back in main, call a void method named getUserNumbers and pass userNums.
In this method:
Ask the user to enter five numbers and store them in userNums.
Do not worry about invalid inputs.
Finally, call a void method named displayResults and pass winningNums and userNums.
In this method:
Display the winning numbers and tell the user how many they got correct.
The indexes don’t have to match for two numbers to be considered a match.
For example, the following two arrays should be considered as having three matches:
{5, 12, 45, 20, 40}
{5, 45, 80, 90, 12}
Hint: There are several ways to check for matches.
One simple way is with nested loops.
For each element in the first array, check each index in the second array to see if there is a match.
         */
        Scanner keyboard = new Scanner(System.in);
        int[] winningNums = new int[5];
        int[] userNums = new int[5];
        char continueFlag = 'n';
        do
        {
        generateNumbers(winningNums);
        getUserNumbers(userNums);
        displayResults(winningNums, userNums);
        keyboard.nextLine();
        System.out.print("Do you get another try(y/n):");
        continueFlag = keyboard.next().charAt(0);
        }while(continueFlag == 'y' || continueFlag == 'Y');

    }

    public static void generateNumbers(int[] arr)
    {
        /*
        Call a void method named generateNumbers and pass winningNums.
        Generate five integers that range from 1 to 99. Store the generated numbers in winningNums.
        Although duplicates might be generated, you may ignore that for now.
         */
        for(int i = 0 ; i < 5; i++)
        {
            Random random = new Random();
            arr[i] = random.nextInt(1,11);
        }


    }

    public static void getUserNumbers(int[] arr)
    {
        /*
       Back in main, call a void method named getUserNumbers and pass userNums.
In this method:
Ask the user to enter five numbers and store them in userNums.
Do not worry about invalid inputs.
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter five numbers(1-10):");
        for(int i = 0 ; i < 5; i++)
        {
            arr[i] = keyboard.nextInt();
        }
    }

    public static void displayResults(int[] arr1, int[]arr2)
    {
       /*
       Finally, call a void method named displayResults and pass winningNums and userNums.
In this method:
Display the winning numbers and tell the user how many they got correct.
The indexes don’t have to match for two numbers to be considered a match.
For example, the following two arrays should be considered as having three matches:
{5, 12, 45, 20, 40}
{5, 45, 80, 90, 12}
        */
        int matches = 0;
        System.out.println();
        System.out.print("Winning Numbers is:");


        System.out.print("{ ");
        for(int i = 0; i < arr1.length-1; i++)
        {
            System.out.print( arr1[i] + ", ") ;
        }
        System.out.print(arr1[arr1.length-1] + " }");

        System.out.println();
        System.out.print("Your entered is:");

        System.out.print("{ ");

        for(int i = 0; i < arr2.length - 1; i++)
        {
            System.out.print( arr2[i] + ", ") ;
        }
        System.out.print(arr2[arr2.length-1] + " }");

        for(int i = 0 ; i < 5 ; i++)
        {
            for(int j = 0 ; j < 5; j++)
            {
                if (arr1[i] == arr2[j])
                {
                    matches++;
                }
            }
        }

        System.out.println();
        System.out.print("Your get " + matches + " times matches!");
    }

}

