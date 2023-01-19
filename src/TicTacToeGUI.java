import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame {

    // Game board buttons
    private JButton[][] board;

    // Game status label
    private JLabel statusLabel;

    // Game logic object
    private Tictactoe game;

    // Current player
    private String currentPlayer;

    private int rows;
    private int cols;

    public TicTacToeGUI(String player1, String player2, int rows, int cols) {
        // Initialize game logic object
        game = new Tictactoe();

        // Set current player
        currentPlayer = "X";

        // Set up the GUI
        setTitle("Tic Tac Toe");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel for the game board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(rows,cols));

        // Create game board buttons
        board = new JButton[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new JButton();
                board[i][j].addActionListener(new ButtonListener());
                boardPanel.add(board[i][j]);
            }
        }

        // Create a panel for the status label
        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("Player " + currentPlayer + "'s turn");
        statusPanel.add(statusLabel);

        // Add the board and status panels to the frame
        add(boardPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        // Display the GUI
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            // Find the button's coordinates on the game board
            int x = -1, y = -1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == button) {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
        }


            //THIS JUST A REFERENCE TO CONNECT BACKEND CODE, HAVENT FOUND OUT HOW TO DO FOR ChuJun CODE
            // Make a move if the button is empty and the game is not over

            // if (button.getText().equals("") && !game.isGameOver()) {
            //     button.setText(currentPlayer);
            //     game.makeMove(x, y, currentPlayer);
            //     // Check for a win or a tie
            //     if (game.checkForWin()) {
            //         statusLabel.setText("Player " + currentPlayer + " wins!");
            //     } else if (game.checkForTie()) {
            //         statusLabel.setText("Tie game!");
            //     } else {
            //         // Switch to the other player
            //         currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            //         statusLabel.setText("Player " + currentPlayer + " 's turn");
            //     }
            //     }
            //     }
            //     }
        

// public static void main(String[] args) {
//                 new TicTacToeGUI();

//             }


        }

}

