package connectFour;

import java.util.Scanner;

public class Main {
	
	public static String player1;
	public static String player2;

	public static void main(String[] args) {
		
		System.out.println("Enter the name of the first player:");
		Scanner in = new Scanner(System.in);
		player1 = in.next();
		
		//System.out.println(player1.getClass().getSimpleName());
		
		System.out.println("Enter the name of the second player: ");
		Scanner in2 = new Scanner(System.in);
		player2 = in2.next();
		
		ConnectLogic game = new ConnectLogic(player1, player2);
		game.startGame();
	}

}
