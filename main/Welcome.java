package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class Welcome extends JPanel {
    private final JLabel title = new JLabel("CPU Scheduling");
    private final JLabel title2 = new JLabel("Simulator");
    private final String members[] = {
                        "Mark Joshua Padilla",
                        "Kryzza Mae Quizada",
                        "Miko James Santos",
                        "Mark Gerald Sullano"};
    JLabel[] membersLabel = new JLabel[members.length];
    
    public Welcome(MainWindow mainWindow){
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        title.setForeground(new Color(0, 120, 215));
        title.setFont(new Font("Segoe UI", Font.BOLD, 60));
        title2.setForeground(new Color(0, 120, 215));
        title2.setFont(new Font("Segoe UI", Font.BOLD, 55));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=0; gbc.gridy=1;
        gbc.insets = new Insets(-150, 0, 0, 0);
        add(title, gbc);
        gbc.gridx=0; gbc.gridy=2;
        gbc.insets = new Insets(-50, 0, 50, 0);
        add(title2, gbc);
        
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setMaximumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        gbc.insets = new Insets(0, 0, 5, 0);
        for (int i = 0; i < members.length; i++) {
            gbc.gridx=0; gbc.gridy=3+i;
            add(membersLabel[i] = new JLabel(members[i]), gbc); 
            membersLabel[i].setFont(new Font("Segoe UI", Font.PLAIN, 28));
        }
        
        
        addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e){
               mainWindow.showWindow("input");
           }
        }); 
    }
}
