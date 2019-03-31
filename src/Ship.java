/********************************************************************************
 *Author: Ryan Forsyth 26315674
 *Date: 2018 September 21
 *Purpose: This class is used to represent the ships of the game. It contains
 *the coordinates of the ship in question.
*********************************************************************************/

public class Ship {
	
	protected int row, col;
	
	//Constructor
	public Ship() {
		this.row = 0;
		this.col = 0;	
	}
	
	public void setPosition(int row, int col ) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void displayPosition() {
		System.out.println((this.row +1) + " , " + (this.col +1));
	}
}
