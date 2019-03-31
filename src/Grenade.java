/********************************************************************************
 *Author: Ryan Forsyth 26315674
 *Date: 2018 September 21
 *Purpose: This class is used to represent the grenades of the game. It contains
 *the coordinates of the ship in question.
*********************************************************************************/

public class Grenade {
	
	protected int row, col;
	protected boolean ownership;
	
	//Constructor
	public Grenade() {
		this.row = 0;
		this.col = 0;
		this.ownership = true;	
	}
	
	public void setPosition(int row, int col ) {
		this.row = row;
		this.col = col;
	}
	
	public void setOwnership (boolean ownership) {
		this.ownership = ownership;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public boolean getOwnership() {
		return ownership;
	}
	
	public void displayPosition() {
		System.out.println((this.row +1) + " , " + (this.col +1));
	}
}