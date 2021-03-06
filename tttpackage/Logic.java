/* Copyright (c) 2009,
 * All Rights Reserved.
 *
 * Anthony Robinson
 * anthor@pdx.edu
 *
 * FILE: Logic.java
 *
 *
 * Purpose: Software Engineering Project - Tic Tac Toe Component
 *
 * Logic.java is meant to be a unit of the tic tac toe program
 * that decides a win, loss, or early draw in the game. The
 * tic tac toe program is relatively simple so as far as a data
 * structure I am planning on just using a 3x3 array of ints to
 * represent the current state of the board, -2 represents an "O"
 * in the spot, and a +3 represents a "X" in the spot. The reason
 * for this is so that when i add any column row or diagonal
 * it will be (disregarding order) X X X (9), X X O (4) , X O O (-1),
 * O O O (-6), X X (6), O O (-4), X O(1), X (3), or O(-2), or 0 if
 * nothing is in the row/column/diagonal. So, the cases are all unique
 * where a 9 or a -6 represent a win, all others help us decide an early
 * draw (if there is an x and o in every column,row,diagonal then it is a
 * draw. => the sum of the r/c/d is 4,-1 or 1).
 *
 * PSUEDO CODE:
 *
 * create a private 3x3 array of ints called "board"
 *      (we want the array in our logic class because we will
 *       be doing the most data manipulation with it)
 *
 * add function to support changing the board data.
 *      - addMove(row,column,new_value)
 *        ** check for row column bounds and
 *        ** make new_value accept char "x" or "o"
 *      - make sure addMove calls a win,loss,draw checking function
 *
 * add function to check for wins draws or losses
 *      - checkBoard()
 *        ** Have it call the appropriate function to disable input
 *        ** and notify the user(s) of the situation / clear the board.
 *
 * possibly add a function to create a game log, not sure if it should be
 * part of the logic class but it wouldn't be too far of a stretch since
 * it will be recieving all the moves anyways.
 *
 * create a test utility to take in arguments from command line to test,
 * or if no command line arguments it will use the not so great random
 * number generator mod(3) on each of the board array pieces to create
 * a "random" situation, display it to the command line so that the tester
 * can verify that it is in fact a win loss or draw as process claims.
 * 
 *
 *
 */

package tttpackage;

// Used for text cases
//import java.util.Random;
//import java.util.Date;


public class Logic
{

    // create a private 3x3 array of ints called "board"
    private int[][] board = new int[3][3];

    void cleanBoard()
        {
        int i;
        int j;
        for(i=0;i<3;++i)
            {
            for(j=0;j<3;++j)
                {
                board[i][j]=0;
                }
            }
        }
    // translateMove(char) turns char values of the board to the correct int
    // mainly to clean up code.
    private int translateMove(char char_input)
        {
        if(char_input == 'x' || char_input == 'X')
            {
            return 3;
            }
        else if(char_input == 'o' || char_input == 'O')
            {
            return -2;
            }
        return 0;
        }

    // translateMove(int) is used for the testing functionality
    // since mod(3) will need to be converted to the appropriate
    // integer values that our program uses, x=3,o=-2, blank=0
    private int translateMove(int int_input)
        {
        if(int_input == 1) // Assign x value
            {
            return 3;
            }
        else if(int_input == 2) // Assign o value
            {
            return -2;
            }
        return 0; // Else assign blank
        }

    // Add move to the board by char value,
    // 'x' 'o' or any other char (blank)
    void addMove(int row,int col,char new_value)
        {

        // check for row column bounds
        if(row>=0 && row<3 && col>=0 && col<3)
            {
            board[row][col] = translateMove(new_value);
            checkBoard();
            }
        }

    // Add move by values (0,1,2) (for testing)
    // 0 = blank, 1 = O, 2 = X
    void addMove(int row,int col,int new_value)
        {

        // check for row column bounds
        if(row>=0 && row<3 && col>=0 && col<3)
            {
            board[row][col] = translateMove(new_value);
            checkBoard();
            }
        }

    // Changes the values stored in our board array to chars representing
    // X, O or a blank in the board.
    char rTranslateMove(int board_value)
    {
    if(board_value==-2)
        {
        return 'O';
        }
    if(board_value==3)
        {
        return 'X';
        }
    return ' ';
    }

    // displayBoard outputs the board contents to the console
    // for debugging / testing purposes.
    void displayBoard()
        {
        System.out.printf("\n%c|%c|%c\n",rTranslateMove(board[0][0]),
                rTranslateMove(board[0][1]),rTranslateMove(board[0][2]));
        System.out.printf("-----\n");
        System.out.printf("%c|%c|%c\n",rTranslateMove(board[1][0]),
                rTranslateMove(board[1][1]),rTranslateMove(board[1][2]));
        System.out.printf("-----\n");
        System.out.printf("%c|%c|%c\n",rTranslateMove(board[2][0]),
                rTranslateMove(board[2][1]),rTranslateMove(board[2][2]));
        }

    // checkBoard(): Checks the 3 rows, 3 columns and 2 diagonals
    // for a win, or loss. Increments the draw_counter for each
    // row column or diagonal that contains an x and o. And we need to
    // have it call the appropriate function to disable input
    // and notify the user(s) of the situation.
    // Returns 3 for draw game, 2 for X wins, 1 for O wins, and 0 for nothing.
    int checkBoard()
        {
        int draw_counter=0;

        int[] sums = new int[8];

        // Sum Rows
        sums[0]=board[0][0]+board[0][1]+board[0][2];
        sums[1]=board[1][0]+board[1][1]+board[1][2];
        sums[2]=board[2][0]+board[2][1]+board[2][2];

        // Sum Columns
        sums[3]=board[0][0]+board[1][0]+board[2][0];
        sums[4]=board[0][1]+board[1][1]+board[2][1];
        sums[5]=board[0][2]+board[1][2]+board[2][2];

        // Sum Diagonals
        sums[6]=board[0][0]+board[1][1]+board[2][2];
        sums[7]=board[0][2]+board[1][1]+board[2][0];

        int i;

        // Check each of the 8 ways to win for win loss or draw situation
        for(i=0;i<8;++i)
            {
            //Check for x and o in the same row/col/diag and
            //increment counter to detect early draw.
            if(sums[i]==4||sums[i]==1||sums[i]==-1)
                {
                ++draw_counter;
                }
            if(sums[i]==9)
                {  
                return 2;
                }
            if(sums[i]==-6)
                {
                return 1;
                }
            }
        // Check for early draw
        if(draw_counter == 8)
            {
            return 3;
            }

        return 0; // No win loss or draw.
        }

    public Logic()
        {

        }
/*
    public static void main(String[] args)
        {
        Logic new_board = new Logic();

        Date current = new Date(); // To seed the random number generator
        Random generator = new Random(current.getTime()); // To give better tests


        // For testing different cases, adds 9 arguments given
        // by command line to the board.
        if(args.length==9) 
            {
            int j;
            int i;
            for(j=0;j<3;++j)
                {
                for(i=0;i<3;++i)
                    {
                    if(args[i+j*3].charAt(0)=='R') // Replace R w/ X or O
                        {
                        new_board.addMove(j, i, generator.nextInt()%3);
                        }
                    else // Add the char give to the board.
                        {
                        new_board.addMove(j, i, args[i+j*3].charAt(0));
                        }
                    }
                }
           
            }
        else // Generate a Random Tic Tac Toe Board for Testing
            {
            new_board.addMove(0, 0, generator.nextInt()%3);
            new_board.addMove(0, 1, generator.nextInt()%3);
            new_board.addMove(0, 2, generator.nextInt()%3);
            new_board.addMove(1, 0, generator.nextInt()%3);
            new_board.addMove(1, 1, generator.nextInt()%3);
            new_board.addMove(1, 2, generator.nextInt()%3);
            new_board.addMove(2, 1, generator.nextInt()%3);
            new_board.addMove(2, 0, generator.nextInt()%3);
            new_board.addMove(2, 2, generator.nextInt()%3);
            }

        new_board.displayBoard(); // Displays the board to the console for testing
        }
 */
}
