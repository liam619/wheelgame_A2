package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.StoreValue;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlaceBetListener implements ActionListener {
    
    private Player player;
    private GameEngine gameEngine;
    private StoreValue storeValue;
   
    private JTextField betAmount;
    private JComboBox<BetType> betType;
   
    public PlaceBetListener(Player player, GameEngine gameEngine, JComboBox<BetType> betType, JTextField betAmount, StoreValue storeValue) {
        this.player = player;
        this.gameEngine = gameEngine;
        this.betType = betType;
        this.betAmount = betAmount;
        this.storeValue = storeValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateBet();
    }

    private void validateBet() {
        boolean valid = false;
        
        /** Validate before place bet **/
        if (betAmount.getText().length() > 0 && betType.getSelectedItem() != null) {
            if (Integer.valueOf(betAmount.getText()) > 0) {
                valid = gameEngine.placeBet(player, Integer.valueOf(betAmount.getText()), BetType.valueOf(betType.getSelectedItem().toString()));
                
                if(valid) {
                    JOptionPane.showMessageDialog(null, "Bet Placed.", "Success.", 1);
                    
                    prepareForSpin(gameEngine);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient points!", "Failed.", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bet amount cannot be 0!", "Failed.", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid bet!", "Failed.", 0);
        }
    }
    
    /** Check if all player place bet **/
    private void prepareForSpin(GameEngine gameEngine) {
        int count = 0;
        for(Player ply : gameEngine.getAllPlayers()) {
            if(ply.getBet() > 0) {
                count++;
            }
        }
        
        /** Auto spin happen when count match allPlayer size **/
        if(count == gameEngine.getAllPlayers().size()) {
            new PerformSpin(gameEngine);
            storeValue.getPlayerGUI().closeFrame();
            storeValue.setPlayerGUI(null);
        }
    }
}
