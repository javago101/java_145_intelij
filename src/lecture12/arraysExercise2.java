package lecture12;

import java.util.Scanner;

public class arraysExercise2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int[] arr1 = {2,4,5,7};
        int[] arr2 = arr1.clone();

        arr2[0] = 50;

        arr1[3] = 90;

        for(int val : arr1)
        {
            System.out.print(val + " ");
        }

        System.out.println();

        for(int val : arr2)
        {
            System.out.print(val + " ");
        }

        showArrays(arr1);

        showArrays(arr2);

        change(arr1);

        change(arr1.clone());

        change(arr2);

        showArrays(arr1);

        showArrays(arr2);
    }

    public static void change(int[] arr)
    {
        arr[0] = 10000;
    }

    public static void showArrays(int[] arr)
    {
        System.out.println();
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print( arr[i] + " ") ;
        }
    }
}
