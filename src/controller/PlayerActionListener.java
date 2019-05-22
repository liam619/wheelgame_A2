package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StoreValue;
import model.interfaces.GameEngine;
import view.PlayerGUI;

public class PlayerActionListener implements ActionListener {

    private GameEngine gameEngine;
    private StoreValue st;

    public PlayerActionListener(GameEngine gameEngine, StoreValue st) {
        this.gameEngine = gameEngine;
        this.st = st;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new PlayerGUI(gameEngine, st);
    }
}
