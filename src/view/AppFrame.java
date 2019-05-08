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
        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
        GameEngineCallbackGUI gameEngineGUI = new GameEngineCallbackGUI();
        
        MenuBar mb = new MenuBar();
        StatusBar sb = new StatusBar();
        ToolBar tb = new ToolBar(gameEngine);
        WheelDisplay wd = new WheelDisplay();
        
        gameEngine.addGameEngineCallback(gameEngineGUI); // For GUI update
        gameEngine.addGameEngineCallback(gameEngineCallback); // For Console display result
        gameEngine.getWheelSlots();
        
        setJMenuBar(mb);
        add(tb, BorderLayout.NORTH);
        add(wd, BorderLayout.CENTER);
        add(sb, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        setSize(700, 700);
//        setMinimumSize(getSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
