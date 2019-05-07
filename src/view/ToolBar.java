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
    
    private StoreValue st = new StoreValue();
    
    public ToolBar(GameEngine gameEngine) {
        GridLayout layout = new GridLayout(0, 3, 20, 20);
        setLayout(layout);
        
        JButton spin = new JButton("SPIN!");
        
        JButton plyBtn = new JButton("Players");
        plyBtn.setActionCommand(VIEW_PLAYER);
        plyBtn.addActionListener(new PlayerActionListener(gameEngine, st));
        
        JButton lastWin = new JButton("Previous Result");
        
        add(spin);
        add(plyBtn);
        add(lastWin);
        
        setFloatable(false);
    }
}
