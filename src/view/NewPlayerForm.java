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

public class NewPlayerForm implements ConstantVariable {

    public NewPlayerForm(GameEngine gameEngine, PlayerGUI playerGUI) {
        JFrame jframe = new JFrame();
        JPanel contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        infoPanel.add(new JLabel("Player Name:"));
        JTextField nameJTF = new JTextField();
        infoPanel.add(nameJTF);
        infoPanel.add(new JLabel("Initial Points:"));
        JTextField pointJTF = new JTextField();
        infoPanel.add(pointJTF);
        
        pointJTF.addKeyListener(new PlayerKeyListener());

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new AddPlayers(nameJTF, pointJTF, jframe, playerGUI, gameEngine));
        btnPanel.add(okBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setActionCommand(CLOSE_FRAME);
        cancelBtn.addActionListener(new PlayerActionListener(jframe));
        btnPanel.add(cancelBtn);
        
        contentPanel.add(infoPanel);
        contentPanel.add(btnPanel);
        jframe.add(contentPanel);

        jframe.pack();
        jframe.setTitle(ADDNEWPLAYER_TITLE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
    }
}
