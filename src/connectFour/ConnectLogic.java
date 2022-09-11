package connectFour;


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
	
	public void reset() {
		this.board = new Board();
	}
	
	
	public boolean getPlayer1Turn(){
		return player1Turn;
	}
	
	public int round(int col) {
		int row = -1;	//funziona anche con = 0
		
		String color;
		
		if(player1Turn) {
			color = color1;
		} else {
			color = color2;
		}
		
		row = board.addPiece(col, color);
		
		if(row != -1) {
			player1Turn = !player1Turn;
		}
		return row;
	}
	/*
	public boolean checkWinner(int column) {
		String winningColor;
		if(player1Turn) {
			winningColor = color1;
		}else {
			winningColor = color2;
		}
		return board.checkForWinner(column, winningColor);
	}
	*/
	
	
	public boolean checkWinnerGUI(int column) {
		String winningColor;
		
		if(!player1Turn) {
			winningColor = color1;
		}else {
			winningColor = color2;
		}
		return board.checkForWinner(column, winningColor);
	} 
}
