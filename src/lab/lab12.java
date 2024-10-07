package lab;

public class lab12
{
    public static void main(String[] args)
    {
        /*
        Add the following array to your program’s main method:
          int[][] numbers = {
                {15, 25, 35, 42, 80, 75},
                {44, 55, 61, 25, 44, 10},
                {41, 55, 40, 30, 16, 33},
                {17, 40, 8, 38, 72, 19},
                };
 Write the following methods, each with a two-dimensional integer array parameter.
averageRows: Calculates and prints the average value in each row.
averageColumns: Calculates and prints the average value in each column.
findHighest: Determines and prints the largest value in the array as well as which row it is in.
         */

        int[][] numbers = {
                {15, 25, 35, 42, 80, 75},
                {44, 55, 61, 25, 44, 10},
                {41, 55, 40, 30, 16, 133},
                {17, 40, 808, 38, 72, 19},
        };
        int res[] = new int[3];
        res = findLargest(numbers);
        System.out.println();
        System.out.println("The largest number of this array is " + (res[0]+1) + " at row #:" + (res[1] +1) + " and cloumn #:" + (res[2]+1));
        System.out.println();
        averageRows(numbers);
        System.out.println();
        averageColumns(numbers);

        }
    public static int[] findLargest(int[][] arr)
    {
        int[] largestPos = {0,0,0};

        for (int i = 0; i < arr.length; i++)
        {

            int[] largestInRow  = {arr[i][0],0};

            for (int j = 1; j < arr[i].length; j++)
            {
                if (arr[i][j] > largestInRow[0])
                {
                    largestInRow[0] = arr[i][j];
                    largestInRow[1] = j;
                }


            }
            if(largestInRow[0] > largestPos[0])
            {
                largestPos[0] = largestInRow[0];
                largestPos[1] = i;
                largestPos[2] = largestInRow[1];
            }


        }
        return largestPos;
    }

    public static void averageRows (int[][] arr)
    {
        int totalInRow;
        for(int i = 0; i < arr.length; i++)
        {
            totalInRow = 0; // Be careful every time traversal a row you need to reassign total of a row

            for(int j = 0 ; j < arr[i].length; j++)
            {
                totalInRow += arr[i][j];
            }
            System.out.println("The average of " + i + " row is " + (totalInRow/arr[i].length));
        }

    }

    public static void averageColumns (int[][] arr)
    {
        int totalInCloum;
        for(int i = 0; i < arr[0].length; i++) // be careful about the i++ will approach to 5
        {
             totalInCloum = 0;

            for(int j = 0 ; j < arr.length; j++)
            {
                totalInCloum += arr[j][i];
            }
            System.out.println("The average of " + i + " Column is " + (totalInCloum/arr.length));
        }

    }
}
