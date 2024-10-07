package lecture8;

import java.util.Scanner;

public class nested_loop
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int input;

        // outer loop represents the hour
        for (int i = 0; i < 24; i++)
        {
            // inner loop for minutes
            for (int j = 0; j < 60; j++)
            {
                for( int k = 0; k < 60; k++){
                    System.out.println(i +":"+  j + ":" + k);
                }

            }
        }
    }
}
