package ui;

import input.*;
import java.awt.*;
import javax.swing.*;
import main.MainWindow;
import misc.Title;
import static misc.UIConstants.*;


public class Rr {
    MainWindow mainWindow;
    ArrivalTimeInput arrivalTimeInput = new ArrivalTimeInput(); 
    BurstTimeInput burstTimeInput = new BurstTimeInput(); 
    TimeQuantumInput timeQuantumInput = new TimeQuantumInput();
    SolveButton solveButton = new SolveButton();
    private String[] arrivalTimeStr;
    private String[] burstTimeStr;
    private String[] timeQuantumStr;
    private int timeQuantum;
    
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
            int[] arrivalTime = new int[arrivalTimeStr.length];
            int[] burstTime = new int[burstTimeStr.length];
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
                        JOptionPane.showMessageDialog(mainWindow, "Can't contain letter/s", "Error", JOptionPane.ERROR_MESSAGE);
                        isCorrectInput = false;
                        break;
                    }
                }
                
                try {
                    timeQuantum = Integer.parseInt(timeQuantumStr[0]);
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(mainWindow, "Can't contain letter/s TQ", "Error", JOptionPane.ERROR_MESSAGE);
                    isCorrectInput = false;
                }
            }
            if(isCorrectInput){ mainWindow.showWindow("rrOutput"); }
        });

        return inputUI;
    }

    public JPanel displayOutput(){
        JPanel outputUI = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        outputUI.setLayout(new GridLayout());

        gbc.gridx=0; gbc.gridy=0;
        outputUI.add(new Title("- RR -"), gbc);
        outputUI.setBackground(PANEL_COLOR);
        outputUI.setPreferredSize(PANEL_SIZE);
        return outputUI;
    }
}
