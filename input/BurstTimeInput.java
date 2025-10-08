package input;

import java.awt.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class BurstTimeInput extends JPanel {
    
    private final JTextField burstTimeInput = new JTextField();
    private final JLabel burstTimeLabel = new JLabel("Burst Time");
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();
    
    public BurstTimeInput(){
        setBackground(PANEL_COLOR);
        setLayout(gridBagLayout);
        burstTimeInput.setFont(INPUT_FONT);
        burstTimeInput.setBackground(INPUT_FIELD_COLOR);
        
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx=0; gbc.gridy=0;
        add(burstTimeLabel, gbc);
        
        gbc.gridx=0; gbc.gridy=1;
        burstTimeInput.setPreferredSize(COMPONENT_SIZE);
        add(burstTimeInput, gbc);
    }
    
    public String[] getBurstTime(){
        return burstTimeInput.getText().trim().split("\\s+");
    }
    public boolean isEmpty(){
        return burstTimeInput.getText().isEmpty();
    }
}
