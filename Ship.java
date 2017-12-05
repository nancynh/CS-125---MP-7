/**
 * Ship class for the BattleShip game.
 * @author nancy
 *
 */
public class Ship {
	private int left;	//leftmost space the ship occupies
	private int up; 		//upmost space the ship occupies
	private int length;	//length of the ship
	private int width;	//width of the ship
	private int hits;	//number of hits the ship has taken
	
	/**
	 * @param lft - left
	 * @param len - length
	 * @param w - width
	 * @param u - up
	 */
	public Ship(int lft, int len, int w, int u) {
		hits = 0;
		left = lft;
		length = len;
		width = w;
		up = u;
	}
	
	/**Checks if the ship has sunk yet or not*/
	public boolean isSunk() {
		if (this.length * this.width == this.hits) {
			return true;
		} else {
			return false;
		}
	}
	
	/**Checks if where the player guesses a hit, it actually hits the ship
	 * @param x - x coordinate of the guess
	 * @param y - y coordinate of the guess
	 * @return if it hit a ship or not
	 * */
	public boolean checkForHit(int x, int y) {
		if( (x >= left - 1 && x <= (left + length - 1)) && (y >= up  - 1 && y <= (up + width - 1))) {
			hits++;
			return true;
		} else {
			return false;
		}
	}
}
