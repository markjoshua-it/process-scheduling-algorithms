package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.Scheduler;
import static misc.UIConstants.OUTPUT_PROCESS_FONT;

public class Output {
    
    Scheduler scheduler;
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    private int[] arrivalTime;
    private int[] burstTime;
    private int[] startTime;private int[] completionTime;
    private int[] waitingTime;
    private int timeQuantum;
    private int totalWaitingTime = 0;
    private double averageWaitingTime = 0;
    private int processNum;
    private String[] processName;
    
    public Output(Scheduler scheduler) {
        this.scheduler = scheduler;
        this.arrivalTime = scheduler.getArrivalTime();
        this.burstTime = scheduler.getBurstTime();
        this.startTime = scheduler.getStartTime();
        this.completionTime = scheduler.getCompletionTime();
        this.waitingTime = scheduler.getWaitingTime();
        this.timeQuantum = scheduler.geTimeQuantum();
        this.totalWaitingTime = scheduler.getTotalWaitingTime();
        this.averageWaitingTime = scheduler.getAverageWaitingTime();
        this.processName = scheduler.getProcessName();
        this.processNum = scheduler.getProcessNum();
        System.out.println(averageWaitingTime);
    }
    
    public JPanel ganttChart(){
        JPanel ganttChartPanel = new JPanel(); 
        JPanel processChartPanel = new JPanel(); 
        JLabel ganttChartLabel = new JLabel("Gantt Chart");
        for(int i = 0; i < processNum; i++){
            if(i==0) {
                processChartPanel.add(new GanttChart(processName[i], completionTime[i], startTime[0]));
            }else processChartPanel.add(new GanttChart(processName[i], completionTime[i]));
        }
        ganttChartLabel.setLayout(layout);
        ganttChartLabel.setBackground(Color.green);
        ganttChartLabel.setFont(OUTPUT_PROCESS_FONT);
        ganttChartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        processChartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -1, 10));

        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.gridx=0; gbc.gridy=0;
        ganttChartPanel.add(ganttChartLabel);
        
        gbc.gridx=0; gbc.gridy=1;
        processChartPanel.setPreferredSize(new Dimension(800, 160));
        processChartPanel.setBackground(Color.RED);
        ganttChartPanel.add(processChartPanel);
        
        ganttChartPanel.setBackground(Color.blue);
        return ganttChartPanel;
    }
    
    public JPanel table(String[] title){
        JPanel tablePanel = new JPanel();
        Table[] table = new Table[title.length];
        tablePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(0, -1, -1, 0);
        for(int i = 0; i < title.length; i++){
            gbc2.gridx = i; gbc2.gridy = 0;
            tablePanel.add(table[i] = new Table(title[i]), gbc2);
            table[i].setBackground(new Color(215, 215, 215));
        }
        for(int i = 0; i < processNum; i++){
            for(int j = 0; j < title.length; j++){
                gbc2.gridx = j;
                gbc2.gridy = i + 1;

                switch (j) {
                    case 0:
                        tablePanel.add(new Table(processName[i]), gbc2); break;
                    case 1:
                        tablePanel.add(new Table(String.valueOf(arrivalTime[i])), gbc2); break;
                    case 2:
                        tablePanel.add(new Table(String.valueOf(burstTime[i])), gbc2); break;
                    case 3:
                        tablePanel.add(new Table(String.valueOf(startTime[i])), gbc2); break;
                    case 4:
                        tablePanel.add(new Table(String.valueOf(waitingTime[i])), gbc2); break;
                }
            }
        }
        gbc2.gridx = title.length-1; gbc2.gridy = processNum+2;
        tablePanel.add(new Table(String.format("%d / %d = %s", totalWaitingTime, processNum, averageWaitingTime)), gbc2);
        gbc2.gridx = title.length-2; gbc2.gridy = processNum+2;
        tablePanel.add(new Table("  Average"), gbc2);
        gbc2.gridwidth = 3;
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.gridx = 0 ; gbc2.gridy = processNum+2;
        tablePanel.add(new Table(" "), gbc2);
        tablePanel.setBackground(Color.PINK);
        tablePanel.setPreferredSize(new Dimension(800, 100)); 
        return tablePanel;
    }
     
    public JPanel processNameContainer(String processName, int time){
        JPanel processContainer = new JPanel(new BorderLayout());
        JPanel processNamePanel = new JPanel(new BorderLayout());
        JLabel processLabel = new JLabel(processName);
        
        processLabel.setFont(OUTPUT_PROCESS_FONT);
        processLabel.setHorizontalAlignment(JLabel.CENTER);
        processLabel.setVerticalAlignment(JLabel.CENTER);
        processNamePanel.setPreferredSize(new Dimension(51, 50));
        processNamePanel.setBackground(Color.YELLOW);
        processNamePanel.add(processLabel, BorderLayout.CENTER);
        processContainer.add(processNamePanel, BorderLayout.CENTER);
        processContainer.add(processNamePanel, BorderLayout.SOUTH);
        return processContainer;
    }
}
