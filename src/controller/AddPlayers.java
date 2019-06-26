package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.ConstantVariable;
import model.SimplePlayer;
import model.StoreValue;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class AddPlayers implements ActionListener, ConstantVariable {

    private GameEngine gameEngine;
    private JTextField nameJTF;
    private JTextField pointJTF;
    private JFrame jframe;
    private int idCount;
    private StoreValue storeValue;

    public AddPlayers(JTextField nameJTF, JTextField pointJTF, JFrame jframe, StoreValue storeValue, GameEngine gameEngine) {
        this.nameJTF = nameJTF;
        this.pointJTF = pointJTF;
        this.jframe = jframe;
        this.gameEngine = gameEngine;
        this.storeValue = storeValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initialize(nameJTF.getText(), pointJTF.getText());
    }

    private void initialize(String name, String point) {
        idCount = gameEngine.getAllPlayers().size();

        if (name.length() > 0 && point.length() > 0) {
            if (Integer.parseInt(point) > 0 && this.gameEngine != null) {
                idCount = (idCount != 0) ? ++idCount : 1;

                Player ply = new SimplePlayer(String.valueOf(idCount), name, Integer.parseInt(point));

                this.gameEngine.addPlayer(ply); // Still add player even the form is closed.

                /** If playerGUI form is close, there is no need to redraw be called **/
                if (storeValue.getPlayerGUI() != null) {
                    storeValue.getPlayerGUI().redraw();
                    storeValue.setNewPlayerForm(null);
                }

                jframe.setVisible(false); // Close the add player form after add new player.
                
                /** Update Menu bar when new player added **/
                storeValue.getMenuBar().redraw();
                storeValue.setNewPlayerForm(null); // Prevent multiple frame
                storeValue.getSummaryPanel().displayPlayerSummary(gameEngine);
                
            }
        } else {
            JOptionPane.showMessageDialog(null, ADD_NEW_PLAYER_MSG, ADDNEWPLAYER_ERROR, 0);
        }
    }
}
