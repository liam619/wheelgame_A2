package view;

import javax.swing.SwingUtilities;

import model.StoreValue;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

    private StoreValue storeValue;

    public GameEngineCallbackGUI(StoreValue storeValue) {
        this.storeValue = storeValue;
    }

    @Override
    public void nextSlot(Slot slot, GameEngine engine) {
        /** Disable all the button and menu **/
        storeValue.getToolBar().setDisableBtn();
        storeValue.getMenuBar().setDisableMenu();
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                storeValue.getWheelDisplay().redraw(slot.getPosition());
                updateStatusbar(slot); // Run like spinning machine!
            }
        });
    }

    @Override
    public void result(Slot winningSlot, GameEngine engine) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /** Enable all the button and menu **/
                storeValue.getToolBar().setEnableBtn();
                storeValue.getMenuBar().setEnableMenu();

                /** Draw the winning slot **/
                storeValue.getWheelDisplay().redraw(winningSlot.getPosition());
                engine.calculateResult(winningSlot);
                
                /** Update the frame (Summary and Status bar) **/
                storeValue.getSummaryPanel().displayPlayerSummary(engine);
                updateStatusbar(winningSlot);
                resetBet(engine);
            }
        });
    }

    /** Update Summary panel with all the player info **/
    private void resetBet(GameEngine engine) {
        for (Player ply : engine.getAllPlayers()) {
            ply.resetBet();
        }
    }

    /** Update the Status bar with the winning slot **/
    private void updateStatusbar(Slot slot) {
        storeValue.getStatusBar().setWinColor(slot.getColor().toString());
        storeValue.getStatusBar().setWinNumber(String.valueOf(slot.getNumber()));
        storeValue.getStatusBar().setWinPosition(String.valueOf(slot.getPosition()));
    }
}
