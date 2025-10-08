package input;

import java.awt.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class TimeQuantumInput extends JPanel {
    private final JTextField timeQuantumInput = new JTextField();
    private final JLabel timeQuantumLabel = new JLabel("Time Quantum");
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();
    
    public TimeQuantumInput(){
        setBackground(PANEL_COLOR);
        setLayout(gridBagLayout);
        timeQuantumInput.setFont(INPUT_FONT);
        timeQuantumInput.setBackground(INPUT_FIELD_COLOR);
        
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx=0; gbc.gridy=0;
        add(timeQuantumLabel, gbc);
        
        gbc.gridx=0; gbc.gridy=1;
        timeQuantumInput.setPreferredSize(COMPONENT_SIZE);
        add(timeQuantumInput, gbc);
    }
    
    public String[] getTimeQuantum(){
        return timeQuantumInput.getText().trim().split("\\s+");
    }
}
