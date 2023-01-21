import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class StartGame implements ActionListener  {


   // JPanel player1Panel = new JPanel();
    JFrame frame = new JFrame();
    JPanel welcomePanel = new JPanel();
    JPanel player1Panel = new JPanel();
    JPanel player2Panel = new JPanel();
    JPanel gameStructurePanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    JLabel gameStructureLabel = new JLabel();
    JLabel welcomeLabel = new JLabel();
    JLabel footerLabel = new JLabel();
    JButton button = new JButton("START");
    JTextField player1TextField = new JTextField();
    JTextField player2TextField = new JTextField(); 
    JTextField gameGrid = new JTextField(); 
   

    public StartGame(){
      
       //Frame design
       frame.setSize(800, 600);
       frame.setTitle ("Tic Tac Toe");
       ImageIcon companyLogo = new ImageIcon("C:/Users/user/Desktop/CAT201-Project-TicTacToe-main/CAT201-Project-TicTacToe-main/src/OTTY-Logo.png");
       frame.setIconImage(companyLogo.getImage());
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setBackground(new Color(250, 219, 216));// hex:0x#FADBD8
       frame.setVisible(true);

       //Set Welcome Panel (header) 
       frame.setLayout(new BorderLayout());
       frame.add (welcomePanel, BorderLayout.NORTH);
    
       //Set Contents Panel 
       JPanel centerPanel = new JPanel (new GridLayout(1,2));
       centerPanel.add(player1Panel);
       centerPanel.add(player2Panel);
       frame.add(centerPanel, BorderLayout.CENTER);
       
       //Set Footer Panel
       JPanel footer = new JPanel(new GridLayout(2, 1));
       JPanel footerRow1 = new JPanel();
       footerRow1.add(new JLabel("Footer Row 1"));
       footer.add(gameStructurePanel);
       JPanel footerRow2 = new JPanel();
       footerRow2.add(new JLabel("Footer Row 2"));
       footer.add(footerPanel);
       frame.add(footer, BorderLayout.SOUTH);
    
       //Set panel colour
       welcomePanel.setBackground(new Color(200, 219, 216));
       player1Panel.setBackground(new Color(250, 219, 216));
       player2Panel.setBackground(new Color(250, 219, 216));
       gameStructurePanel.setBackground(new Color(230, 219, 216));
       footerPanel.setBackground(new Color(200, 219, 216));

      //Set welcome label
       welcomeLabel.setText("Tic Tac Toe");
       welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
       welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
       welcomePanel.add(welcomeLabel);

       //Label for Player 1
       ImageIcon imagePlayer1 = new ImageIcon ("C:/Users/user/Desktop/CAT201-Project-TicTacToe-main/CAT201-Project-TicTacToe-main/src/player1.png");
       label.setText("Player 1");
       label.setIcon(imagePlayer1);
       label.setHorizontalTextPosition(JLabel.CENTER);
       label.setVerticalTextPosition(JLabel.BOTTOM);
       label.setForeground(new Color(0, 0, 0)); //set font color
       label.setFont(new Font("Arial", Font.BOLD, 20)); //set font
       label.setIconTextGap(2);
       label.setVerticalAlignment(JLabel.CENTER);
       label.setHorizontalAlignment (JLabel.LEFT);
       player1Panel.add(label);
      
       
       //Label for Player 2
       ImageIcon imagePlayer2 = new ImageIcon ("C:/Users/user/Desktop/CAT201-Project-TicTacToe-main/CAT201-Project-TicTacToe-main/src/Player2.png" );
       label2.setText("Player 2");
       label2.setIcon(imagePlayer2);
       label2.setHorizontalTextPosition(JLabel.CENTER);
       label2.setVerticalTextPosition(JLabel.BOTTOM);
       label2.setForeground(new Color(0, 0, 0)); //set font color
       label2.setFont(new Font("Arial", Font.BOLD, 20)); //set font
       label2.setIconTextGap(2);
       label2.setVerticalAlignment(JLabel.CENTER);
       label2.setHorizontalAlignment (JLabel.RIGHT); 
       player2Panel.add(label2);;

    
       // Label for game structure (rows and column played)
      
       gameStructureLabel.setText("Enter the number of rows \nand columns:");
       gameStructureLabel.setFont(new Font("Arial", Font.BOLD, 20)); //set font
       gameStructureLabel.setHorizontalTextPosition(JLabel.LEFT);
       gameStructureLabel.setVerticalTextPosition(JLabel.BOTTOM);
       gameStructurePanel.add(gameStructureLabel);

       footerLabel.setText("This game is modified by:cj,zc,hj,kh for CAT201 Project, USM");
       footerLabel.setFont(new Font("Papyrus", Font.BOLD, 15)); //set font
       footerLabel.setHorizontalTextPosition(JLabel.LEFT);
       footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
       footerPanel.add(footerLabel);
      
       //This section adds the text field for user to key in their names before game starts
       //Player 1 text field settings
       player1TextField.setColumns(20);
       player1TextField.setFont(new Font("Arial", Font.PLAIN, 20));
       player1Panel.add(player1TextField);
       
       //Player 2 text field settings
       player2TextField.setColumns(20);
       player2TextField.setFont(new Font("Arial", Font.PLAIN, 20));
       player2Panel.add(player2TextField);

       //Input rows and columns 
       gameGrid.setColumns (5);
       gameGrid.setFont(new Font("Arial", Font.PLAIN, 22));
       gameStructurePanel.add(gameGrid);

       //This section adds a start button in order to start the game

        button.addActionListener(this);
        button.setFont(new Font("Arial", Font.BOLD,15));
        gameStructurePanel.add(button);
        button.setBackground (new Color (250, 219,250));


    //     frame.setVisible(true);
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

    

