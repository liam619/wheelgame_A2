package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StoreValue;
import model.interfaces.GameEngine;

public class PlaceBetListener implements ActionListener {

    private GameEngine gameEngine;
    private StoreValue st;

    public PlaceBetListener(GameEngine gameEngine, StoreValue st) {
        this.gameEngine = gameEngine;
        this.st = st;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new PlacePlayerBet(gameEngine, st.getBetType(), st.getBetAmt());
    }
}
