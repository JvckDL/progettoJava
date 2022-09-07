package connectFour;

import java.util.Scanner;

public class ConnectLogic {
	public Board board;
	public String player1;
	public String player2;
	public String color1 = "R";
	public String color2 = "Y";
	
	private boolean player1Turn = true;
	
	public ConnectLogic(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		
	}
	
	
	public void startGame() {
		boolean running = true;
		
		while(running) {
			board.printBoard();
			String color;
			if(player1Turn) {
				color = color1;
				System.out.println(player1 + "turn");
			}else {
				color = color2;
				System.out.println(player2 + "turn");
			}
			
			System.out.println("Please select a column between 1 and 6:");
			
			Scanner in = new Scanner(System.in);
			int column = in.nextInt();
			
			boolean success = board.addPiece(column - 1, color);
			
			if(success) {
				player1Turn = !player1Turn;
			}
			
			
		}
	}
}
