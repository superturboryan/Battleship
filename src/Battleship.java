/*****************************************************************************************
 *Author: Ryan Forsyth 26315674
 *Date: 2018 September 21
 *Purpose: Simulate the game of Battleship, where the player sets up the location of his/
 *her ships and grenades and then take turns launching rockets to eliminate the computer's
 *ships. The first player to eliminate the other's ships wins. 
*****************************************************************************************/

import java.util.Scanner;
import java.util.Random;

public class Battleship {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("======================\nLet's play Battleship! \n======================\n"); 
		
		//Initialize the two players
		Player human = new Player(), computer = new Player();
		
		//Ask for coordinates of the two players' ships and grenades
		setupHuman(human);
		setupComputer(computer);
	
		//Initialize the boards
		Board humanBoard = new Board(), computerBoard = new Board(), hiddenBoard = new Board(), referenceBoard = new Board();
		
		//Mark the ships and grenades on the appropriate board
		markBoardHuman(referenceBoard, human);
		markBoardHuman(humanBoard,human);
		markBoardComputer(computerBoard, computer);

		//Display reference board for human's ships and grenades
		System.out.println("Here is your reference for this game : \n");
		showBoard(referenceBoard);
		
		//Take turns launching rockets
		for (int x = 0; x < 64; x++) {
			
			//Check if human or computer have won
			if (humanBoard.points == 0 || computerBoard.points == 0) {			
				System.out.println("GAME OVER!\n");
				markBoardAll(referenceBoard, human, computer);
				showBoard(referenceBoard);
				System.exit(0);
			}
			
		launchHumanRocket (computerBoard, hiddenBoard);
		launchComputerRocket (humanBoard, hiddenBoard);
		
		//Display board showing results of rocket launches after each turn
		showBoard(hiddenBoard);
		
		// Display the points at the end of each turn
		System.out.println("Human points: " + humanBoard.points);				
		System.out.println("Compu points: " + computerBoard.points + "\n");
		}
	}
	
	// Human's turn to launch rocket
	public static void launchHumanRocket(Board computer, Board hidden) {
		
		System.out.print("Please enter the coordinates for your rocket, column (A-H) : ");
		String rocketColAlpha = input.next();
		rocketColAlpha = rocketColAlpha.toLowerCase();
		
		int rocketColNum = 0;
		switch (rocketColAlpha) {
		case "a": rocketColNum = 0;
		break;
		case "b": rocketColNum = 1;
		break;
		case "c": rocketColNum = 2;
		break;
		case "d": rocketColNum = 3;
		break;
		case "e": rocketColNum = 4;
		break;
		case "f": rocketColNum = 5;
		break;
		case "g": rocketColNum = 6;
		break;
		case "h": rocketColNum = 7;
		break;
		}
		
		System.out.print("					 and the row (1-8) : ");
		int rocketRow = input.nextInt();
		rocketRow = rocketRow - 1;
		
		if (computer.positions[rocketRow][rocketColNum].hasCShip()) {
			computer.points--;
			hidden.positions[rocketRow][rocketColNum].markCShip();
			System.out.println("\nYou sunk the computer's battleship!");
		}
		else if (computer.positions[rocketRow][rocketColNum].hasCGrenade()) {
			hidden.positions[rocketRow][rocketColNum].markCGrenade();
			System.out.println("\nYou hit the computer's grenade!");
		}
		else {hidden.positions[rocketRow][rocketColNum].markCall(); }
		
		System.out.println(" ");
	}
	
	//Computer's turn to launch rocket
	public static void launchComputerRocket(Board human, Board hidden) {
		
		
		int rocketCol = randInt(0,7);
		int rocketRow = randInt(0,7);
		char rocketColAlpha = 'a';
		
		switch (rocketCol) {
			case 0: rocketColAlpha = 'A';
			break;
			case 1: rocketColAlpha = 'B';
			break;
			case 2: rocketColAlpha = 'C';
			break;
			case 3: rocketColAlpha = 'D';
			break;
			case 4: rocketColAlpha = 'E';
			break;
			case 5: rocketColAlpha = 'F';
			break;
			case 6: rocketColAlpha = 'G';
			break;
			case 7: rocketColAlpha = 'H';
			break; 
		}		
		
		System.out.println("Computer's rocket: (" + (rocketColAlpha) + " , " + (rocketRow+1) + ")\n");		//COMPUTER ROCKET DEBUG
		
		if (human.positions[rocketCol][rocketRow].hasHShip()) {
			human.points--;
			hidden.positions[rocketCol][rocketRow].markHShip();
			System.out.println("The computer sunk your battleship!\n");
		}
		else if (human.positions[rocketRow][rocketCol].hasHGrenade()) {
			hidden.positions[rocketRow][rocketCol].markHGrenade();
			System.out.println("The computer hit your grenade!\n");
		}
		else {hidden.positions[rocketRow][rocketCol].markCall(); }
		
	}

	//Prompt the player to choose the positions of his ships and grenades
	public static void setupHuman (Player x) {
		
		int counter = 1;
		System.out.println("Human, choose the position of your five battleships... \n");
		while (counter < 7) {
		
			for (Ship s : x.ships) {
				
				System.out.print("Please enter the column for ship #" + counter + " (A-H) : ");
				String shipColAlpha = input.next();
				shipColAlpha = shipColAlpha.toLowerCase();
				
				int shipColNum = 0;
				switch (shipColAlpha) {
					case "a": shipColNum = 0;
					break;
					case "b": shipColNum = 1;
					break;
					case "c": shipColNum = 2;
					break;
					case "d": shipColNum = 3;
					break;
					case "e": shipColNum = 4;
					break;
					case "f": shipColNum = 5;
					break;
					case "g": shipColNum = 6;
					break;
					case "h": shipColNum = 7;
					break; 
				}
				
				System.out.print("	    and the row for ship #" + counter + " (1-8) : ");
				int shipRow = input.nextInt();
				shipRow = shipRow - 1;
				
				s.setPosition(shipColNum, shipRow);	
				counter++;
			}
			
			System.out.println(" ");
		}
		
		System.out.println("Choose the location of your four grenades...\n");
		counter = 1;
		while (counter < 4) {
			
			for (Grenade g : x.grenades) {
				
				System.out.print("Please enter the column for gren #" + counter + " (A-H) : ");
				String grenadeColAlpha = input.next();
				grenadeColAlpha = grenadeColAlpha.toLowerCase();
				
				int grenadeColNum = 0;
				switch (grenadeColAlpha) {
					case "a": grenadeColNum = 0;
					break;
					case "b": grenadeColNum = 1;
					break;
					case "c": grenadeColNum = 2;
					break;
					case "d": grenadeColNum = 3;
					break;
					case "e": grenadeColNum = 4;
					break;
					case "f": grenadeColNum = 5;
					break;
					case "g": grenadeColNum = 6;
					break;
					case "h": grenadeColNum = 7;
					break; 
				}
				
				System.out.print("			and the row (1-8) : ");
				int grenadeRow = input.nextInt();
				grenadeRow = grenadeRow - 1;
				
				g.setPosition(grenadeColNum, grenadeRow);	
				counter++;
			}
		}	
		System.out.println(" ");
	}
	
	//Assign random values for the computer's ships and grenades
	public static void setupComputer (Player x) {
		for (int i = 0; i < 6; i++) {	
			x.ships[i].col = randInt(0,7);
			x.ships[i].row = randInt(0,7);
		}
		for (int i = 0; i < 4; i++) {	
			x.grenades[i].col = randInt(0,7);
			x.grenades[i].row = randInt(0,7);
			}
	}
	
	//Random int method used for computer's ship, grenade, and rocket position
	public static int randInt (int min, int max) {
		
		Random randomizer = new Random();
		int randomInt = 0;
		randomInt = randomizer.nextInt((max-min) + 1) + min;
		return randomInt;
	}
	
	//Prints the board in the console
	public static void showBoard(Board b) {
		
		System.out.println("   A  B  C  D  E  F  G  H");	
		
		
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (y==0) {
					System.out.print((x+1) + "  " +b.positions[x][y]);
				}
				else {
					System.out.print("  " + b.positions[x][y]); 
				}
			}
			System.out.println(" ");
		}
	System.out.println(" ");
	}
	
	//Marks the board with the human's ships and grenades
	public static void markBoardHuman(Board b, Player p) {
		for (int x = 0; x < 6; x++) {		//Mark the appropriate location as a human Ship 
			int row = 0, col = 0;
			row = p.ships[x].row;
			col = p.ships[x].col;
			b.positions[col][row].markHShip();
		}
		for (int x = 0; x < 4; x++) {		//Mark the appropriate location as a human Grenade  
			int row = 0, col = 0;
			row = p.grenades[x].row;
			col = p.grenades[x].col;
			b.positions[col][row].markHGrenade();
		}
	}
	
	//Marks the board with the computer's ships and grenades
	public static void markBoardComputer(Board b, Player p) {
		for (int x = 0; x < 6; x++) {		//Mark the appropriate location as a computer Grenade 
			int row = 0, col = 0;
			row = p.ships[x].row;
			col = p.ships[x].col;
			b.positions[col][row].markCShip();
		}
		for (int x = 0; x < 4; x++) {		//Mark the appropriate location as a computer Ship 
			int row = 0, col = 0;
			row = p.grenades[x].row;
			col = p.grenades[x].col;
			b.positions[col][row].markCGrenade();
		}
	}
	
	//Marks the board with both the human's and the computer's ships and grenades
	public static void markBoardAll(Board b, Player human, Player computer) {  
		markBoardHuman(b, human);
		markBoardComputer(b, computer);
	}

}


