package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static misc.UIConstants.OUTPUT_PROCESS_FONT;
import static misc.UIConstants.PANEL_COLOR;

public class GanttChart extends JPanel{
    JPanel processNamePanel = new JPanel(new BorderLayout());
    JPanel processTimePanel = new JPanel(new BorderLayout());
    JLabel processLabel;
    JLabel processTimeLabel; 
    JLabel lastProcessTimeLabel; 
    
    public GanttChart(String processName, int time){
        processLabel = new JLabel(processName); 
        processTimeLabel = new JLabel(String.valueOf(time)); 
        setLayout(new BorderLayout()); 
        setPreferredSize(new Dimension(60, 50)); 
        setBackground(PANEL_COLOR);
        processLabel.setFont(OUTPUT_PROCESS_FONT);
        processLabel.setHorizontalAlignment(JLabel.CENTER);
        processLabel.setVerticalAlignment(JLabel.CENTER);
        processTimePanel.add(processTimeLabel, BorderLayout.WEST);
        processTimePanel.setBackground(PANEL_COLOR);
        processNamePanel.setBackground(PANEL_COLOR);
        
        processNamePanel.setBorder(new LineBorder(Color.black));
        processNamePanel.add(processLabel, BorderLayout.CENTER);
        add(processNamePanel, BorderLayout.CENTER);
        add(processTimePanel, BorderLayout.SOUTH);
    }
    
    public GanttChart(String processName, int time, int lastNum){
        processLabel = new JLabel(processName);
        processTimeLabel = new JLabel(String.valueOf(time));
        lastProcessTimeLabel = new JLabel(String.valueOf(lastNum));
        setBackground(PANEL_COLOR);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(60, 50));
        
        processLabel.setFont(OUTPUT_PROCESS_FONT);
        processLabel.setHorizontalAlignment(JLabel.CENTER);
        processLabel.setVerticalAlignment(JLabel.CENTER);
        
        processTimePanel.add(lastProcessTimeLabel, BorderLayout.EAST);
        processTimePanel.add(processTimeLabel, BorderLayout.WEST);
        processTimePanel.setBackground(PANEL_COLOR);
            
        processNamePanel.setBackground(PANEL_COLOR);
        processNamePanel.setBorder(new LineBorder(Color.black));
        processNamePanel.add(processLabel, BorderLayout.CENTER);
        add(processNamePanel, BorderLayout.CENTER);
        add(processTimePanel, BorderLayout.SOUTH);
    }
}
