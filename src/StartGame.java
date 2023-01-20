import javax.swing.*;
import java.awt.event.*;


public class StartGame implements ActionListener  {

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button = new JButton("START");
    JTextField text;
    JTextField text2;  
    JTextField rowsinput;
    JTextField colsinput; 

    public StartGame(){

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    
        panel.setLayout(null);

        JLabel label1 = new JLabel("Player 1");
        label1.setBounds(20, 10, 80, 25);
        panel.add(label1);

        text = new JTextField();
        text.setBounds(110, 10, 180, 25);
        panel.add(text);

        JLabel label2 = new JLabel("Player 2");
        label2.setBounds(20, 40, 80, 25);
        panel.add(label2);

        text2 = new JTextField();
        text2.setBounds(110, 40, 180, 25);
        panel.add(text2);

        JLabel label3 = new JLabel("Enter the number of rows \nand columns");
        label3.setBounds(20, 90, 200, 25);
        panel.add(label3);

        rowsinput = new JTextField();
        rowsinput.setBounds(210, 90, 30, 25);
        panel.add(rowsinput);

        button.setBounds(65, 180, 140, 25);
        button.addActionListener(this);
        panel.add(button);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == button){
            
            String player1 = text.getText();
            String player2 = text2.getText();
            int rows = Integer.valueOf(rowsinput.getText());
            int cols = rows;
            if (!player1.isEmpty() && !player2.isEmpty()) {
                frame.dispose();
                TicTacToeGUI tictactoeGUI = new TicTacToeGUI(player1, player2, rows, cols);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a name for both players");
            }
        }

    }

    public static void main(String[] args) {
        new StartGame();
    }

}
    

