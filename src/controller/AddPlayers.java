package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.PlayerGUI;

public class AddPlayers implements ActionListener {

    private GameEngine gameEngine;
    private JTextField nameJTF;
    private JTextField pointJTF;
    private JFrame jframe;
    private int idCount;
    private PlayerGUI playerGUI;

    public AddPlayers(JTextField nameJTF, JTextField pointJTF, JFrame jframe, PlayerGUI playerGUI, GameEngine gameEngine) {
        this.nameJTF = nameJTF;
        this.pointJTF = pointJTF;
        this.jframe = jframe;
        this.gameEngine = gameEngine;
        this.playerGUI = playerGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initialize(nameJTF.getText(), pointJTF.getText());
    }

    public void initialize(String name, String point) {
        idCount = gameEngine.getAllPlayers().size();

        if (name.length() > 0 && Integer.parseInt(point) > 0 && this.gameEngine != null) {
            idCount = (idCount != 0) ? ++idCount : 1;

            Player ply = new SimplePlayer(String.valueOf(idCount), name, Integer.parseInt(point));

            this.gameEngine.addPlayer(ply);
            
            playerGUI.redraw();
            jframe.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Name or Point cannot be empty!", "ERROR OCCUR!", 0);
        }
    }
}
