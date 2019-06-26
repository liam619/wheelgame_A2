package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StoreValue;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.PlayerGUI;

public class RemovePlayerListener implements ActionListener {

    private Player player;
    private GameEngine gameEngine;
    private PlayerGUI playerGUI;
    private StoreValue storeValue;

    public RemovePlayerListener(Player player, StoreValue storeValue, GameEngine gameEngine, PlayerGUI playerGUI) {
        this.player = player;
        this.gameEngine = gameEngine;
        this.playerGUI = playerGUI;
        this.storeValue = storeValue;
    }

    public RemovePlayerListener(Player player, StoreValue storeValue, GameEngine gameEngine) {
        this.player = player;
        this.gameEngine = gameEngine;
        this.storeValue = storeValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        gameEngine.removePlayer(player);
        storeValue.getSummaryPanel().displayPlayerSummary(gameEngine);
        
        /** Update Menubar after remove place **/
        storeValue.getMenuBar().redraw();

        /** Update the Player GUI after removed **/
        if (playerGUI != null) {
            playerGUI.redraw();
        }
    }
}
