package lecture10;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class methodInto
{
    /*
    public class Main
{
public static void main(String[] args)
{
method2(); // Method call
statement;
method1(); // Method call
}
public static void method1()
{
statement;
statement;
}
public static void method2()
{
statement;
statement;
statement;
}
}
     */
    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hi, there!");
        methodName();
        getCurrentDate();
       String name = getName(); // variable can't have same name in a same scope,
        System.out.println(name);
    }

    public static  void  methodName()
    {
       // code block
       System.out.println("This is a method."); // Q: how to get the name of current method
    }

    public static void getCurrentDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Today's date is " + formatter.format(dateTime));
    }

    public static String getName()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = keyboard.nextLine();
        return name;
        //when a method ends, all of the local variables declared inside it are
        // deleted (i.e. removed from memory) at that point.
    }
}
