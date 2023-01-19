import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 

		System.out.println("How many rows and columns do you prefer?");
		int numOfRows = input.nextInt();
		
		Tictactoe game = new Tictactoe(numOfRows);
		String player = "X";

		do {
			System.out.println(game.printBoard());
			System.out.println("enter row for " + player + " or -1 to exit: ");
			int row = input.nextInt();
			if(row == -1) 
				break;
			System.out.println("enter column for " + player + ": ");
			int column = input.nextInt();
			row = row - 1;
			column = column - 1;
			game.setPlay(row,  column, player);
			if(game.isGameOverRow()) {
				System.out.println(game.printBoard() + "\n" + player +" wins!");
				break;
			}
			if(game.isGameOverColumn()) {
				System.out.println(game.printBoard() + "\n" + player +" wins!");
				break;
			}
			// if(game.isGameOverDiagonal()) {
			// 	System.out.println(game.printBoard() + "\n" + player +" wins!");
			// 	break;
			// }
			if(player == "X") {
				player = "O";				
			}
			else {
				player = "X";
			}
		}while(true);
		System.out.println("Goodbye!..");

	}

}
