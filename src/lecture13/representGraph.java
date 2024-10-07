package lecture13;

import java.util.Scanner;

public class representGraph
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int[][] graph = {
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 1, 0}
        };
        System.out.println("Welcome to the airline reservation system.");
        System.out.print("Enter your starting city(0-4): ");
        int city1 = keyboard.nextInt();
        System.out.print("Enter your destination(0-4): ");
        int city2 = keyboard.nextInt();
        if (hasFlight(graph, city1, city2))
            System.out.println("We have a flight between those two cities!");
        else
            System.out.println("Unfortunately, we do not have a flight between those two cities");
    }

    public static boolean hasFlight(int[][] graph, int city1, int city2)
    {
        // Return true if the index of the 2d array is 1, since this indicates a flight
        // exists between the cities on the x and y axis.
        if (city1 < 0 || city2 < 0 || city1 > 4 || city2 > 4)
        {
            System.out.println("In valid input!");
            return false;
        }

        return graph[city1][city2] == 1;
    }
}
