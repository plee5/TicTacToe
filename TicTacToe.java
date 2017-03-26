import java.util.Scanner;

/**
Simple one game of TicTacToe.

@author Patrick Lee
@date March 26, 2017
*/

public class TicTacToe() {
    /* Constants to represent the O and X in the game. */
    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int O = 2;
    
    /** Creating the board. */
    public static int ROW = 3;
    public static int COL = 3;
    public static int[][] board = new int[ROW][COL];



    /** Initialize the game-board contents and the current states */
    public static void startGame() {
       for (int row = 0; row < ROW;row++) {
          for (int col = 0; col < COL; col++) {
             board[row][col] = EMPTY;  // all cells empty
          }
       }
    }    
}