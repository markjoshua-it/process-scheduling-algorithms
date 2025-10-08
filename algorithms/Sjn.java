package algorithms;

import input.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static misc.UIConstants.*;

public class Sjn extends JPanel {
    
    ArrivalTimeInput arrivalTimeInput = new ArrivalTimeInput(); 
    BurstTimeInput burstTimeInput = new BurstTimeInput(); 
    SolveButton solveButton = new SolveButton();
    private String[] arrivalTimeStr;
    private String[] burstTimeStr;
    private boolean isCorrectInput = false;
    
    public Sjn(){
        setBackground(PANEL_COLOR);
        setPreferredSize(PANEL_SIZE);
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

            if(arrivalTimeInput.isEmpty() || burstTimeInput.isEmpty() || arrivalTimeStr.length!=burstTimeStr.length){
                JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for(int i = 0; i < arrivalTimeStr.length; i++){
                    try {
                        arrivalTime[i] = Integer.parseInt(arrivalTimeStr[i]);
                        burstTime[i] = Integer.parseInt(burstTimeStr[i]);
                        isCorrectInput = true;
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(null, "Can't contain letter/s", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                
                solveSjn(arrivalTime, burstTime);
            } 
        });
    }
    
    public void solveSjn(int[] arrvivalTime, int[] burstTime){
    // solving part
    // to do
    }
    
}
