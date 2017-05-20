import java.util.Scanner;

/**
Simple one game of TicTacToe.

@author Patrick Lee
@date May 19, 2017
*/

public class TicTacToePlayer {
    
    public char piece;
    public TicTacToePlayer(char x) {
        piece = x;
    }

    /** Get the player for this player. */
    public int[] play() {
        ///how do i want to do this
        Scanner scan = new Scanner(System.in);
        int toRet[] = new int[2];
        int row = -1;
        int col = -1;
        if (scan.hasNext()) {
            System.out.println("Please select your row:");
            row = Integer.parseInt(scan.next());  //currently assumes you enter int
            toRet[0] = row;
            if (scan.hasNext()) {
                System.out.println("Please select your column:");
                col = Integer.parseInt(scan.next());
                toRet[1] = col;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return toRet;
    }

    public char getPiece() {
        return piece;
    }


}