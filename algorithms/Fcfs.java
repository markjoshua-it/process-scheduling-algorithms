package algorithms;

import input.*;
import java.awt.*;
import javax.swing.*;
import main.MainWindow;
import misc.Title;
import static misc.UIConstants.*;

public class Fcfs {
    MainWindow mainWindow;
    ArrivalTimeInput arrivalTimeInput = new ArrivalTimeInput(); 
    BurstTimeInput burstTimeInput = new BurstTimeInput(); 
    SolveButton solveButton = new SolveButton();
    private String[] arrivalTimeStr;
    private String[] burstTimeStr;
    private boolean isCorrectInput = true;
    
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
            int[] arrivalTime = new int[arrivalTimeStr.length];
            int[] burstTime = new int[burstTimeStr.length];
            
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
            
            if(isCorrectInput) { mainWindow.showWindow("fcfsOutput"); }
        });

        return inputUI;
    }

    public JPanel displayOutput(){
        JPanel outputUI = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        outputUI.setLayout(new GridLayout());

        gbc.gridx=0; gbc.gridy=0;
        outputUI.add(new Title("- FCFS -"), gbc);
        outputUI.setBackground(PANEL_COLOR);
        outputUI.setPreferredSize(PANEL_SIZE);
        return outputUI;
    }
}