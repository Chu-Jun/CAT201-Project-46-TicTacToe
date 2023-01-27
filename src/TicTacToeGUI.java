import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame {

    // Game board buttons
    private JButton[][] board;

    // Game logic object
    private Tictactoe game;

    // Current player
    private String currentPlayer;

    private int row;
    private int column;
    public String playerName1, playerName2;
    JLabel scoreForX, scoreForO, statusLabel2;

    public TicTacToeGUI(String player1, String player2, int rows, int cols){

        row = rows;
        column = cols;
        playerName1 = player1;
        playerName2 = player2;

        // Initialize game logic object
        game = new Tictactoe(rows);

        // Set current player
        currentPlayer = "X";

        // Set up the GUI
        setTitle("Tic Tac Toe");
        setSize(1600, 820);
        ImageIcon companyLogo = new ImageIcon("src/TicTacToe.png");
        setIconImage(companyLogo.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
       
        // Split the frame into two section horizontally
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        // Create a panel for the game board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(rows,cols));
        boardPanel.setBackground(new Color(128, 189, 171));

        // Create game board buttons
        board = new JButton[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new JButton();
                board[i][j].setBorder(BorderFactory.createLineBorder(new Color(71,76,79), 1));
                board[i][j].setFont(new Font("Ink Free", Font.BOLD, 120));
                board[i][j].setBackground(new Color(128, 189, 171));
                board[i][j].addActionListener(new ButtonListener());
                boardPanel.add(board[i][j]);
            }
        }
       
        // Create a panel for the scoreboard
        JPanel scorJPanel = new JPanel();
        scorJPanel.setBackground(new Color(71,76,79));
        scorJPanel.setLayout(null);
        
        // Add image for X
        JLabel X_icon = new JLabel();
        ImageIcon x_icon = new ImageIcon(new ImageIcon("src/X image.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        X_icon.setIcon(x_icon);
        X_icon.setBounds(14, 14, 50, 50);
        scorJPanel.add(X_icon);

        // Display player 1's name
        JLabel playerLabel1 = new JLabel(":  " + player1);
        playerLabel1.setForeground(Color.WHITE);
        playerLabel1.setFont(new Font("Roboto Mono", Font.BOLD, 30));
        playerLabel1.setBounds(80, 14, 1000, 50);
        scorJPanel.add(playerLabel1);

        // Add image for O
        JLabel O_icon = new JLabel();
        ImageIcon o_icon = new ImageIcon(new ImageIcon("src/O image.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        O_icon.setIcon(o_icon);
        O_icon.setBounds(14, 84, 50, 50);
        scorJPanel.add(O_icon);

        // Display player 2's name
        JLabel playerLabel2 = new JLabel(":  " + player2);
        playerLabel2.setForeground(Color.WHITE);
        playerLabel2.setFont(new Font("Roboto Mono", Font.BOLD, 30));
        playerLabel2.setBounds(80, 84, 1000, 50);
        scorJPanel.add(playerLabel2);

        // Show player's turn
        JLabel statusLabel1 = new JLabel("It's");
        statusLabel1.setForeground(new Color(128, 189, 171));
        statusLabel1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 50));
        statusLabel1.setBounds(180, 210, 1000, 50);
        scorJPanel.add(statusLabel1);

        // Show player's turn
        statusLabel2 = new JLabel(currentPlayer + "'s turn!");
        statusLabel2.setForeground(new Color(128, 189, 171));
        statusLabel2.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 50));
        statusLabel2.setBounds(120, 260, 1000, 50);
        scorJPanel.add(statusLabel2);
        
        // Create a panel for score
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(200, 219, 216));
        textPanel.setBounds(14, 400, 390, 170);
        textPanel.setLayout(null);
        scorJPanel.add(textPanel);
        
        // Display score
        JLabel scoreLabel = new JLabel("Score");
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(new Font("Roboto Mono", Font.BOLD, 35));
        scoreLabel.setBounds(14, 8, 1000, 50);
        textPanel.add(scoreLabel);  
        
        // Display X's score
        scoreForX = new JLabel("Player 1 : " + game.returnScore1());
        scoreForX.setForeground(Color.BLACK);
        scoreForX.setFont(new Font("Roboto Mono", Font.PLAIN + Font.BOLD, 25));
        scoreForX.setBounds(14, 60, 1000, 50);
        textPanel.add(scoreForX);  
        
        // Display O's score
        scoreForO = new JLabel("Player 2 : " + game.returnScore2());
        scoreForO.setForeground(Color.BLACK);
        scoreForO.setFont(new Font("Roboto Mono", Font.PLAIN + Font.BOLD, 25));
        scoreForO.setBounds(14, 110, 1000, 50);
        textPanel.add(scoreForO);

        // Create a reset button for user to reset the game
        JButton resetButton = new JButton();
        resetButton.setText("RESET");
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        resetButton.setBounds(105, 640, 200, 50);
        resetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                statusLabel2.setText("X's turn!");
                cleanBoard();
            }
        });
        scorJPanel.add(resetButton);
        
        // Create an exit button for user to exit the game
        JButton exitButton = new JButton();
        exitButton.setText("EXIT");
        exitButton.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        exitButton.setBounds(105, 710, 200, 50);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        scorJPanel.add(exitButton);
        
        // Split the frame to left is the game board and right is the score board
        splitPane.setLeftComponent(boardPanel);
        splitPane.setRightComponent(scorJPanel);

        // Fix the right section
        splitPane.setResizeWeight(1);
    
        // Set divider location to 400 pixel value
        splitPane.setDividerLocation(1100);

        // Lock divider location
        splitPane.setEnabled(false);
        
        add(splitPane, BorderLayout.CENTER);

        // Display the GUI
        setVisible(true);
    }

    public void cleanBoard(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j].setText("");
                currentPlayer = "X";
                game.initializeBoard();;
            }
        }
    }

    public boolean checkTie(){
        boolean full=true;
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(board[i][j].getText()==""){
                    full = false;
                }
            }
        }
        return full;
    }


    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            JButton button = (JButton) e.getSource();
            button.setForeground(new Color(255, 0, 0));
            String message;

            // Find the button's coordinates on the game board
            int x = -1, y = -1;
            int score;
            String scoreInText;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (e.getSource() == board[i][j]) {
                        x = i;
                        y = j;
                    }
                }
            }
            if(currentPlayer.equals("X") && button.getText().equals("")){
                button.setText("X");
                currentPlayer = "O";
                statusLabel2.setText(currentPlayer + "'s turn!");
                game.setPlay(x,  y, "X");
            }
            else if(currentPlayer.equals("O") && button.getText().equals("")){
                button.setText("O");
                currentPlayer = "X";
                statusLabel2.setText(currentPlayer + "'s turn!");
                game.setPlay(x,  y, "O");
            }
            if(game.isGameOverRow() || game.isGameOverColumn() || game.isGameOverDiagonal()) {

                if (currentPlayer.equals("X")) {
                    message = playerName2 + " has won this round!";
                    JOptionPane.showMessageDialog(null, message, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    game.calculateScore("O");
                    cleanBoard();
                }
                else{
                    message = playerName1 + " has won this round!";
                    JOptionPane.showMessageDialog(null, message, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    game.calculateScore("X");
                    cleanBoard();
                }
                statusLabel2.setText(currentPlayer + "'s turn!");
                score = game.returnScore1();
                scoreInText = score + "";
                scoreForX.setText("Player 1 : " + scoreInText);
                score = game.returnScore2();
                scoreInText = score + "";
                scoreForO.setText("Player 2 : " + scoreInText);
            }else{
                boolean tie = checkTie();
                if(tie == true){
                    message = "There is no winner as it is a tie.";
                    JOptionPane.showMessageDialog(null, message, "Tie", JOptionPane.INFORMATION_MESSAGE);
                    cleanBoard();
                    statusLabel2.setText(currentPlayer + "'s turn!");
                }
            }
        }
    }    
}
