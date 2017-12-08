import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, text art based.
 * All variables/methods are static.
 */
public class TicTacToe {
   //Cell value
   public static final int EMPTY = 0;
   public static final int X = 1;
   public static final int CIRCLE = 2;
 
   // States of the game
   public static final int PLAYING = 0;
   public static final int TIE = 1;
   public static final int X_WON = 2;
   public static final int CIRCLE_WON = 3;
 
   // The game board and the game status
   public static final int ROWS = 3, COLUMNS = 3; // number of rows and columns
   public static int[][] board; // game board in 2D array
                                                     
   public static int currentState;  // the current state of the game
                                    // (PLAYING, DRAW, X_WON, CIRCLE_WON)
   public static int currentPlayer; // the current player (X or CIRCLE)
   public static int currentRow, currentCol; // current cell row and column
 
   public static Scanner input = new Scanner(System.in); // the input Scanner
 
   /** The entry main method (the program starts here) */
   public static void ticTacToe() {
	   //This resets the board from the last game
	   board = new int[ROWS][COLUMNS];
	   //print the board first
	   printBoard();
      // start the game-board and current status
	   startGame();
      // Play the game once
      do {
         playerMove(currentPlayer); // update currentRow and currentCol
         updateStatus(currentPlayer, currentRow, currentCol); // update currentState
         printBoard();
         // Print message if game-over
         if (currentState == X_WON) {
            System.out.println("Player X won!");
         } else if (currentState == CIRCLE_WON) {
            System.out.println("Player O won!");
         } else if (currentState == TIE) {
            System.out.println("It's a tie!");
         }
         // Switch player
         if(currentPlayer == X) {
        	 	currentPlayer = CIRCLE;
         }
         else{
        	 	currentPlayer = X;
         }
      } while (currentState == PLAYING); // repeat if not game-over
   }
 
   /** Initialize the game-board contents and the current states */
   public static void startGame() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = EMPTY;  // all cells should be empty
         }
      }
      currentState = PLAYING; // game has begun
      currentPlayer = X;  // player X plays first
   }
 
   /** Player makes one move and update "currentRow" and "currentCol". */
   public static void playerMove(int player) {
      boolean validInput = false;  // for input validation
      do {
    	  
         if (player == X) {
            System.out.print("Player 'X', enter your move (row (1-3) column (1-3) ): ");
         } else {
            System.out.print("Player 'O', enter your move (row (1-3) column (1-3) ): ");
         }
         
         int row = input.nextInt() - 1;  // array index starts at 0 
         int column = input.nextInt() - 1;
         
         if (row >= 0 && row < ROWS && //row within bounds
        		 column >= 0 && column < COLUMNS &&  //column within bounds
        		 board[row][column] == EMPTY) { //the cell is empty
        	 
        	 	currentRow = row;
            currentCol = column;
            board[currentRow][currentCol] = player;  // update game-board 
            validInput = true;  // input okay, exit loop
            
         } else {
            System.out.println("This space at (" + (row + 1) + "," + (column + 1)
                  + ") is occupied. Try again.");
         }
      } while (!validInput);  // repeat until valid move is made
   }
 
   /** Update the "currentState" after the player has moved, update (currentRow, currentCol). */
   public static void updateStatus(int player, int currentRow, int currentCol) {
      if (hasWon(player, currentRow, currentCol)) {  // check if winning move
         if(player == X){
        	 	currentState = X_WON;
        	 	
         } else {
        	 currentState = CIRCLE_WON;
         }
         
      } else if (isTie()) {  // check for tie
         currentState = TIE;
      }
      // Otherwise, no change to currentState (still PLAYING).
   }
 
   
   /** Return true if it is a draw (no more empty cell) */
   public static boolean isTie() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            if (board[row][col] == EMPTY) {
               return false;  // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no empty cell, it's a draw
   }
 
   /** Return true if the player has won after placing at
       (currentRow, currentCol) */
   public static boolean hasWon(int player, int currentRow, int currentCol) {
      return (board[currentRow][0] == player         // 3-in-a-row
           && board[currentRow][1] == player
           && board[currentRow][2] == player
              || board[0][currentCol] == player      // 3-in-a-column
              && board[1][currentCol] == player
              && board[2][currentCol] == player
              || currentRow == currentCol            // diagonal win
              && board[0][0] == player
              && board[1][1] == player
              && board[2][2] == player
              || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
              && board[0][2] == player
              && board[1][1] == player
              && board[2][0] == player);
   }
 
   // Print game board 
   public static void printBoard() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            printCell(board[row][col]); // print each of the cells and contents
            if (col != COLUMNS - 1) {
               System.out.print("|");   // print vertical line
            }
         }
         System.out.println();
         if (row != ROWS - 1) {
            System.out.println("-----------"); // print horizontal line
         }
      }
      System.out.println();
   }
 
   /** Print a cell with the specified "value" */
   public static void printCell(int value) {
      switch (value) {
         case EMPTY:  {
        	 	System.out.print("   "); break;
         }
         case CIRCLE: {
        	 	System.out.print(" O "); break;
         }
         case X: {
        	 	System.out.print(" X "); break;
         }
      }
   }
}