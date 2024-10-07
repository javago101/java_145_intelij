package lecture3;

public class objectIntro
{
    public static void main(String[] args)
    {
        // Reference Variables
        String  name;// name is null; does not create a new object , just initialize a reference data : hold the address of another object
        name = "Guoqing Wang"; // create a string object;"Aiden Wang" is a new object
        /// error // System.out.println(name); // java: variable name might not have been initialized
        name = "Aiden Wang"; // create another string object;"Aiden Wang" is another new object ;
        // the old object of "Guoqing Wang" is been garbage collected, since no name reference to it
        String greeting = "Hello! ";
        System.out.println(greeting + name);
        System.out.println(name.length());
        int numsChar = name.length();
        System.out.println(numsChar);

        // String Methods: charAt
        char c = name.charAt(2); //Assigns 'd' to c
        System.out.println(c);

        // toLowerCase();
        String text = "Hello There!";
        text.toLowerCase();

        String text1 = text.toLowerCase();

        System.out.println(text);
        System.out.println(text1);

        text.replace("Hello", "Goodbye");
        String text2 = text.replace("Hello", "Goodbye");

        System.out.println(text);
        System.out.println(text2);
    }
}
