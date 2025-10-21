package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Table extends JPanel{
    JLabel name;
    public Table(String str){
        name = new JLabel(str);
        name.setFont(new Font("Roboto", Font.BOLD, 13));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        setBorder(new LineBorder(Color.BLACK));
        setPreferredSize(new Dimension(117, 45));
        setBackground(Color.white);
        setLayout(new BorderLayout());
        add(name, BorderLayout.CENTER);
    }
}
