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
    
    private JButton spinBtn;
    private JButton plyBtn;
    
    public ToolBar(GameEngine gameEngine, StoreValue storeValue) {
        setLayout(new GridLayout(0, 2, GAP, GAP));
        
        /** Spin button **/
        spinBtn = new JButton("SPIN!");
        spinBtn.addActionListener(new SpinListener(gameEngine));
        
        /** Player related such as add / bet / remove view **/
        plyBtn = new JButton("View Players");
        plyBtn.addActionListener(new PlayerActionListener(gameEngine, storeValue));
        
        add(spinBtn);
        add(plyBtn);
    }
    
    /** Disable all the button upon spin **/
    public void setDisableBtn() {
        spinBtn.setEnabled(false);
        plyBtn.setEnabled(false);
    }
    
    /** Enable all the button when not spin **/
    public void setEnableBtn() {
        spinBtn.setEnabled(true);
        plyBtn.setEnabled(true);
    }
}
