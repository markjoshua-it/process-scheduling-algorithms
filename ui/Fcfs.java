package ui;

import input.*;
import java.awt.*;
import javax.swing.*;
import main.*;
import static misc.UIConstants.*;

public class Fcfs {
    MainWindow mainWindow;
    Scheduler schedule;
    Output output;
    ArrivalTimeInput arrivalTimeInput = new ArrivalTimeInput(); 
    BurstTimeInput burstTimeInput = new BurstTimeInput(); 
    SolveButton solveButton = new SolveButton();
    private String[] arrivalTimeStr;
    private String[] burstTimeStr;
    private int[] arrivalTime;
    private int[] burstTime;
    
    public Fcfs(MainWindow mainWindow){ 
        this.mainWindow = mainWindow; 
    }

    public JPanel displayInput(){
        JPanel inputUI = new JPanel();
        inputUI.setBackground(PANEL_COLOR);
        inputUI.setPreferredSize(BOTTOM_PANEL_SIZE);
        inputUI.add(arrivalTimeInput);
        inputUI.add(burstTimeInput);
        inputUI.add(solveButton);

        solveButton.solveButton.addActionListener(e -> {
            arrivalTimeStr = arrivalTimeInput.getArrivalTime();
            burstTimeStr = burstTimeInput.getBurstTime();
            arrivalTime = new int[arrivalTimeStr.length];
            burstTime = new int[burstTimeStr.length];
            boolean isCorrectInput = true;
            
            if(arrivalTimeStr.length==0 || 
                burstTimeStr.length==0 || 
                arrivalTime.length != burstTime.length)
            {
                JOptionPane.showMessageDialog(mainWindow, "Invalid Input/ fcfs", "Error", JOptionPane.ERROR_MESSAGE);
                isCorrectInput = false;
            } else {
                for(int i = 0; i < arrivalTimeStr.length; i++){
                    try {
                        arrivalTime[i] = Integer.parseInt(arrivalTimeStr[i]);
                        burstTime[i] = Integer.parseInt(burstTimeStr[i]);
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(mainWindow, "Can't contain letter/s", "Error", JOptionPane.ERROR_MESSAGE);
                        isCorrectInput = false;
                        break;
                    }
                }
            }
            
            if(isCorrectInput) { 
                schedule = new Scheduler(arrivalTime, burstTime);
                mainWindow.add(displayOutput(), "fcfsOutput");
                mainWindow.showWindow("fcfsOutput"); 
            }
        });

        return inputUI;
    }

    public JPanel displayOutput(){
        BottomButton bottomButton = new BottomButton(mainWindow);
        JPanel outputUI = new JPanel();
        outputUI.setLayout(new BorderLayout());
        
        // test area
        output = new Output(schedule);
        
        outputUI.add(output.ganttChart(), BorderLayout.NORTH);
        outputUI.add(output.table(TITLE_1), BorderLayout.CENTER);
        outputUI.add(bottomButton, BorderLayout.SOUTH);
        
        outputUI.setBackground(PANEL_COLOR);
        outputUI.setPreferredSize(PANEL_SIZE);
        
//        bottomButton.backButton.addActionListener(e->{});

        return outputUI;
    }
}