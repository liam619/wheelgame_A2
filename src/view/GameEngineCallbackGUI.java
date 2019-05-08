package view;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback{

    private StatusBar statusBar;
    
    public GameEngineCallbackGUI(StatusBar statusBar) {
        this.statusBar = statusBar;
    }

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
        DisplayResult display = new DisplayResult(winningSlot, engine);
        
        statusBar.setWinColor(String.valueOf(winningSlot.getColor()));
        statusBar.setWinNumber(String.valueOf(winningSlot.getNumber()));
        
        engine.calculateResult(winningSlot);
        
        display.initFrame();
    }
}
