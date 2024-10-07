package lecture9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class theFileWriter
{
    public static void main(String[] args)  throws IOException
    {
        FileWriter fwriter = new FileWriter("MyFriends.txt", true);
        PrintWriter outputFile = new PrintWriter(fwriter);
        outputFile.println("Bob");
        outputFile.close();
    }
}
