/**
 * Player class for the BattleShip game.
 * @author nancy
 *
 */
public class PlayerBS {
	private int numGuess; //number of guesses the player made
	private Ship s1;		//The sole ship the player will try to find and hit lol
	public String[][] gameBoard = new String[15][15]; //The gameboard where the ship will be
	
	public PlayerBS(Ship s2) {
		s1 = s2;
		numGuess = 0;
		
		//Making the gameBoard be empty
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				gameBoard[i][j] = "";
			}
		}
	}
	
	/**
	 * Take a shot
	 * @param x - x coordinate of the gameBoard 
	 * @param y - y coordinate of the gameBoard
	 */
	public void takeShot(int x, int y) {
		//If it's outside of the rang of the screen then DO NOT inc num of guesses, print out that guess it out of range
		if (x >= 15 || x < 0 || y >= 15 || y < 0) {
			System.out.print("Your guess is outside of the game board.");
		//if the game board if empty, num of guesses goes up by one
		} else if (gameBoard[y][x] == "") {
			numGuess++;
			//if the shot does hit the ship then at the spot it should be marked with an "H"
			if (s1.checkForHit(x, y)) {
				gameBoard[y][x] = "H";
				System.out.print("You hit a spot!");
			//if the shot misses the spot should be marked with an "M" 
			} else {
				gameBoard[y][x] = "M";
				System.out.print("You missed!");
			}
		//else if not empty DO NOT inc the num of guesses and print out that you already guessed at that spot
		} else if (gameBoard[y][x] == "H" || gameBoard[x][y] == "M"){
			System.out.print("You already guessed at that location.");
		}
	}
	
	/**
	 * Draws the game board.
	 */
	public void drawBoard() {
		//Drawing the very top part of the board
		System.out.print("    ");
		for (int i = 0; i < 15; i++) {
			if (i < 9) {
				System.out.print(" " + i + "  ");
			} else {
				System.out.print(" " + i + " ");
			}
		}
		System.out.print("\n   .");
		for (int i = 0; i < 15; i++) {
			System.out.print("---.");
		}
		//System.out.print("\n");
		//Drawing the board with the hits, misses, and blanks
		for (int i = 0; i < 15; i++) {
			if (i < 10) {
				System.out.print("\n" + i + "  |");
			} else {
				System.out.print("\n" + i + " |");
			}
			for (int j = 0; j < 15; j++) {
				if (gameBoard[i][j] == "") {
					System.out.print("   |");
				} else if (gameBoard[i][j] == "M") {
					System.out.print(" M |");
				} else if (gameBoard[i][j] == "H") {
					System.out.print(" H |");
				}
			}

			System.out.print("\n   \'");
			for (int k = 0; k < 15; k++) {
				System.out.print("---\'");
			}
			
		}
	}
	
	public int getGuesses() {return numGuess;}
}
