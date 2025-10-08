package algorithms;

import input.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class Fcfs extends JPanel {
    
    ArrivalTimeInput arrivalTimeInput = new ArrivalTimeInput(); 
    BurstTimeInput burstTimeInput = new BurstTimeInput(); 
    SolveButton solveButton = new SolveButton();
    private String[] arrivalTimeStr;
    private String[] burstTimeStr;
    
    public Fcfs(){
        setBackground(PANEL_COLOR);
        setPreferredSize(BOTTOM_PANEL_SIZE);
        add(arrivalTimeInput);
        add(burstTimeInput);
        add(solveButton);
        validateInput();
    }
    public void validateInput(){
        solveButton.solveButton.addActionListener(e -> {
            arrivalTimeStr = arrivalTimeInput.getArrivalTime();
            burstTimeStr = burstTimeInput.getBurstTime();
            int[] arrivalTime = new int[arrivalTimeStr.length];
            int[] burstTime = new int[burstTimeStr.length];
            
            if(arrivalTimeStr.length==0 || 
                burstTimeStr.length==0 || 
                arrivalTime.length != burstTime.length)
            {
                JOptionPane.showMessageDialog(null, "Invalid Input/ fcfs", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for(int i = 0; i < arrivalTimeStr.length; i++){
                    try {
                        arrivalTime[i] = Integer.parseInt(arrivalTimeStr[i]);
                        burstTime[i] = Integer.parseInt(burstTimeStr[i]);
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(null, "Can't contain letter/s", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                
                solveFcfs(arrivalTime, burstTime);
            }
        });
    }
    
    public void solveFcfs(int[] arrvivalTime, int[] burstTime){
        // solving part
        // to do
    }
}
