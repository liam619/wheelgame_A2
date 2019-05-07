package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.StoreValue;
import model.enumeration.BetType;
import model.interfaces.Player;

public class PlayerItemListener implements ItemListener {
    
    private Player ply;
    private StoreValue st;

    public PlayerItemListener(Player ply, StoreValue st) {
        this.ply = ply;
        this.st = st;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            st.setBetType(ply, BetType.valueOf(e.getItem().toString()));
        }
    }
    
}
