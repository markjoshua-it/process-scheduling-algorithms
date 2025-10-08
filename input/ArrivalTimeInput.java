package input;

import java.awt.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class ArrivalTimeInput extends JPanel {
    
    private final JTextField arrivalTimeInput = new JTextField();
    private final JLabel arrivalTimeLabel = new JLabel("Arrival Time");
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();

    public ArrivalTimeInput(){
        setBackground(PANEL_COLOR);
        setLayout(gridBagLayout);
        arrivalTimeInput.setFont(INPUT_FONT);
        arrivalTimeInput.setBackground(INPUT_FIELD_COLOR);
        
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx=0; gbc.gridy=0;
        add(arrivalTimeLabel, gbc);
        
        gbc.gridx=0; gbc.gridy=1;
        arrivalTimeInput.setPreferredSize(COMPONENT_SIZE);
        add(arrivalTimeInput, gbc);
    }
    
    public String[] getArrivalTime(){
        return arrivalTimeInput.getText().trim().split("\\s+");
    }
    public boolean isEmpty(){
        return arrivalTimeInput.getText().isEmpty();
    }
}
