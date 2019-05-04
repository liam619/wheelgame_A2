package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar{
    
    public ToolBar(GameEngine gameEngine) {
        GridLayout layout = new GridLayout(0, 3, 20, 20);
        setLayout(layout);
        
        JButton spin = new JButton("SPIN!");
        
        JButton players = new JButton("Players");
        players.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerGUI pg = new PlayerGUI(gameEngine);
                pg.setVisible(true);
            }
        });
        
        JButton lastWin = new JButton("Previous Result");
        
        add(spin);
        add(players);
        add(lastWin);
        
        setFloatable(false);
    }
}
