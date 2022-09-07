package connectFour;

import java.util.Scanner;

public class Main {
	
	protected static String player1;
	protected static String player2;

	public static void main(String[] args) {
		System.out.println("Enter the name of the first player:");
		Scanner in = new Scanner(System.in);
		player1 = in.nextLine();
		System.out.println("Enter the name of the second player: ");
		Scanner in2 = new Scanner(System.in);
		player2 = in.nextLine();
		Board boardGame = new Board();
		boardGame.printBoard();
		//boardGame.addPiece
	}

}
