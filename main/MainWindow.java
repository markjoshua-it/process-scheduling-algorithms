package main;

import ui.*;
import input.SelectAlgo;
import java.awt.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class MainWindow extends JFrame {
    
    ImageIcon cpuIcon = new ImageIcon("src\\assets\\cpu.png");
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    JPanel inputPanel = new JPanel();
    CardLayout inputField = new CardLayout();
    CardLayout window = new CardLayout();
    Welcome welcome = new Welcome(this);
    SelectAlgo selectAlgo = new SelectAlgo(this);
    Fcfs fcfs = new Fcfs(this);
    Sjn sjn = new Sjn(this);
    Rr rr = new Rr(this);
    
    public MainWindow(){
        top.setBackground(PANEL_COLOR);
        bottom.setBackground(PANEL_COLOR);
        setTitle("CPU Scheduling Simulator");
        setIconImage(cpuIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE);
        setResizable(false);
        setLayout(window);
        
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(PANEL_COLOR);
        
        bottom.setLayout(inputField);
        bottom.setPreferredSize(BOTTOM_PANEL_SIZE);
        
        top.add(selectAlgo);
        bottom.add(fcfs.displayInput(), "fcfsInput");
        bottom.add(sjn.displayInput(), "sjnInput");
        bottom.add(rr.displayInput(), "rrInput");
        inputPanel.add(top, BorderLayout.NORTH);
        inputPanel.add(bottom, BorderLayout.CENTER);
        
        add(welcome, "welcome");
        add(inputPanel, "input");
//        add(fcfs.displayOutput(), "fcfsOutput");
        add(sjn.displayOutput(), "sjnOutput");
        add(rr.displayOutput(), "rrOutput");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void showInputField(int cardNum){
        switch(cardNum){
            case 0: inputField.show(bottom,"fcfsInput"); break;
            case 1: inputField.show(bottom,"sjnInput"); break;
            case 2: inputField.show(bottom,"rrInput"); break;
        }
    }   
    public void showWindow(String windowName){
        window.show(getContentPane(), windowName);
    }
    
    public static void main(String[] args) { new MainWindow(); }
}
