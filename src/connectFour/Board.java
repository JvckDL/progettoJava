package connectFour;

public class Board {
	
	private static final int ROWS = 7;
	private static final int COLUMNS = 6;
	
	Piece [][]ourBoard = new Piece [ROWS][COLUMNS];
	
	
	public Board() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				ourBoard[row][col] = null;
			}
		}
	}
	
	public static int getColumns() {
		return COLUMNS;
	}
	
	
	public static int getRows() {
		return ROWS;
	}
	
	
	
	public boolean checkForWinner(int col, String winningColor) {
		boolean someoneWon = false;
		
		for(int row = 0; row < ROWS; row++) {
			if(ourBoard[row][col] != null) {
				int winningStreak = 3;
				
				//downwards
				for(int winRow = row + 1; winRow < ROWS; winRow++) {
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
				
				
				//horizontal right
				for(int winCol = col - 3; winCol < col + 3; winCol++) {
					if(winCol < 0) continue;
					if(winCol >= COLUMNS) break;
				
					if(ourBoard[row][winCol] != null && ourBoard[row][winCol].getColor().equals(winningColor)){
						winningStreak--;
						if(winningStreak == 0) {
							someoneWon = true;
						}
					}else {
						winningStreak = 4;
					}
				}
				
				//horizontal left
				for(int winCol = col + 3; winCol > col - 3; winCol++) {
					if(winCol < 0) continue;
					if(winCol >= COLUMNS) break;
				
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
					if(winRow >= ROWS || winCol >= COLUMNS) break;
						
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
					if(winRow < 0 || winCol >= COLUMNS)continue;
					if(winRow >= ROWS || winCol < 0) break;
						
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
		if(colToAdd >=0 && colToAdd < COLUMNS) {
			//we can add
			if(ourBoard[0][colToAdd] == null) {
				
				int addedRow = -1;
				for ( int row = ROWS -1 ; row >= 0; row--) {
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
	
	

}
