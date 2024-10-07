package lecture13;

public class _2DArraysEx3
{
    /*
    Let’s write a method named averageHighest with a two-dimensional integer array
parameter.
● This method should find the largest value in each row, add them together, and return
their average.
● To test this method, in main we can create a two-dimensional array of integers with
an initialization list and pass it to averageHighest, then print the result.
     */
    public static double averageHighest(int[][] arr)
    {
        double total = 0;

        // Each iteration of the outer loop represents the next "row" in arr
        for (int i = 0; i < arr.length; i++)
        {
            // In the inner loop, we'll the largest value in row 'i'
            // Assume first element in row 'i' is largest
            int largestInRow = arr[i][0];
            for (int j = 1; j < arr[i].length; j++)
            {
                if (arr[i][j] > largestInRow)
                    largestInRow = arr[i][j];
            }
            total += largestInRow;
        }
        return total / arr.length;
    }
    public static void main(String[] args)
    {
        int[][] numbers = {
                {15, 25, 35, 42, 80, 75},
                {44, 55, 61, 25, 44, 10},
                {41, 55, 40, 30, 16, 33},
                {17, 40, 8, 38, 72, 19},
        };
        double result = averageHighest(numbers);
        System.out.println(result);

    }
}
