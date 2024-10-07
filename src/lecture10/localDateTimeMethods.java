package lecture10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class localDateTimeMethods
{
    public static void main(String[] args)
    {
        LocalDateTime dateTime = LocalDateTime.now(); // Returns a LocalDateTime object
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("h:mm"); // e.g. 9:03, or 12:03
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH:mm"); // e.g. 21:03 for 9:03pm, or 00:03 for 12:03am
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("h:mm:SS"); // e.g. 12:20:38
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("hh:mm"); // e.g. 09:20

        System.out.println(dateTime.getYear()); // Prints 2024
        System.out.println(dateTime.getMonthValue()); // Prints 9
        System.out.println(dateTime.getDayOfMonth()); // Prints 24
        System.out.println(dateTime.getDayOfWeek()); // Prints Tuesday
        System.out.println(dateTime.getMonth()); // Prints SEPTEMBER
        System.out.println(formatter1.format(dateTime)); //
        System.out.println(formatter2.format(dateTime)); //
        System.out.println(formatter3.format(dateTime)); //
        System.out.println(formatter4.format(dateTime)); //
        System.out.println(formatter5.format(dateTime)); //
    }
}
