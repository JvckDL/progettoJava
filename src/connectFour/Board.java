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
	
	public boolean addPiece (int colToAdd, String color) {
		//within normal range
		if(colToAdd >=0 && colToAdd < columns) {
			//we can add
			if(ourBoard[0][colToAdd] == null) {
				boolean addedThePiece = false;
				for ( int row = rows -1; row >= 0; row--) {
					if(ourBoard[row][colToAdd] == null) {
						ourBoard[row][colToAdd] = new Piece();
						ourBoard[row][colToAdd].setColor(color);
						addedThePiece = true;
						break;
					}
				}
				return addedThePiece;
			}else {
				//that row is full
				System.err.println("This column is full, please choose anorher.");
				return false;
			}
		} else {
			//outside normal range
			System.err.println ("You are trying to add somewhere that is not supported");
			return false;
		}
	}
	
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
	
	public Board() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				ourBoard[row][col] = null;
			}
		}
	}

}
