package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StatusBar extends JPanel {
    
    private JLabel status1, status2, status3;

    public StatusBar() {
        
        status1 = new JLabel("Winner Name : ");
        status2 = new JLabel("Winning Slot : ");
        status3 = new JLabel("Reward : ");
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        status1.setBorder(border);
        status2.setBorder(border);
        status3.setBorder(border);
        
        setLayout(new GridLayout(1, 3));
        add(status1);
        add(status2);
        add(status3);
    }
}
