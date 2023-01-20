/**
 * Tictactoe game
 * @author Swda
 *
 */
public class Tictactoe {
	private String[][] board;
	private static int rows = 3;
	private static int columns = 3;
	private static int score1 = 0;
	private static int score2 = 0;
	private String regex = "\\s{3}";
	
	/**
	 * Tictactoe constructor
	 */
	public Tictactoe() {
		board = new String[rows][columns];
		this.initializeBoard();
	}

	public Tictactoe(int rowColumn) {
		rows = columns = rowColumn;
		board = new String[rows][columns];
		this.initializeBoard();
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
	public boolean isGameOverRow() {
		boolean condition=false;
		//checking rows
    	for(int i = 0; i < rows; i++) {
			System.out.println("CHECKING ROW "+ i);
    		if(!board[i][0].matches(regex)){ 
				for(int k = 1; k < rows; k++){
					System.out.println("CHECKING COLUMN"+ k);
					if(!board[i][k-1].equals(board[i][k])){
						condition = false;
						break;
					}else{
						condition = true;
					}
				}
    		}
			if(condition!=false){
				return true;
			}    	
			continue;	
    	}
		if(condition == true){
			return condition;
		}else{
			return false;
		}
	}

	public boolean isGameOverColumn() {
    	//checking columns
		boolean condition = false;
    	for(int j = 0; j < columns; j++) {    		
    		if(!board[0][j].matches(regex)){
				for(int m = 1; m < columns; m++){
					if(!board[m-1][j].equals(board[m][j])){
						condition = false;
						break;
					}else{
						condition = true;
					}
				}
			}
    		if(condition!=false){
				return true;
			}    	
			continue;	
    	}
		if(condition == true){
			return condition;
		}else{
			return false;
		}
	}

	public boolean isGameOverDiagonal() {
		//checking diagonals
		if(!board[0][0].matches(regex)){
			for(int i=0; i<(rows-1); i++){
				if(!board[i][i].equals(board[i+1][i+1])){
					return false;
				}
			}
			return true;
		}

		if(!board[0][rows-1].matches(regex)){
			int j=0;
			for(int i=(rows-1); i>0; ){
				if(!board[j][i].equals(board[++j][--i])){
					return false;
				}
			}
			return true;
		}

    	//no body's won
    	return false;
	}

	public void calculateScore(String player){
		if(player.equals("X")){
			score1++;
		}else{
			score2++;
		}
	}

	public int returnScore1(){
		return score1;
	}

	public int returnScore2(){
		return score2;
	}
	

	/**
	 * Print board to screen FOR TESTING PURPOSE IN TERMINAL
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
}
























