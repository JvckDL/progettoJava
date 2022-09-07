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
		this.board = new Board();
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
				System.out.println(player1 + "'s turn.");
			}else {
				color = color2;
				System.out.println(player2 + "'s turn.");
			}
			
			System.out.println("Please select a column between 1 and 6:");
			
			Scanner in = new Scanner(System.in);
			int column = in.nextInt() - 1;
			
			boolean success = board.addPiece(column, color);
			
			if(success) {
				if(checkWinner(column)) {
					board.printBoard();
					running = false;
					if(player1Turn) {
						System.out.println(player1 + " has won");
					} else {
						System.out.println(player2 + " has won");
					}
				}
				
				player1Turn = !player1Turn;
			}
			
			
		}
	}
	
	public boolean checkWinner(int column) {
		String winningColor;
		if(player1Turn) {
			winningColor = color1;
		}else {
			winningColor = color2;
		}
		
		return board.checkForWinner(column, winningColor);
	}
}
