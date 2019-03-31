/********************************************************************************
 *Author: Ryan Forsyth 26315674
 *Date: 2018 September 21
 *Purpose: This class is used to represent the various boards displayed throughout
 *the game. Each board contains the information for the positions of board and the 
 *amount of ships (points) left on the board. 
*********************************************************************************/

public class Board {
	protected final int NUM_ROW = 8, NUM_COL = 8;
	
	protected int points;
	protected Position[][] positions;
	
	//Constructor
	public Board() {
		this.positions = new Position[NUM_COL][NUM_ROW];
		for(int x = 0; x < NUM_ROW; x++) {	//When initializing an ARRAY OF OBJECTS you must initialize each of them separately!!!
			for (int y = 0; y < NUM_COL; y++) {
				positions[x][y] = new Position();
			}
		}
		this.points = 6;
	}
}
