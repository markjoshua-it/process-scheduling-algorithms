package ui;

import input.*;
import java.awt.*;
import javax.swing.*;
import main.MainWindow;
import main.Scheduler;
import static misc.UIConstants.*;


public class Rr {
    Scheduler schedule;
    MainWindow mainWindow;
    Output output;
    ArrivalTimeInput arrivalTimeInput = new ArrivalTimeInput(); 
    BurstTimeInput burstTimeInput = new BurstTimeInput(); 
    TimeQuantumInput timeQuantumInput = new TimeQuantumInput();
    SolveButton solveButton = new SolveButton();
    private String[] arrivalTimeStr;
    private String[] burstTimeStr;
    private String[] timeQuantumStr;
    private int timeQuantum;
    private int[] arrivalTime;
    private int[] burstTime;
    
    public Rr(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }

    public JPanel displayInput(){
        JPanel inputUI = new JPanel();
        inputUI.setBackground(PANEL_COLOR);
        inputUI.setPreferredSize(BOTTOM_PANEL_SIZE);
        inputUI.add(arrivalTimeInput);
        inputUI.add(burstTimeInput);
        inputUI.add(timeQuantumInput);
        inputUI.add(solveButton);

        solveButton.solveButton.addActionListener(e -> {
            arrivalTimeStr = arrivalTimeInput.getArrivalTime();
            burstTimeStr = burstTimeInput.getBurstTime();
            timeQuantumStr = timeQuantumInput.getTimeQuantum();
            arrivalTime = new int[arrivalTimeStr.length];
            burstTime = new int[burstTimeStr.length];
            boolean isCorrectInput = true;
            
            if(arrivalTimeInput.isEmpty() || 
               burstTimeInput.isEmpty() || 
               arrivalTimeStr.length!=burstTimeStr.length || 
               timeQuantumStr.length!=1)
            {
                JOptionPane.showMessageDialog(mainWindow, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                isCorrectInput = false;
            } else {
                
                for(int i = 0; i < arrivalTimeStr.length; i++){
                    try {
                        arrivalTime[i] = Integer.parseInt(arrivalTimeStr[i]);
                        burstTime[i] = Integer.parseInt(burstTimeStr[i]);
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(mainWindow, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                        isCorrectInput = false;
                        break;
                    }
                }
                
                try {
                    timeQuantum = Integer.parseInt(timeQuantumStr[0]);
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(mainWindow, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    isCorrectInput = false;
                }
            }
            if(isCorrectInput){ 
                schedule = new Scheduler(arrivalTime, burstTime, timeQuantum);
                mainWindow.add(displayOutput(), "rrOutput");
                mainWindow.showWindow("rrOutput"); 
            }
        });

        return inputUI;
    }

    public JPanel displayOutput(){
        BottomButton bottomButton = new BottomButton(mainWindow);
        JPanel outputUI = new JPanel();
        outputUI.setLayout(new BorderLayout());
        
        output = new Output(schedule);
        
        outputUI.add(output.ganttChart2(), BorderLayout.NORTH);
        outputUI.add(output.table2(TITLE_2), BorderLayout.CENTER);
        outputUI.add(bottomButton, BorderLayout.SOUTH);
        
        outputUI.setBackground(PANEL_COLOR);
        outputUI.setPreferredSize(PANEL_SIZE);
        return outputUI;
    }
}
