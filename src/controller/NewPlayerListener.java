package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.NewPlayerForm;
import view.PlayerGUI;

public class NewPlayerListener implements ActionListener {
    
    private GameEngine gameEngine;
    private PlayerGUI playerGUI;

    public NewPlayerListener(GameEngine gameEngine, PlayerGUI playerGUI) {
        this.gameEngine = gameEngine;
        this.playerGUI = playerGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new NewPlayerForm(gameEngine, playerGUI);
    }
}
