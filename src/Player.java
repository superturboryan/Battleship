/********************************************************************************
 *Author: Ryan Forsyth 26315674
 *Date: 2018 September 21
 *Purpose: This class is used to represent the players of the game. It contains 
 *information about the player's ships and grenades.
*********************************************************************************/

public class Player {
	
	protected Ship[] ships;
	protected Grenade[] grenades;

	//Constructor
	public Player() {
		
		this.ships = new Ship[6]; 
		
		for( int x = 0; x < 6; x++ ) {		//When initializing an ARRAY OF OBJECTS you MUST initialize each of them separately!!!
			ships[x] = new Ship();
		}
		
		this.grenades = new Grenade[4]; 
		
		for( int x = 0; x < 4; x++ ) {		//When initializing an ARRAY OF OBJECTS you must initialize each of them separately!!!
			grenades[x] = new Grenade();
		}	  
	}
	
	public Ship getShip(int x) {
		
		return this.ships[x];
	}
	
	public Grenade getGrenade(int x) {
		
		return this.grenades[x];
	}
	
}
	
	



