package ui;

import input.*;
import java.awt.*;
import javax.swing.*;
import main.MainWindow;
import main.Scheduler;
import misc.Title;
import static misc.UIConstants.*;

public class Sjn {
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
    
    public Sjn(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }

    public JPanel displayInput(){
        JPanel inputUI = new JPanel();
        inputUI.setBackground(PANEL_COLOR);
        inputUI.setPreferredSize(PANEL_SIZE);
        inputUI.add(arrivalTimeInput);
        inputUI.add(burstTimeInput);
        inputUI.add(solveButton);

        solveButton.solveButton.addActionListener(e -> {
            arrivalTimeStr = arrivalTimeInput.getArrivalTime();
            burstTimeStr = burstTimeInput.getBurstTime();
            arrivalTime = new int[arrivalTimeStr.length];
            burstTime = new int[burstTimeStr.length];
            boolean isCorrectInput = true;

            if(arrivalTimeInput.isEmpty() || 
               burstTimeInput.isEmpty() || 
               arrivalTimeStr.length!=burstTimeStr.length)
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
            } 

            if(isCorrectInput) { 
                schedule = new Scheduler(arrivalTime, burstTime, "sjn");
                mainWindow.add(displayOutput(), "sjnOutput");
                mainWindow.showWindow("sjnOutput"); 
            }
        });

        return inputUI;
    }

    public JPanel displayOutput(){
        BottomButton bottomButton = new BottomButton(mainWindow);
        JPanel outputUI = new JPanel();
        outputUI.setLayout(new BorderLayout());
        
        output = new Output(schedule);
        
        outputUI.add(output.ganttChart(), BorderLayout.NORTH);
        outputUI.add(output.table(TITLE_1), BorderLayout.CENTER);
        outputUI.add(bottomButton, BorderLayout.SOUTH);
        
        outputUI.setBackground(PANEL_COLOR);
        outputUI.setPreferredSize(PANEL_SIZE);
        return outputUI;
    }
}