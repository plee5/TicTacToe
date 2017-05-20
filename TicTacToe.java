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
                player.play();
                index = other(index);
            }
        }
    }
    
    private int other(int x) {
        if (x == 0) {
            return 1;
        }
        return 0;
    }
    
    /** Determines if there is a winner. */
    public boolean winner()
    {
        
    }
    
    
    /** Returns true if the board isn't full meaning the player can play. */
    public boolean canPlay() {
        return !isBoardFull();
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

    

}