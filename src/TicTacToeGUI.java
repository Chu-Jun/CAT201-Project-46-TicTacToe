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
        game = new Tictactoe(rows);

        // Set current player
        currentPlayer = "X";

        // Set up the GUI
        setTitle("Tic Tac Toe");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        // Split the frame into two section horizontally
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        // Create a panel for the game board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(rows,cols));

        // Create game board buttons
        board = new JButton[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new JButton();
                board[i][j].setFont(new Font("Ink Free", Font.BOLD, 120));
                board[i][j].addActionListener(new ButtonListener());
                boardPanel.add(board[i][j]);
            }
        }
       
        // Create a panel for the scoreboard
        JPanel scorJPanel = new JPanel();
        scorJPanel.setBackground(new Color(71,76,79));
        // scorJPanel.setLayout(new GridLayout());
        scorJPanel.setLayout(new BoxLayout(scorJPanel, BoxLayout.Y_AXIS));

        JLabel playerLabel1 = new JLabel("X: " + player1);
        playerLabel1.setForeground(Color.WHITE);
        playerLabel1.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

        JLabel playerLabel2 = new JLabel("O: " + player2);
        playerLabel2.setForeground(Color.WHITE);
        playerLabel2.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

        JLabel scoreLabel1 = new JLabel("X: " + game.returnScore1());
        scoreLabel1.setForeground(Color.WHITE);
        scoreLabel1.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

        JLabel scoreLabel2 = new JLabel("O: " + game.returnScore2());
        scoreLabel2.setForeground(Color.WHITE);
        scoreLabel2.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        
        scorJPanel.add(playerLabel1);
        scorJPanel.add(playerLabel2);
        scorJPanel.add(scoreLabel1);  
        scorJPanel.add(scoreLabel2);  

        // Create a panel for the status label
        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("Player " + currentPlayer + "'s turn");
        statusPanel.add(statusLabel);
        
        splitPane.setLeftComponent(boardPanel);
        splitPane.setRightComponent(scorJPanel);

        // Fix the right section
        splitPane.setResizeWeight(1);
    
        // Set divider location to 400 pixel value
        splitPane.setDividerLocation(400);

        // Lock divider location
        splitPane.setEnabled(false);
        
        add(splitPane, BorderLayout.CENTER);

        // Add the status panels to the frame
        add(statusPanel, BorderLayout.SOUTH);

        // Display the GUI
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setForeground(new Color(255, 0, 0));
            // Find the button's coordinates on the game board
            int x = -1, y = -1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == button) {
                        x = i;
                        y = j;
                    }
                }
            }
            if(currentPlayer.equals("X")){
                button.setText("X");
                currentPlayer = "O";
                game.setPlay(x,  y, "X");
            }else{
                button.setText("O");
                currentPlayer = "X";
                game.setPlay(x,  y, "O");
            }
            if(game.isGameOverRow()) {
                if(currentPlayer.equals("X")){
                    game.calculateScore("X");
                }else{
                    game.calculateScore("O");
                }
            }
            if(game.isGameOverColumn()) {
                if(currentPlayer.equals("X")){
                    game.calculateScore("X");
                }else{
                    game.calculateScore("O");
                }
            }
            // if(game.isGameOverDiagonal()) {
            // 	if(currentPlayer.equals("X")){
            //     game.calculateScore("X");
            // }else{
            //     game.calculateScore("O");
            // }
            // }
        }
    }

}
 



