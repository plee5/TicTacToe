import java.util.Scanner;

/**
Simple one game of TicTacToe.

@author Patrick Lee
@date March 26, 2017
*/

public class TicTacToePlayer() {
    
    public char piece;
    public TicTacToePlayer(char x) {
        piece = x;
    }

    /** Get the player for this player. */
    public int[] play() {
        ///how do i want to do this
        Scanner scan = new Scanner();
        int toRet[] = new int[2];
        int row = -1;
        int col = -1;
        if (scan.hasNext()) {
            System.out.println("Please select your row.");
            row = scan.next();
            toRet[0] = row;
            if (scan.hasNext()) {
                System.out.println("Please select your column.");
                col = scan.next();
                toRet[1] = col;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return toRet;
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

}