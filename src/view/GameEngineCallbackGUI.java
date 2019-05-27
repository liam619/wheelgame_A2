package view;

import java.util.Collection;

import javax.swing.SwingUtilities;

import model.StoreValue;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

    private StatusBar statusBar;
    private StoreValue storeValue;
    private WheelDisplay wheelDisplay;

    public GameEngineCallbackGUI(StatusBar statusBar, StoreValue storeValue, WheelDisplay wheelDisplay) {
        this.statusBar = statusBar;
        this.storeValue = storeValue;
        this.wheelDisplay = wheelDisplay;
    }

    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                wheelDisplay.setDegree(slot.getPosition());
                wheelDisplay.repaint();
            }
        });
    }

    @Override
    public void result(Slot winningSlot, GameEngine engine) {
        wheelDisplay.setDegree(winningSlot.getPosition());
        wheelDisplay.repaint();
        
        storeValue.setWinningSlot(winningSlot);
        
        DisplayResult display = new DisplayResult(storeValue, engine);

        statusBar.setWinColor(String.valueOf(winningSlot.getColor()));
        statusBar.setWinNumber(String.valueOf(winningSlot.getNumber()));

        engine.calculateResult(winningSlot);

        display.initFrame();
        resetBet(engine.getAllPlayers());
    }

    private void resetBet(Collection<Player> plyList) {

        if (plyList.size() > 0) {
            for (Player ply : plyList) {
                ply.resetBet();
            }
        }
    }
}
