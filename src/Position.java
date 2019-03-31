/********************************************************************************
 *Author: Ryan Forsyth 26315674
 *Date: 2018 September 21
 *Purpose: This class is used to represent the individual positions of the game's
 *board. It contains information specific to each position, such as whether it
 *contains a human or computer ship or rocket, and whether the position has been
 *hit by a rocket (called) or not. 
*********************************************************************************/

public class Position {

	private boolean hasHShip, hasHGrenade;		//If marked by the player
	private boolean hasCShip, hasCGrenade;		//if marked by the computer
	private boolean called;
	
	//Constructor
	public Position() {
		this.hasHShip = false;
		this.hasHGrenade = false;
		this.hasCShip = false;
		this.hasCGrenade = false;
		this.called = false;
	}
	
	//Getters
	public boolean hasHShip() {
		return this.hasHShip;
	}
	
	public boolean hasHGrenade() {
		return this.hasHGrenade;
	}
	
	public boolean hasCShip() {
		return this.hasCShip;
	}
	
	public boolean hasCGrenade() {
		return this.hasCGrenade;
	}
	
	//Setters
	public void markHShip() {
		this.hasHShip = true;
	}
	
	public void markHGrenade() {
		this.hasHGrenade = true;
	}
	
	public void markCShip() {
		this.hasCShip = true;
	}
	
	public void markCGrenade() {
		this.hasCGrenade = true;
	}
	
	public void markCall() {
		this.called = true;
	}
	
	//To string to print appropriate label for Position x
	public String toString() {
		
		String indicator = " ";
		
		if (called) {
			indicator = "x";
		}
		else if (hasHShip) {
			indicator = "s";
		}
		else if (hasCShip) {
			indicator = "S";
		}
		else if (hasHGrenade) {
			indicator = "g";
		}
		else if (hasCGrenade) {
			indicator = "G";
		}
		else if (!called) {
			indicator = "_";
		}
		return indicator;
	}
}
