package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.PlayerActionListener;
import model.ConstantVariable;
import model.StoreValue;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar implements ConstantVariable {
    
    public ToolBar(GameEngine gameEngine, StoreValue storeValue) {
        setLayout(new GridLayout(0, 3, 20, 20));
        
        JButton spinBtn = new JButton("SPIN!");
        spinBtn.setActionCommand(SPIN_WHEEL);
        spinBtn.addActionListener(new PlayerActionListener(gameEngine, storeValue));
        
        JButton plyBtn = new JButton("Players");
        plyBtn.setActionCommand(VIEW_PLAYER);
        plyBtn.addActionListener(new PlayerActionListener(gameEngine, storeValue));
        
        JButton lastWinBtn = new JButton("Previous Result");
        
        add(spinBtn);
        add(plyBtn);
        add(lastWinBtn);
        
        setFloatable(false);
    }
}
