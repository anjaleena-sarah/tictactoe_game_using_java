import java.util.Scanner;

public class tictactoe 
{
    public static void main(String[] args) 
    {
        char[][] board = new char[3][3]; //creating a 3x3 board

        // Initializing the board as empty
        for (int row = 0; row < board.length; row++) 
        {
            for (int col = 0; col < board[row].length; col++)
            {
                board[row][col] = ' ';
            }
        }

        // Player starts as 'X'
        char player = 'X';
        boolean gameOver = false; // Game is not over initially

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) 
        {
            printBoard(board); // Print the board
            System.out.print("Player " + player + " enter row and column (0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            // Check if input is valid
            if (row < 0 || row >= 3 || col < 0 || col >= 3) 
            {
                System.out.println("Invalid input. Row and column must be between 0 and 2.");
            } 
            else if (board[row][col] == ' ') 
            {
                board[row][col] = player; // Place the element
                gameOver = haveWon(board, player);
                if (gameOver) 
                {
                    System.out.println("Player " + player + " has won!");
                } 
                else 
                {
                    // Switch player
                    player = (player == 'X') ? 'O' : 'X';
                }
            } 
            else 
            {
                System.out.println("Invalid move. Cell already taken. Try again!");
            }
        }

        printBoard(board); // Print final board state
        scanner.close(); // Close the scanner
    }

    public static boolean haveWon(char[][] board, char player)
    {
        // Check rows
        for (int row = 0; row < board.length; row++) 
        {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) 
            {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < board[0].length; col++) 
        {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) 
            {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) 
        {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) 
        {
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) 
    {
        for (int row = 0; row < board.length; row++) 
        {
            for (int col = 0; col < board[row].length; col++) 
            {
                System.out.print(board[row][col]);
                if (col < board[row].length - 1) 
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < board.length - 1) 
            {
                System.out.println("---------");
            }
        }
    }
}
