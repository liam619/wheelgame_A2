package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AddPlayers;

public class PlayerGUI extends JFrame {

    private String playerName;
    private int playerInitialPoints;

    public PlayerGUI() {
        
        JPanel contentPanel = new JPanel(new GridLayout(2,0));
        JPanel panel1 = new JPanel(new GridLayout(2,2));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        panel1.add(new JLabel("Player Name:"));
        JTextField name = new JTextField();
        panel1.add(name);
        panel1.add(new JLabel("Initial Points:"));
        JTextField point = new JTextField();
        panel1.add(point);
        
        this.playerName = name.getText();
        this.playerInitialPoints = Integer.parseInt(point.getText());
        
        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new AddPlayers(playerName, playerInitialPoints));
        panel2.add(okBtn);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel2.add(cancelBtn);
        
        contentPanel.add(panel1);
        contentPanel.add(panel2);
        
        add(contentPanel);
        setResizable(false);
        setBounds(100,100,400,150);
        
    }
}
