package connectFour;

import java.util.Scanner;

public class ConnectLogic {
	private Board board;
	private String player1;
	private String player2;
	private String color1 = "RED";
	private String color2 = "YELLOW";
	
	private boolean player1Turn = true;
	
	public ConnectLogic(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		
	}
	
	
	public void startGame() {
		boolean running = true;
		
		while(running) {
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
			
			boolean success = board.addPiece(column, color);
			
			if(success) {
				player1Turn = !player1Turn;
			}
			
			
			player1Turn = !player1Turn;
		}
	}
}
