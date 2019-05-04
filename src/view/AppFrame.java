package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class AppFrame extends JFrame{

    public AppFrame() {
        super("Wheel Game");
        
        GameEngine gameEngine = new GameEngineImpl();
        
        MenuBar mb = new MenuBar();
        StatusBar sb = new StatusBar();
        ToolBar tb = new ToolBar(gameEngine);
        
        setJMenuBar(mb);
        add(tb, BorderLayout.NORTH);
        add(sb, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        setBounds(100, 100, 650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
