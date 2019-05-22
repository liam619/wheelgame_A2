package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ConstantVariable;
import model.interfaces.GameEngine;

public class SpinListener implements ActionListener, ConstantVariable {

    private GameEngine gameEngine;

    public SpinListener(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread() {
            public void run() {
                gameEngine.spin(INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);
            }
        }.start();
    }
}
