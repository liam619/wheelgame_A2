package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.Slot;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {
    
    private JLabel statusColor, statusNumber;

    public StatusBar() {
        
        statusColor = new JLabel("Winning Color : ");
        statusNumber = new JLabel("Winning Number : ");
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        statusColor.setBorder(border);
        statusNumber.setBorder(border);
        
        setLayout(new GridLayout(1, 3));
        add(statusColor);
        add(statusNumber);
    }
    
    public void setWinColor(String color) {
        System.out.println(color);
        this.statusColor.setText("Winning Color : " + color);
    }
    
    public void setWinNumber(String number) {
        statusNumber.setText("Winning Number : " + number);
    }
}
