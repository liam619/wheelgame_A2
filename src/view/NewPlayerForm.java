package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AddPlayers;
import controller.PlayerActionListener;
import controller.PlayerKeyListener;
import model.ConstantVariable;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class NewPlayerForm extends JFrame implements ConstantVariable {

    public NewPlayerForm(GameEngine gameEngine) {
        JFrame jframe = new JFrame();
        JPanel contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel panel1 = new JPanel(new GridLayout(2, 2));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        panel1.add(new JLabel("Player Name:"));
        JTextField name = new JTextField();
        panel1.add(name);
        panel1.add(new JLabel("Initial Points:"));
        JTextField point = new JTextField();
        panel1.add(point);
        
        point.addKeyListener(new PlayerKeyListener(null, null, null));

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new AddPlayers(name, point, jframe, gameEngine));
        panel2.add(okBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setActionCommand(CLOSE_FRAME);
        cancelBtn.addActionListener(new PlayerActionListener(jframe));
        panel2.add(cancelBtn);
        
        contentPanel.add(panel1);
        contentPanel.add(panel2);

        jframe.setVisible(true);
        jframe.add(contentPanel);
        jframe.setResizable(false);
        jframe.setBounds(100, 100, 400, 150);
    }
}
