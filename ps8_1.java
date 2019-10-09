
/**
 * Connect-four game!
 * 
 */

import java.util.*;
public class ps8_1 {
    public static int turn_number = 0;
    
    public static void main(String[] args){
        char[][] board = new char[6][7];
        showBoard(board);
        boolean flag = false;
        while (!flag) {
            loadData(board);
            printData(board);
            turn_number++;
            flag = checkWin(board);
        }
        
        if (turn_number % 2 == 1) {
            System.out.println("Red player wins.");
        } else {
            System.out.println("Yellow player wins."); 
        }
    }
    
    public static void showBoard(char[][] tbl){
        for (int r = 0; r < tbl.length; r++){
            for (int c = 0; c < tbl[r].length; c++){
                tbl[r][c] = ' ';
                System.out.print("| " + tbl[r][c]);
            } // end of col loop
            System.out.println("|");
        } // end of row loop
        System.out.println("----------------------");
    }
    
    public static void loadData(char[][] t) {
        Scanner input = new Scanner(System.in);
        int column;
        int bottom_row = t.length - 1;
        if (turn_number % 2 == 0) {
            System.out.println("Drop a red disk at column (0-6):");
            column = input.nextInt();
            
            for (int i = bottom_row; i >= 0; i--){
                if (t[i][column] == 'R' || t[i][column] == 'Y'){
                    continue;
                } else {
                    t[i][column] = 'R';
                    break;
                }
            }
        } else {
            System.out.println("Drop a yellow disk at column (0-6):");
            column = input.nextInt();
            
            for (int i = bottom_row; i >= 0; i--){
                if (t[i][column] == 'R' || t[i][column] == 'Y'){
                    continue;
                } else {
                    t[i][column] = 'Y';
                    break;
                }
            }
        }
    }
    
    public static void printData(char[][] tbl){
        for (int r = 0; r < tbl.length; r++){
            for (int c = 0; c < tbl[r].length; c++){
                System.out.print("|" + tbl[r][c] + " ");
            } // end of col loop
            System.out.println("|");
        } // end of row loop
        System.out.println("----------------------");
    }    

// Method to check for a winner. Receives 2-D array as parameter. Returns boolean value.
    public static boolean checkWin(char[][] b)
    {
        // Create four boolean variables, one for each set of rows. Initialize all of them to false.
        boolean foundRow = false;
        boolean foundCol = false;
        boolean foundMjrD = false;
        boolean foundMinD = false;
        
        // Check to see if four consecutive cells in a row match.
        // check rows
        for (int r = 0; r <= 5; r++)
        {
            for (int c = 0; c <= 3; c++)
            {
                if (b[r][c] == b[r][c + 1] && b[r][c] == b[r][c + 2] && b[r][c] == b[r][c + 3] && b[r][c] != ' ')
                {
                    foundRow = true;
                    break;
                }
            }
        }
        
        // Check to see if four columns in the same row match
        // check columns
        for (int r = 0 ; r <= 2; r++)
        {
            for (int c = 0; c <= 6; c++)
            {
                if (b[r][c] == b[r + 1][c] && b[r][c] == b[r + 2][c] && b[r][c] == b[r + 3][c] && b[r][c] != ' ')
                {
                    foundCol = true;
                    break;
                }
            }
        }
        
        // Check to see if four diagonals match (top left to bottom right)
        // check major diagonal
        for (int r = 0; r <= 2; r++)
        {
            for (int c = 0; c <= 3; c++)
            {
                if (b[r][c] == b[r + 1][c + 1] && b[r][c] == b[r + 2][c + 2] && b[r][c] == b[r + 3][c + 3] && b[r][c] != ' ')
                {
                    foundMjrD = true;
                    break;
                }
            }
        }
        
        // Check to see if four diagonals in the other direction match (top right to bottom left)
        // check minor diagonal
        for (int r = 0; r <= 2; r++)
        {
            for (int c = 3; c <= 6; c++)
            {
                if (b[r][c] == b[r + 1][c - 1] && b[r][c] == b[r + 2][c - 2] && b[r][c] == b[r + 3][c - 3] && b[r][c] != ' ')
                {
                    foundMinD = true;
                    break;
                }
            }
        }
        
        // If ONE of the booleans is true, we have a winner.
        // checks boolean for a true
        if (foundRow || foundCol || foundMjrD || foundMinD)
            return true;
        else
            return false;
    } // end checkWin method    
    
}