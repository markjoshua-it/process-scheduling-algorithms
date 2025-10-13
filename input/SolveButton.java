package input;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class SolveButton extends JPanel {
    
    public JButton solveButton = new JButton("Solve");
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();
    
    public SolveButton(){
        solveButton.setBackground(BUTTON_BG);
        setBackground(PANEL_COLOR);
        setLayout(gridBagLayout);
        solveButton.setPreferredSize(new Dimension(275, 50));
        solveButton.setFocusable(false);
        solveButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        solveButton.setForeground(Color.white);
        solveButton.setBorderPainted(false);
        solveButton.setFocusPainted(false);
        gbc.insets = new Insets(30, 0, 0, 0);
        add(solveButton, gbc);
        
        solveButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                solveButton.setBackground(new Color(0, 100, 190));
            }
            @Override
            public void mouseExited(MouseEvent e){
                solveButton.setBackground(BUTTON_BG);
            }
            
        });
    }
    
}
