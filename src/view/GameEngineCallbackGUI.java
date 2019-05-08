package view;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback{

    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("next slot");
            }
        });
    }

    @Override
    public void result(Slot winningSlot, GameEngine engine) {
        DisplayResult dr = new DisplayResult(winningSlot, engine);
        System.out.println("result");
        
        engine.calculateResult(winningSlot);
        
        dr.initFrame();
    }
}
