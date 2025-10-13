package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static misc.UIConstants.OUTPUT_PROCESS_FONT;

public class GanttChart extends JPanel{
    JPanel processNamePanel = new JPanel(new BorderLayout());
    JPanel processTimePanel = new JPanel(new BorderLayout());
    JLabel processLabel; 
    JLabel processTimeLabel; 
    JLabel firstProcessTimeLabel; 
    
    public GanttChart(String processName, int time){
        processLabel = new JLabel(processName);
        processTimeLabel = new JLabel(String.valueOf(time));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(51, 50));
        
        processLabel.setFont(OUTPUT_PROCESS_FONT);
        processLabel.setHorizontalAlignment(JLabel.CENTER);
        processLabel.setVerticalAlignment(JLabel.CENTER);
        processTimePanel.add(processTimeLabel, BorderLayout.EAST);
        
        processNamePanel.setBorder(new LineBorder(Color.black));
        processNamePanel.add(processLabel, BorderLayout.CENTER);
        add(processNamePanel, BorderLayout.CENTER);
        add(processTimePanel, BorderLayout.SOUTH);
    }
    
    public GanttChart(String processName, int time, int firstNum){
        processLabel = new JLabel(processName);
        processTimeLabel = new JLabel(String.valueOf(time));
        firstProcessTimeLabel = new JLabel(String.valueOf(firstNum));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(55, 50));
        
        processLabel.setFont(OUTPUT_PROCESS_FONT);
        processLabel.setHorizontalAlignment(JLabel.CENTER);
        processLabel.setVerticalAlignment(JLabel.CENTER);
        
        processTimePanel.add(firstProcessTimeLabel, BorderLayout.WEST);
        processTimePanel.add(processTimeLabel, BorderLayout.EAST);
        
        processNamePanel.setBorder(new LineBorder(Color.black));
        processNamePanel.add(processLabel, BorderLayout.CENTER);
        add(processNamePanel, BorderLayout.CENTER);
        add(processTimePanel, BorderLayout.SOUTH);
    }
}
