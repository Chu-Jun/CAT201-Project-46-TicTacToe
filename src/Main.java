import java.util.Scanner;

// import javax.swing.JScrollPane;
// import javax.swing.JTable;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 

		System.out.print("Please enter the name for Player 1: ");
		String player1 = input.next();

		System.out.print("Please enter the name for Player 2: ");
		String player2 = input.next();

		System.out.print("How many rows and columns do you prefer: ");
		int numOfRows = input.nextInt();

		System.out.print("How many round would you like to play: ");
		int numOfPlay = input.nextInt();

		int score1 = 0;
		int score2 = 0;
		
		String player = player1;

		for(int p = 0; p < numOfPlay; p++){
			Tictactoe game = new Tictactoe(numOfRows);
			
			do {
				System.out.println("\n*************************************");
				System.out.println("Round " + (p+1));
				System.out.println("*************************************");

				System.out.println(game.printBoard());
				System.out.println("Enter row for " + player + " or -1 to exit: ");
				int row = input.nextInt();
				if(row == -1) 
					break;
				System.out.println("Enter column for " + player + ": ");
				int column = input.nextInt();
				row = row - 1;
				column = column - 1;
				if(player.equals(player1)){
					game.setPlay(row,  column, "X");
				}else{
					game.setPlay(row,  column, "O");
				}
				if(game.isGameOverRow()) {
					System.out.println(game.printBoard() + "\n" + player +" wins!");
					if(player.equals(player1)){
						score1++;
					}else{
						score2++;
					}
					// String[] columnNames = {"Player Name", "Score"};
					// Object[][] data = {
    				// 					{player1, score1},
    				// 					{player2, score2},
					// };
					// JTable table = new JTable(data, columnNames);
					// JScrollPane scrollPane = new JScrollPane(table);
					// System.out.println(scrollPane);
					System.out.println("Player Name\t\t" + "Score");
					System.out.println("------------------------------");
					System.out.println(player1 + "\t" + score1);
					System.out.println(player2 + "\t" + score2);
					System.out.println("\n");
					break;
				}
				if(game.isGameOverColumn()) {
					System.out.println(game.printBoard() + "\n" + player +" wins!");
					if(player.equals(player1)){
						score1++;
					}else{
						score2++;
					}
					System.out.println("Player Name\t\t" + "Score");
					System.out.println("------------------------------");
					System.out.println(player1 + "\t" + score1);
					System.out.println(player2 + "\t" + score2);
					System.out.println("\n");
					break;
				}
				// if(game.isGameOverDiagonal()) {
				// 	System.out.println(game.printBoard() + "\n" + player +" wins!");
				// 	if(player.equals(player1)){
				// 		score1++;
				// 	}else{
				// 		score2++;
				// 	}
				// 	break;
				// }
				if(player.equals(player1)) {
					player = player2;				
				}
				else {
					player = player1;
				}
			}while(true);
		}

		if(score1 > score2){
			System.out.println(player1 + " is the winner!");
			System.out.println("The score is " + score1);
		}
		else{
			System.out.println(player2 + " is the winner!");
			System.out.println("The score is " + score2);
		}
	}
}
