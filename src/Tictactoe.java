/**
 * Tictactoe game
 * @author Swda
 *
 */
public class Tictactoe {
	private String[][] board;
	private static int rows = 3;
	private static int columns = 3;
	private String regex = "\\s{3}";
	
	/**
	 * Tictactoe constructor
	 */
	public Tictactoe() {
		board = new String[rows][columns];
		this.initializeBoard();
//		this.winXtest();
	}

	public Tictactoe(int rowColumn) {
		rows = columns = rowColumn;
		board = new String[rows][columns];
		this.initializeBoard();
//		this.winXtest();
	}
	
	/**
	 * initializing board and fill with empty spaces
	 */	
	public void initializeBoard() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				board[i][j] = "   ";
			}
		}
	}
	
	/**
	 * setPlay method will set player's move
	 * @param i
	 * @param j
	 * @param player
	 */	
	public void setPlay(int i, int j, String player) {
		if(board[i][j].matches(regex))
			board[i][j] = " "+player+" ";
	}
	
	/**
	 * finding winners
	 */
	public boolean isGameOver() {
		//checking rows
    	for(int i = 0; i < rows; i++) {
    		if(!board[i][0].matches(regex)){ 
				for(int k = 1; k < rows; k++){
					if(!board[i][k-1].equals(board[i][k])){
						return false;
					}
				}
    			return true; 
    		}   			 			
    	}

    	//checking columns
    	for(int j = 0; j < columns; j++) {    		
    		if(!board[0][j].matches(regex)){
				for(int m = 1; m < rows; m++){
					if(!board[m-1][j].equals(board[m][j])){
						return false;
					}
			}
    		return true;  	
			}		
    	}

    	//checking diagonals
    	if(!board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
    		return true;
    	if(!board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
    		return true;

    	//no body's won
    	return false;
		
	}
	
	/**
	 * Print board to screen
	 * @return strBoard
	 */
	public String printBoard() {
		String strBoard = "";
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(j == columns-1)
					strBoard += board[i][j];
				else
					strBoard += board[i][j] + "|";
			}
			if(i != rows-1)
			for(int k = 0; k < columns; k++){
				if(k==0){
					strBoard += "\n";
					continue;
				}
				if(k == columns-1){
					strBoard += "---+---\n";
					continue;
				}
				strBoard += "---+";
				
			}		
		}
		return strBoard;
	}
	
	/**
	 * test unit 1st column X
	 */
	public void winXtest() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(j == 0)
					board[i][j] = " X ";
				else
					board[i][j] = "   ";
			}
		}
	}
}
























