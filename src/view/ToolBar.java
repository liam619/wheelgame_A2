package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.PlayerActionListener;
import controller.SpinListener;
import model.ConstantVariable;
import model.StoreValue;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar implements ConstantVariable {
    
    public ToolBar(GameEngine gameEngine, StoreValue storeValue) {
        setLayout(new GridLayout(0, 3, 20, 20));
        
        JButton spinBtn = new JButton("SPIN!");
        spinBtn.addActionListener(new SpinListener(gameEngine));
        
        JButton plyBtn = new JButton("Players");
        plyBtn.addActionListener(new PlayerActionListener(gameEngine, storeValue));
        
        JButton lastWinBtn = new JButton("Previous Result");
        
        add(spinBtn);
        add(plyBtn);
        add(lastWinBtn);
        
        setFloatable(false);
    }
}
