package lecture13;

import java.util.Scanner;

public class _ticTacToeEx1
{
    public static void main(String[] args)
    {
        boolean isPlayerOneTurn = true;
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++)
        {
            for (int j= 0; j < board[0].length; j++)
            {
                board[i][j] = '.';
            }
        }
        printBoard(board);
        while (!gameOver(board))
        {
            takeTurn(board, isPlayerOneTurn);
            printBoard(board);
            // change whose turn it is
            isPlayerOneTurn = !isPlayerOneTurn;
        }
    }

    public static void printBoard(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void takeTurn(char[][] board, boolean playerOneTurn)
    {
        char playerIcon = playerOneTurn ? 'x' : 'o';
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.println(playerIcon + "'s turn");

        // Pick location
        int row = pickCoordinate("Pick a row: ", keyboard);
        int column = pickCoordinate("Pick a column: ", keyboard);

        if (board[row][column] != '.')
            System.out.println("That spot is already taken!");
        else
            board[row][column] = playerIcon;
    }

    public static int pickCoordinate(String prompt, Scanner keyboard)
    {
        System.out.print(prompt + " ");
        int val = keyboard.nextInt();
        while (val > 3 || val < 1)
        {
            System.out.println("Incorrect input");
            System.out.print(prompt + " ");
            val = keyboard.nextInt();
        }
        // Subtract 1, so if the user selects row 1, we access row 0 in the array.
        return val - 1;
    }

    public static boolean gameOver(char arr[][]) {
        // Check rows for a winner
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] != ' ' && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                return true; // Someone won in a row
            }
        }

        // Check columns for a winner
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] != ' ' && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                return true; // Someone won in a column
            }
        }

        // Check diagonals for a winner
        if (arr[0][0] != ' ' && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
            return true; // Main diagonal win
        }
        if (arr[0][2] != ' ' && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
            return true; // Anti-diagonal win
        }

        // Check for a tie (if no empty spaces and no winner)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == ' ') {
                    return false; // Game is still ongoing
                }
            }
        }

        return true; // It's a tie (no winner and no empty spaces)
    }


}
