package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayers implements ActionListener{
    
    private String playerName;
    private int initialPoints;
    
    public AddPlayers(String name, int points) {
        this.playerName = name;
        this.initialPoints = points;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

}
