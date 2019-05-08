package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.ConstantVariable;
import model.GameEngineImpl;
import model.StoreValue;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class AppFrame extends JFrame implements ConstantVariable {

    private MenuBar menuBar;
    private StatusBar statusBar;
    private ToolBar toolBar;
    private WheelDisplay wheelDisplay;
    private StoreValue storeValue;

    public AppFrame() {
        super(APPFRAME_TITLE);

        GameEngine gameEngine = new GameEngineImpl();

        menuBar = new MenuBar();
        statusBar = new StatusBar();
        storeValue = new StoreValue();
        toolBar = new ToolBar(gameEngine, storeValue);
        wheelDisplay = new WheelDisplay();

        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
        GameEngineCallbackGUI gameEngineGUI = new GameEngineCallbackGUI(statusBar, storeValue);

        gameEngine.addGameEngineCallback(gameEngineGUI); // For GUI update
        gameEngine.addGameEngineCallback(gameEngineCallback); // For Console display result
        gameEngine.getWheelSlots();

        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.NORTH);
        add(wheelDisplay, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
