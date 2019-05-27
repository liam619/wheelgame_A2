package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.ConstantVariable;

@SuppressWarnings("serial")
public class StatusBar extends JPanel implements ConstantVariable {
    
    private JLabel statusColor, statusNumber;

    public StatusBar() {
        
        /** Display the winning result at the bottom of frame **/
        statusColor = new JLabel(WIN_COLOR);
        statusNumber = new JLabel(WIN_NUMBER);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        statusColor.setBorder(border);
        statusNumber.setBorder(border);
        
        setLayout(new GridLayout(1, 3));
        add(statusColor);
        add(statusNumber);
    }
    
    public void setWinColor(String color) {
        this.statusColor.setText(WIN_COLOR.concat(color));
    }
    
    public void setWinNumber(String number) {
        statusNumber.setText(WIN_NUMBER.concat(number));
    }
}
