package lecture13;

import java.util.Scanner;

public class _ticTacToeEx2
{
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char currentPlayer = 'X'; // X starts the game
        boolean gameWon = false;

        // Create a scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Keep playing until game is over (either someone wins or it's a tie)
        while (!gameOver(board)) {
            printBoard(board);

            // Get the row and column from the current player
            int row, col;
            do {
                System.out.println("Player " + currentPlayer + "'s turn");
                System.out.print("Enter row (1-3): ");
                row = scanner.nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                col = scanner.nextInt() - 1;
            } while (!isValidMove(board, row, col));

            // Place the player's move on the board
            board[row][col] = currentPlayer;

            // Check if the current player has won the game
            if (hasWon(board, currentPlayer)) {
                gameWon = true;
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Switch player (X -> O, O -> X)
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        // If the game ends in a tie
        if (!gameWon && gameOver(board)) {
            printBoard(board);
            System.out.println("The game is a tie!");
        }

        scanner.close();
    }

    // Function to print the Tic-Tac-Toe board
    public static void printBoard(char[][] board) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // Function to check if a move is valid (i.e., within bounds and on an empty cell)
    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid move! Try again.");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println("Cell already taken! Try again.");
            return false;
        }
        return true;
    }

    // Function to check if a player has won
    public static boolean hasWon(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Function to check if the game is over (either a player has won or the board is full)
    public static boolean gameOver(char[][] board) {
        // Check if there is a winner
        if (hasWon(board, 'X') || hasWon(board, 'O')) {
            return true;
        }

        // Check if the board is full (a tie)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // There are still empty spaces, so the game is not over
                }
            }
        }

        return true; // Board is full and no winner, so it's a tie
    }
}
