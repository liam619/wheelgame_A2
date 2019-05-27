package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StoreValue;
import model.interfaces.GameEngine;
import view.NewPlayerForm;

public class NewPlayerListener implements ActionListener {

    private GameEngine gameEngine;
    private StoreValue st;
    private NewPlayerForm newPlayerForm;

    public NewPlayerListener(GameEngine gameEngine, StoreValue st) {
        this.gameEngine = gameEngine;
        this.st = st;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (st.getNewPlayerForm() == null) {
            newPlayerForm = new NewPlayerForm(gameEngine, st);
            st.setNewPlayerForm(newPlayerForm);
        }
    }
}
