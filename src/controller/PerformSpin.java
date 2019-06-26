package controller;

import model.ConstantVariable;
import model.interfaces.GameEngine;

public class PerformSpin implements ConstantVariable {

    /** Perform spin **/
    public PerformSpin(GameEngine gameEngine) {
        new Thread() {
            public void run() {
                gameEngine.spin(INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);
            }
        }.start();
    }
}
