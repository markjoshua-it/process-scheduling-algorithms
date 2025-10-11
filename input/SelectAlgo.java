package input;

import java.awt.*;
import javax.swing.*;
import main.*;
import misc.Title;
import static misc.UIConstants.*;

public class SelectAlgo extends JPanel {
    
    private final JLabel selectAlgoLabel = new JLabel("Algorithm");
    private final String[] algoChoices = {"First-Come First-Served (FCFS)", 
                                          "Shortest Job Next (SJN)", 
                                          "Round Robin (RR)"};
    public JComboBox algoChoicesBox = new JComboBox(algoChoices);
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();
    private final Title title = new Title("- Input -");

    
    public SelectAlgo(MainWindow mainWindow){    
        setBackground(PANEL_COLOR);
        setLayout(gridBagLayout);
        gbc.gridx=0; gbc.gridy=0;
        add(title, gbc);
        algoChoicesBox.setFont(INPUT_FONT);
        algoChoicesBox.setBackground(INPUT_FIELD_COLOR);
        gbc.insets = new Insets(25, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx=0; gbc.gridy=1;
        add(selectAlgoLabel, gbc);
        
        gbc.gridx=0; gbc.gridy=2;
        gbc.insets = new Insets(5, 0, 0, 0);
        algoChoicesBox.setPreferredSize(COMPONENT_SIZE);
        add(algoChoicesBox, gbc);
        
        algoChoicesBox.addActionListener(e -> {
            mainWindow.showInputField(algoChoicesBox.getSelectedIndex());
        });
        
    }
}
