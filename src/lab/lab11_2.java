package lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class lab11_2
{
    /*
    The String class has a split method which returns an array containing all tokens separated by a provided delimiter.
    A simple way to use this is to split a sentence into an array of each word it contains by using the space character as the delimeter.
    For example:
String str = “Mt San Antonio College”;
String[] tokens = str.split(“ ”); // Returns the array {“Mt”, “San”, “Antonio”, “College”)}
On Canvas, there is a file named quote.txt with text from the Wikipedia article on Mt. Sac.
All punctuation has been removed.
Add that file to your working project, and make sure it all appears on one line!
Write a method named getQuote which:
Opens the file for reading.
Assigns the quote to a String variable.
Uses the split method to convert the String to an array.
Each element in the array should be a word from the file.
Closes the file.
Returns the array.
Back in main, pass the array to a method named findWord. In this method:
Ask the user to enter a word.
Count and display how many times that word appears in the array.
     */
    public static String[] getQuote() {
        String quote = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("quote.txt"))) {
            quote = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return quote.split(" ");
    }

    public static void findWord(String[] words) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search for: ");
        String searchWord = scanner.nextLine().toLowerCase();

        int count = 0;
        for (String word : words) {
            if (word.toLowerCase().equals(searchWord)) {
                count++;
            }
        }

        System.out.println("The word '" + searchWord + "' appears " + count + " time(s) in the quote.");
    }

    public static void main(String[] args) {
        String[] quoteWords = getQuote();
        findWord(quoteWords);
    }
}
