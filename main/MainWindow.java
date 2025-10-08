package main;

import input.SelectAlgo;
import algorithms.*;
import java.awt.*;
import javax.swing.*;
import static misc.UIConstants.*;

public class MainWindow extends JFrame {
    
    ImageIcon cpuIcon = new ImageIcon("src/assets/cpu.png");
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    JPanel inputPanel = new JPanel();
    CardLayout inputField = new CardLayout();
    CardLayout window = new CardLayout();
    Welcome welcome = new Welcome(this);
    SelectAlgo selectAlgo = new SelectAlgo(this);
    Fcfs fcfs = new Fcfs();
    Sjn sjn = new Sjn();
    Rr rr = new Rr();
    
    public MainWindow(){
        top.setBackground(PANEL_COLOR);
        bottom.setBackground(PANEL_COLOR);
        setTitle("CPU Scheduling Simulator");
        setIconImage(cpuIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(window);
        
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(PANEL_COLOR);
        
        bottom.setLayout(inputField);
        bottom.setPreferredSize(BOTTOM_PANEL_SIZE);
        
        top.add(selectAlgo);
        bottom.add(fcfs, "fcfs");
        bottom.add(sjn, "sjn");
        bottom.add(rr, "rr");
        inputPanel.add(top, BorderLayout.NORTH);
        inputPanel.add(bottom, BorderLayout.CENTER);

        add(welcome, "welcome");
        add(inputPanel, "input");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void showInputField(int cardNum){
        switch(cardNum){
            case 0: inputField.show(bottom,"fcfs"); break;
            case 1: inputField.show(bottom,"sjn"); break;
            case 2: inputField.show(bottom,"rr"); break;
        }
    }
    public void showWindow(String windowName){
        window.show(getContentPane(), windowName);
    }
    
    public static void main(String[] args) { new MainWindow(); }
}
