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

    public TicTacToeGUI(String player1, String player2, int rows, int cols) {

        row = rows;
        column = cols;

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
                board[i][j].setBackground((new Color(128, 189, 171)));
                board[i][j].addActionListener(new ButtonListener());
                boardPanel.add(board[i][j]);
            }
        }
       
        // Create a panel for the scoreboard
        JPanel scorJPanel = new JPanel();
        scorJPanel.setBackground(new Color(71,76,79));
        scorJPanel.setLayout(null);
        
        JLabel X_icon = new JLabel();
        ImageIcon x_icon = new ImageIcon(new ImageIcon("src/X_image.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        X_icon.setIcon(x_icon);
        X_icon.setBounds(10, 10, 50, 50);
        scorJPanel.add(X_icon);

        JLabel playerLabel1 = new JLabel(":  " + player1);
        playerLabel1.setForeground(Color.WHITE);
        playerLabel1.setFont(new Font("Roboto Mono", Font.PLAIN, 35));
        playerLabel1.setBounds(80, 10, 1000, 50);
        scorJPanel.add(playerLabel1);

        JLabel O_icon = new JLabel();
        ImageIcon o_icon = new ImageIcon(new ImageIcon("src/O_image.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        O_icon.setIcon(o_icon);
        O_icon.setBounds(10, 80, 50, 50);
        scorJPanel.add(O_icon);

        JLabel playerLabel2 = new JLabel(":  " + player2);
        playerLabel2.setForeground(Color.WHITE);
        playerLabel2.setFont(new Font("Roboto Mono", Font.PLAIN, 35));
        playerLabel2.setBounds(80, 80, 1000, 50);
        scorJPanel.add(playerLabel2);

        JLabel statusLabel1 = new JLabel("It's");
        statusLabel1.setForeground(Color.RED);
        statusLabel1.setFont(new Font("Serif", Font.ITALIC, 50));
        statusLabel1.setBounds(150, 220, 1000, 50);
        scorJPanel.add(statusLabel1);

        JLabel statusLabel2 = new JLabel(currentPlayer + "'s turn");
        statusLabel2.setForeground(Color.RED);
        statusLabel2.setFont(new Font("Serif", Font.ITALIC, 50));
        statusLabel2.setBounds(100, 270, 1000, 50);
        scorJPanel.add(statusLabel2);
        
        JLabel scoreLabel = new JLabel("Score");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Roboto Mono", Font.BOLD, 35));
        scoreLabel.setBounds(10, 410, 1000, 50);
        scorJPanel.add(scoreLabel);  

        JLabel scoreForX = new JLabel("X: " + game.returnScore1());
        scoreForX.setForeground(Color.WHITE);
        scoreForX.setFont(new Font("Roboto Mono", Font.PLAIN, 25));
        scoreForX.setBounds(10, 480, 1000, 50);
        scorJPanel.add(scoreForX);  

        JLabel scoreForO = new JLabel("O: " + game.returnScore2());
        scoreForO.setForeground(Color.WHITE);
        scoreForO.setFont(new Font("Roboto Mono", Font.PLAIN, 25));
        scoreForO.setBounds(10, 550, 1000, 50);
        scorJPanel.add(scoreForO);  

        // Create a reset button for user to reset the game
        JButton resetButton = new JButton();
        resetButton.setText("RESET");
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        resetButton.setBounds(85, 640, 200, 50);
        resetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        board[i][j].setText("");
                    }
                }
            }
        });
        scorJPanel.add(resetButton);
        
        // Create an exit button for user to exit the game
        JButton exitButton = new JButton();
        exitButton.setText("EXIT");
        exitButton.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        exitButton.setBounds(85, 710, 200, 50);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        scorJPanel.add(exitButton);
        
        splitPane.setLeftComponent(boardPanel);
        splitPane.setRightComponent(scorJPanel);

        // Fix the right section
        splitPane.setResizeWeight(1);
    
        // Set divider location to 400 pixel value
        splitPane.setDividerLocation(400);

        // Lock divider location
        splitPane.setEnabled(false);
        
        add(splitPane, BorderLayout.CENTER);

        // Display the GUI
        setVisible(true);
    }

    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setForeground(new Color(255, 0, 0));
     
            // Find the button's coordinates on the game board
            int x = -1, y = -1;
            
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
                game.setPlay(x,  y, "X");
            }
            if(currentPlayer.equals("O") && button.getText().equals("")){
                button.setText("O");
                currentPlayer = "X";
                game.setPlay(x,  y, "O");
            }

            if(game.isGameOverRow()) {

                if (currentPlayer == "X") {
                JOptionPane.showMessageDialog(null, "O has won this round!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "X has won this round!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                }
                if(currentPlayer.equals("X")){
                    currentPlayer = "O";
                }else{
                    currentPlayer = "X";
                }
                System.out.println(game.printBoard() + "\n" + currentPlayer +" wins!ROW");
                if(currentPlayer.equals("X")){
                    game.calculateScore("X");
                }else{
                    game.calculateScore("O");
                }
                System.out.println(game.returnScore1());
                System.out.println(game.returnScore2());
                if(currentPlayer.equals("X")){
                    currentPlayer = "O";
                }else{
                    currentPlayer = "X";
                }
            }
            if(game.isGameOverColumn()) {

                if (currentPlayer == "X") {
                    JOptionPane.showMessageDialog(null, "O has won this round!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    }
                else{
                    JOptionPane.showMessageDialog(null, "X has won this round!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    }
                if(currentPlayer.equals("X")){
                    currentPlayer = "O";
                }else{
                    currentPlayer = "X";
                }
                System.out.println(game.printBoard() + "\n" + currentPlayer +" wins!COLUMN");
                if(currentPlayer.equals("X")){
                    game.calculateScore("X");
                }else{
                    game.calculateScore("O");
                }
                System.out.println(game.returnScore1());
                System.out.println(game.returnScore2());
                if(currentPlayer.equals("X")){
                    currentPlayer = "O";
                }else{
                    currentPlayer = "X";
                }
            }
            if(game.isGameOverDiagonal()) {
                if (currentPlayer == "X") {
                    JOptionPane.showMessageDialog(null, "O has won this round!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    }
                else{
                    JOptionPane.showMessageDialog(null, "X has won this round!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    }
                if(currentPlayer.equals("X")){
                    currentPlayer = "O";
                }else{
                    currentPlayer = "X";
                }
                System.out.println(game.printBoard() + "\n" + currentPlayer +" wins!DIAGONAL");
            	if(currentPlayer.equals("X")){
                game.calculateScore("X");
            }else{
                game.calculateScore("O");
                
            }
            System.out.println(game.returnScore1());
            System.out.println(game.returnScore2());
            if(currentPlayer.equals("X")){
                currentPlayer = "O";
            }else{
                currentPlayer = "X";
            }
            
        }
        
    }
}
    
}
