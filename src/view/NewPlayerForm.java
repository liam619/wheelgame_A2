package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AddPlayers;
import controller.FrameListener;
import controller.PlayerKeyListener;
import model.ConstantVariable;
import model.StoreValue;
import model.interfaces.GameEngine;

public class NewPlayerForm implements ConstantVariable {

    /** The add new player form **/
    public NewPlayerForm(GameEngine gameEngine, StoreValue st) {
        JFrame jframe = new JFrame();
        
        JPanel contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        infoPanel.add(new JLabel("Player Name:"));
        JTextField nameJTF = new JTextField();
        
        infoPanel.add(new JLabel("Initial Points:"));
        JTextField pointJTF = new JTextField();
        pointJTF.addKeyListener(new PlayerKeyListener()); // Prevent user key in not valid character except number.

        /** Add the player **/
        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new AddPlayers(nameJTF, pointJTF, jframe, st, gameEngine));
        btnPanel.add(okBtn);

        /** Change of mind **/
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new FrameListener(jframe, st));
        btnPanel.add(cancelBtn);
        
        infoPanel.add(nameJTF);
        infoPanel.add(pointJTF);
        
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
