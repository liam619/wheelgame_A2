package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class AppFrame extends JFrame{
    
    private MenuBar menuBar;
    private StatusBar statusBar;
    private ToolBar toolBar;
    private WheelDisplay wheelDisplay;

    public AppFrame() {
        super("Wheel Game");
        
        GameEngine gameEngine = new GameEngineImpl();
        
        menuBar = new MenuBar();
        statusBar = new StatusBar();
        toolBar = new ToolBar(gameEngine);
        wheelDisplay = new WheelDisplay();
        
        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
        GameEngineCallbackGUI gameEngineGUI = new GameEngineCallbackGUI(statusBar);
        
        gameEngine.addGameEngineCallback(gameEngineGUI); // For GUI update
        gameEngine.addGameEngineCallback(gameEngineCallback); // For Console display result
        gameEngine.getWheelSlots();
        
        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.NORTH);
        add(wheelDisplay);
        add(statusBar, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
