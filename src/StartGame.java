import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class StartGame implements ActionListener  {

    JFrame frame = new JFrame();
    JPanel welcomePanel = new JPanel();
    JPanel player1Panel = new JPanel();
    JPanel player2Panel = new JPanel();
    JPanel gameStructurePanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel startPanel = new JPanel();
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel gameStructureLabel = new JLabel();
    JLabel welcomeLabel = new JLabel();
    JLabel footerLabel = new JLabel();
    JButton button = new JButton("Start Game");
    JTextField player1TextField = new JTextField();
    JTextField player2TextField = new JTextField(); 
    JTextField gameGrid = new JTextField(); 

    public StartGame(){
      
       //Frame design
       frame.setSize(800, 600);
       frame.setTitle ("Tic Tac Toe");
       ImageIcon companyLogo = new ImageIcon("src/TicTacToe.png");
       frame.setIconImage(companyLogo.getImage());
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       /*PANELS */
       //Set Welcome Panel (header) 
       frame.setLayout(new BorderLayout());
       frame.add (welcomePanel, BorderLayout.NORTH);
    
       //Set Contents Panel 
       JPanel centerPanel = new JPanel (new GridLayout(1,2));
       centerPanel.add(player1Panel);
       centerPanel.add(player2Panel);
       frame.add(centerPanel, BorderLayout.CENTER);
       
       //Set Footer Panel
       JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
       bottomPanel.add(gameStructurePanel);
       bottomPanel.add(startPanel);
       bottomPanel.add(footerPanel);
       frame.add(bottomPanel, BorderLayout.SOUTH);
    
       //Set panel colour
       welcomePanel.setBackground(new Color(0x84a98c));
       player1Panel.setBackground(new Color(0xcad2c5));
       player2Panel.setBackground(new Color(0xcad2c5));
       gameStructurePanel.setBackground(new Color(0xcad2c5));
       footerPanel.setBackground(new Color(0x84a98c));
       startPanel.setBackground(new Color(0xcad2c5));


      /*LABELS */ 
       welcomeLabel.setText("Tic Tac Toe");
       welcomeLabel.setVerticalAlignment (JLabel.CENTER);
       welcomeLabel.setHorizontalAlignment(JLabel.RIGHT);
       welcomeLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 50));
       welcomeLabel.setForeground(new Color(0x2f3e46));
       welcomePanel.add(welcomeLabel);

       //Label for Player 1
       ImageIcon imagePlayer1 = new ImageIcon ("src/player1.png");
       label.setText("Player 1");
       label.setIcon(imagePlayer1);
       label.setHorizontalTextPosition(JLabel.CENTER);
       label.setVerticalTextPosition(JLabel.BOTTOM);
       label.setForeground(new Color(0x2f3e46)); //set font color
       label.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
       label.setIconTextGap(2);
       label.setVerticalAlignment(JLabel.CENTER);
       label.setHorizontalAlignment (JLabel.LEFT);
       player1Panel.add(label);
      
       
       //Label for Player 2
       ImageIcon imagePlayer2 = new ImageIcon (src/Player2.png" );
       label2.setText("Player 2");
       label2.setIcon(imagePlayer2);
       label2.setHorizontalTextPosition(JLabel.CENTER);
       label2.setVerticalTextPosition(JLabel.BOTTOM);
       label2.setForeground(new Color(0x2f3e46)); //set font color
       label2.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
       label2.setIconTextGap(2);
       label2.setVerticalAlignment(JLabel.CENTER);
       label2.setHorizontalAlignment (JLabel.RIGHT); 
       player2Panel.add(label2);;

    
       // Label for game structure (rows and column played)
       gameStructureLabel.setText("Enter the number of grids:");
       gameStructureLabel.setForeground(new Color(0x2f3e46));
       gameStructureLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
       gameStructureLabel.setHorizontalTextPosition(JLabel.LEFT);
       gameStructureLabel.setVerticalTextPosition(JLabel.BOTTOM);
       gameStructurePanel.add(gameStructureLabel);
       
       //Label for footer
       footerLabel.setText("Modified by:Chu Jun, Zee Ching, Huey Jing & Kian Hon for CAT201 Project");
       footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
       footerLabel.setHorizontalTextPosition(JLabel.LEFT);
       footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
       footerPanel.add(footerLabel);
      
       //This section adds the text field for user to key in their names before game starts
       //Player 1 text field settings
       player1TextField.setColumns(20);
       player1TextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
       player1TextField.setForeground(new Color(0x354f52));
       label3.setText("**Insert Player 1's Name");
       label3.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
       label3.setForeground(new Color(0x52796f));
       player1Panel.add(player1TextField);
       player1Panel.add(label3);
       
       //Player 2 text field settingsa
       player2TextField.setColumns(20);
       player2TextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
       player2TextField.setForeground(new Color(0x354f52));
       label4.setText("**Insert Player 2's Name");
       label4.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
       label4.setForeground(new Color(0x52796f));
       player2Panel.add(player2TextField);
       player2Panel.add(label4);

       //Input rows and columns 
       gameGrid.setColumns (5);
       gameGrid.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
       gameGrid.setForeground(new Color(0x354f52));
       gameStructurePanel.add(gameGrid);

       //This section adds a start button in order to start the game
        button.addActionListener(this);
        button.setFont(new Font("Arial", Font.BOLD,15));
        button.setBackground (new Color (0x354f52));
        button.setForeground (new Color (0xcad2c5));
        startPanel.add(button);
        
        //Add visibility for frame
        frame.setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == button){
            
            String player1 = player1TextField.getText();
            String player2 = player2TextField.getText();
            int rows=0, cols=0;
            
            
            System.out.println(gameGrid.getText());
            
           if (!player1.isEmpty() && !player2.isEmpty()) {
                while(gameGrid.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter the number of  grid that you prefer"); 
                    rows = Integer.valueOf(gameGrid.getText());
                }
                rows = Integer.valueOf(gameGrid.getText());
                cols = rows;
                if(rows < 3){
                    JOptionPane.showMessageDialog(null, "The number of grid cannot be less than 3 !");
                }
                else{
                    rows = Integer.valueOf(gameGrid.getText());
                    cols = rows;
                    frame.dispose();
                    TicTacToeGUI tictactoeGUI = new TicTacToeGUI(player1, player2, rows, cols);
                }
            } 
            else {
                JOptionPane.showMessageDialog(null, "Please enter a name for both players");
            }
            
        }

    }

    public static void main(String[] args) {
        new StartGame();
    }

}
