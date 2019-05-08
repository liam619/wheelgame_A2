package model;

import java.util.HashMap;

import model.enumeration.BetType;
import model.interfaces.Player;

public class StoreValue {
    
    private HashMap<Player, BetType> playerBetType;
    private HashMap<Player, String> playerBetAmt;
    
    public StoreValue() {
        playerBetType = new HashMap<Player, BetType>();
        playerBetAmt = new HashMap<Player, String>();
    }
    
    public void setBetType(Player ply, BetType betType) {
        this.playerBetType.put(ply, betType);
    }
    
    public void setBetAmt(Player ply, String betAmt) {
        this.playerBetAmt.put(ply, betAmt);
    }
    
    public HashMap<Player, BetType> getBetType() {
        return this.playerBetType;
    }
    
    public HashMap<Player, String> getBetAmt() {
        return this.playerBetAmt;
    }
    
    public void clearBet() {
        this.playerBetAmt.clear();
        this.playerBetType.clear();
    }
}
