package controller;

import java.util.HashMap;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlacePlayerBet {

//    private HashMap<Player, BetType> playerBetType = new HashMap<Player, BetType>();
//    private HashMap<Player, String> playerBetAmt = new HashMap<Player, String>();

    public void init(GameEngine gameEngine, HashMap<Player, BetType> playerBetType, HashMap<Player, String> playerBetAmt) {

        boolean verify = false;
        
        System.out.println("TYPE : " + playerBetType.size() +"| AMT : "+ playerBetAmt.size());
        
        for (Player ply : playerBetType.keySet()) {

            int betAmt = (playerBetAmt.get(ply) != null) ? Integer.parseInt(playerBetAmt.get(ply)) : 0;
//            System.out.println(betAmt +"|"+ verify);
            if (betAmt > 0) {
                verify = gameEngine.placeBet(ply, betAmt, playerBetType.get(ply));
            }
        }
        
        if (verify) {
            JOptionPane.showMessageDialog(null, "All bet placed!", "Success.", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient fund!", "Failed!", 0);
        }
    }

//    public void setBetType(Player ply, BetType betType) {
//        this.playerBetType.put(ply, betType);
//    }
//    
//    public void setBetAmt(Player ply, String betAmt) {
//        this.playerBetAmt.put(ply, betAmt);
//    }
}
