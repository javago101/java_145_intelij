package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab11_2_1 {

    public static String[] getQuote() {
        String quote = "";
        try {
            File file = new File("quote.txt");
            Scanner fileScanner = new Scanner(file);
            if (fileScanner.hasNextLine()) {
                quote = fileScanner.nextLine();
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return quote.split(" ");
    }

    public static void findWord(String[] words) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search for: ");
        String searchWord = scanner.nextLine();

        int count = 0;
        for (String word : words) {
            if (word.equals(searchWord)) {
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
