package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class AddPlayers implements ActionListener {

    private GameEngine gameEngine;
    private JTextField name;
    private JTextField point;
    private JFrame frame;
    private int idCount;

    public AddPlayers(JTextField name, JTextField point, JFrame frame, GameEngine gameEngine) {
        this.name = name;
        this.point = point;
        this.frame = frame;
        this.gameEngine = gameEngine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initialize(name.getText(), point.getText());
    }

    public void initialize(String name, String point) {
        idCount = gameEngine.getAllPlayers().size();

        if (name.length() > 0 && Integer.parseInt(point) > 0 && this.gameEngine != null) {
            idCount = (idCount != 0) ? ++idCount : 1;

            Player ply = new SimplePlayer(String.valueOf(idCount), name, Integer.parseInt(point));

            this.gameEngine.addPlayer(ply);
            
            frame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Name or Point cannot be empty!", "ERROR OCCUR!", 0);
        }
    }
}
