package input;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.MainWindow;

public class BottomButton extends JPanel{
    JButton backButton = new JButton("Back");
    JButton exitButton = new JButton("Exit");
    public BottomButton(MainWindow mainWindow){
        setPreferredSize(new Dimension(800, 50));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createRigidArea(new Dimension(20, 0))); 
        add(backButton);
        add(Box.createHorizontalGlue());
        add(exitButton);
        add(Box.createRigidArea(new Dimension(20, 0))); 
        
        backButton.addActionListener(e->{
            mainWindow.showWindow("input");
        });
        exitButton.addActionListener(e->{
            JLabel label = new JLabel();
            label.setText("<html>"
                            + "<h1 style=\"text-align:center; font-size: 30px\">"
                                 + "I will miss you :("
                            + "</h1>"
                            + "<h4 style=\"text-align:center\">"
                                + "Do you really want to exit?"
                            + "</h4>"
                        + "</html>");
            label.setFont(new Font("Roboto", Font.BOLD, 30));
            label.setVerticalAlignment(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            int choice = JOptionPane.showConfirmDialog(mainWindow,label , null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(choice == 0){
                System.exit(0);
            }
        });
    }
}
