package controller;

import java.util.Collection;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class GetAllPlayer {
    
    private GameEngine gameEngine;
    
    public GetAllPlayer(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
    
    public Collection<Player> getAllPlayer() {
        
        return gameEngine.getAllPlayers();
    }

}
