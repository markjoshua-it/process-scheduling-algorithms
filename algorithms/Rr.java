package algorithms;

import input.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class Rr extends JPanel {
    
    ArrivalTimeInput arrivalTimeInput = new ArrivalTimeInput(); 
    BurstTimeInput burstTimeInput = new BurstTimeInput(); 
    TimeQuantumInput timeQuantumInput = new TimeQuantumInput();
    SolveButton solveButton = new SolveButton();
    private String[] arrivalTimeStr;
    private String[] burstTimeStr;
    private String[] timeQuantumStr;
    private int timeQuantum;
    
    public Rr(){
        setBackground(PANEL_COLOR);
        setPreferredSize(BOTTOM_PANEL_SIZE);
        add(arrivalTimeInput);
        add(burstTimeInput);
        add(timeQuantumInput);
        add(solveButton);
        validateInput();
    }
    public void validateInput(){
        solveButton.solveButton.addActionListener(e -> {
            arrivalTimeStr = arrivalTimeInput.getArrivalTime();
            burstTimeStr = burstTimeInput.getBurstTime();
            timeQuantumStr = timeQuantumInput.getTimeQuantum();
            int[] arrivalTime = new int[arrivalTimeStr.length];
            int[] burstTime = new int[burstTimeStr.length];
            System.out.println(timeQuantumStr.length);
            if(arrivalTimeInput.isEmpty() || 
               burstTimeInput.isEmpty() || 
               arrivalTimeStr.length!=burstTimeStr.length || 
               timeQuantumStr.length!=1){
                
                JOptionPane.showMessageDialog(null, "Invalid Input/ Not pantay haha", "Error", JOptionPane.ERROR_MESSAGE);
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
                
                try {
                    timeQuantum = Integer.parseInt(timeQuantumStr[0]);
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Can't contain letter/s TQ", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                solveRr(arrivalTime, burstTime, timeQuantum);
            }
        });
    }
    
    public void solveRr(int[] arrvivalTime, int[] burstTime, int timeQuantum){
        // solving part
        // to do
    }
}
