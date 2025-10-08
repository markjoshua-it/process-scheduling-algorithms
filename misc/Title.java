package misc;

import java.awt.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class Title extends JPanel {
    
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();
    
    public Title(String title){
        setBackground(PANEL_COLOR);
        setLayout(gridBagLayout);
        JLabel label = new JLabel(title);
        label.setBackground(PANEL_COLOR);
        label.setFont(TITLE_FONT);
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(label, gbc);
    }
}
