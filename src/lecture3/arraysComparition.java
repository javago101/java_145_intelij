package lecture3;

import java.util.Arrays;

public class arraysComparition
{
    public static void main(String[] args)
    {
        int[] arr1 = { 5, 6, 7, 20, 35};
        int[] arr2 = { 5, 6, 7, 20, 35};

        System.out.println(arr1);
        System.out.println(arr2);

        System.out.println("the value of \"arr1.equals(arr2)\" is: " +  arr1.equals(arr2));
        // '\' can ignore next buffer

        // The backslash '\' is used to escape special characters in strings

// Some common escape sequences:
// \n - newline
// \t - tab
// \\ - backslash
// \" - double quote
// \' - single quote

        if(Arrays.equals(arr1, arr2))
        {
            System.out.println("The arrays are same.");
        }
        else
        {
            System.out.println("The arrays are not same.");

        }
    }
}
