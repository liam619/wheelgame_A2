package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StoreValue;
import model.interfaces.GameEngine;
import view.PlayerGUI;

public class PlayerActionListener implements ActionListener {

    private GameEngine gameEngine;
    private StoreValue st;
    private PlayerGUI playerGUI;

    public PlayerActionListener(GameEngine gameEngine, StoreValue st) {
        this.gameEngine = gameEngine;
        this.st = st;
    }

    /** Display the Player GUI **/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (st.getPlayerGUI() == null) {
            playerGUI = new PlayerGUI(gameEngine, st);
            st.setPlayerGUI(playerGUI);
        }
    }
}
