import java.util.Scanner;

/**
Simple one game of TicTacToe.

@author Patrick Lee
@date March 26, 2017
*/

public class TicTacToe() {
    
    public static final char EMPTY = '-';
    public static final char X = 'x';
    public static final char O = 'o';
    
    private int index = 0;
    private TicTacToePlayer[] player;
    
    public TicTacToe() {
        TicTacToePlayer p1 = new TicTacToePlayer(X);
        TicTacToePlayer p2 = new TicTacToePlayer(O);
        player = new TicTacToePlayer[2];
        player[0] = p1;
        player[1] = p2;
    }

    
    /** Player 0 is X while player 1 is O */
    private int player = 0;

    /** Creating the board. */
    public static int ROW = 3;
    public static int COL = 3;
    public static char[][] board = new char[ROW][COL];
    
    public void playGame() {
        
        TicTacToePlayer player = players[index];
        while (true) {
            if (canPlay) {
                mark(player.play(), playa);
                index = other(index);
            }
        }
    }
    
    private void mark(int[] rc, TicTacToePlayer pl) {
        board[rc[0]][rc[1]] = pl.getPiece();
    }
    
    private int other(int x) {
        if (x == 0) {
            return 1;
        }
        return 0;
    }
    

    
    /** Returns true if the board isn't full meaning the player can play. */
    public boolean canPlay() {
        return !isBoardFull();  //need to make so no winner
    }
    
    
    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    
    /** Initialize the game-board contents and the current states */
    public static void setupGame() {
       for (int row = 0; row < ROW;row++) {
          for (int col = 0; col < COL; col++) {
             board[row][col] = EMPTY;  // all cells empty
          }
       }
    }

    /** Determines if there is a winner. */
    public boolean winner()
    {
        return checkDiag || checkRow || checkCol;
    }
    
    private boolean checkDiag() {
        return checkWin(board[0][0], board[1][1], board[2][2]);
    }
    
    private boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (checkWin(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkCol() {
        for (int i = 0; i < 3; i++) {
            if (checkWin(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWin(char r1, char r2, char r3) {
        return (r1 != '-') && r1 == r2 && r2 == r3;
    }

    /** Print out the board. */
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    

}