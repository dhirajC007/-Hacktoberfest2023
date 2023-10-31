import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        boolean gameWon = false;
        
        while (true) {
            printBoard(board);
            int[] move = getPlayerMove(board, currentPlayer);
            int row = move[0];
            int col = move[1];
            
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer, row, col);
                
                if (gameWon) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a tie!");
                    break;
                }
                
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
    
    // Print the current state of the board
    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }
    
    // Get a valid move from the current player
    public static int[] getPlayerMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        
        while (true) {
            System.out.print("Player " + player + ", enter your move (row and column): ");
            try {
                move[0] = scanner.nextInt();
                move[1] = scanner.nextInt();
                
                if (move[0] >= 0 && move[0] < 3 && move[1] >= 0 && move[1] < 3) {
                    return move;
                } else {
                    System.out.println("Invalid move. Row and column must be between 0 and 2.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers.");
                scanner.nextLine();
            }
        }
    }
    
    // Check if the current player has won
    public static boolean checkWin(char[][] board, char player, int row, int col) {
        return (board[row][0] == player && board[row][1] == player && board[row][2] == player) ||
               (board[0][col] == player && board[1][col] == player && board[2][col] == player) ||
               (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
    
    // Check if the board is full
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
