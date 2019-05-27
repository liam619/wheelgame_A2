package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StoreValue;
import model.interfaces.GameEngine;
import view.DisplayResult;

public class ResultActionListener implements ActionListener {
    
    private GameEngine gameEngine;
    private StoreValue storeValue;

    public ResultActionListener(StoreValue storeValue, GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.storeValue = storeValue;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        DisplayResult display = new DisplayResult(storeValue, gameEngine);
        display.initFrame();
    }
}
