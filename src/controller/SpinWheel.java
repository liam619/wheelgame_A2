package controller;

import model.ConstantVariable;
import model.interfaces.GameEngine;

public class SpinWheel implements ConstantVariable {
    
    public SpinWheel(GameEngine gameEngine) {
        
        new Thread() {
            public void run() {
                gameEngine.spin(INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);
            }
        }.start();
    }
}
