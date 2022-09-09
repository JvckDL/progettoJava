package connectFour;

public class Board {
	
	private static final int rows = 7;
	private static final int columns = 6;
	
	Piece [][]ourBoard = new Piece [rows][columns];
	
	public static int getColumns() {
		return columns;
	}
	
	
	public static int getRows() {
		return rows;
	}
	
	
	public boolean checkForWinner(int col, String winningColor) {
		boolean someoneWon = false;
		
		for(int row = 0; row < rows; row++) {
			if(ourBoard[row][col] != null) {
				int winningStreak = 3;
				
				//downwards
				for(int winRow = row + 1; winRow < rows; winRow++) {
					if(ourBoard[winRow][col].getColor().equals(winningColor)) {
						winningStreak--;
						if(winningStreak == 0) {
							someoneWon = true;
						}
					}else {
						winningStreak = 3;
					}
				}
				
				winningStreak = 4;
				
				
				//horizontal
				for(int winCol = col - 3; winCol < col + 3; winCol++) {
					if(winCol < 0) continue;
					if(winCol >= columns) break;
				
					if(ourBoard[row][winCol] != null && ourBoard[row][winCol].getColor().equals(winningColor)){
						winningStreak--;
						if(winningStreak == 0) {
							someoneWon = true;
						}
					}else {
						winningStreak = 4;
					}
				}
				
				winningStreak = 4;
				
				//left diagonal
				for(int winRow = row - 3, winCol = col - 3; winRow <= row + 3 && winCol <= col + 3; winRow++, winCol ++) {
					if(winRow < 0 || winCol < 0)continue;
					if(winRow >= rows || winCol >= columns) break;
						
					if(ourBoard[winRow][winCol] != null && ourBoard[winRow][winCol].getColor().equals(winningColor)){
						winningStreak--;
						if(winningStreak == 0) {
							someoneWon = true;
							}
						}else {
							winningStreak = 4;
						}			
					}
				
				winningStreak = 4;
				
				//right diagonal
				for(int winRow = row - 3, winCol = col + 3; winRow <= row + 3 && winCol >= col - 3; winRow++, winCol --) {
					if(winRow < 0 || winCol >= columns)continue;
					if(winRow >= rows || winCol < 0) break;
						
					if(ourBoard[winRow][winCol] != null && ourBoard[winRow][winCol].getColor().equals(winningColor)){
						winningStreak--;
						if(winningStreak == 0) {
							someoneWon = true;
							}
						}else {
							winningStreak = 4;
						}			
					}
					break;
			}
			
		}
		return someoneWon;
	}
	
	public int addPiece (int colToAdd, String color) {
		//within normal range
		if(colToAdd >=0 && colToAdd < columns) {
			//we can add
			if(ourBoard[0][colToAdd] == null) {
				
				int addedRow = -1;
				for ( int row = rows -1 ; row >= 0; row--) {
					if(ourBoard[row][colToAdd] == null) {
						ourBoard[row][colToAdd] = new Piece();
						ourBoard[row][colToAdd].setColor(color);
						addedRow = row;
						break;
					}
				}
				return addedRow;
			}else {
				//that row is full
				System.err.println("This column is full, please choose another.");
				return -1;
			}
		} else {
			//outside normal range
			System.err.println ("You are trying to add somewhere that is not supported");
			return -1;
		}
	}
	/*
	public void printBoard() {
		for (int col = 0; col < columns + 2; col++) System.out.print("-"); 
			System.out.println();
			for (int row = 0; row < rows; row++) {
				System.out.print("|");
				for (int col = 0; col < columns; col++) {
					if (ourBoard[row][col] == null) {
						System.out.print("_");
					} else {
						System.out.print(ourBoard[row][col].getColor());
					}
					System.out.print("|");
				}
				System.out.println();					
		}
			for(int col = 0; col < columns + 2; col ++) System.out.print("-");
			System.out.println();
	}
	*/
	public Board() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				ourBoard[row][col] = null;
			}
		}
	}

}
