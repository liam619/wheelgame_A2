package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private SummaryPanel summaryPanel;
    private StoreValue storeValue;

    public AppFrame() {
        super(APPFRAME_TITLE);

        /** Calculate the minimum size of frame **/
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (d.height * MIN_HEIGHT);
        int width = (int) (d.width * MIN_WIDTH);

        GameEngine gameEngine = new GameEngineImpl();

        statusBar = new StatusBar();
        storeValue = new StoreValue();
        summaryPanel = new SummaryPanel();
        wheelDisplay = new WheelDisplay(gameEngine);

        toolBar = new ToolBar(gameEngine, storeValue);
        menuBar = new MenuBar(gameEngine, storeValue);

        storeValue.setSummaryPanel(summaryPanel);
        storeValue.setStatusBar(statusBar);
        storeValue.setWheelDisplay(wheelDisplay);
        storeValue.setMenuBar(menuBar);
        storeValue.setToolBar(toolBar);

        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
        GameEngineCallbackGUI gameEngineGUI = new GameEngineCallbackGUI(storeValue);

        gameEngine.addGameEngineCallback(gameEngineGUI); // For GUI update
        gameEngine.addGameEngineCallback(gameEngineCallback); // For Console display
        gameEngine.getWheelSlots();

        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.NORTH);
        add(wheelDisplay, BorderLayout.CENTER);

        JPanel groupSouth = new JPanel(new BorderLayout());
        groupSouth.add(summaryPanel, BorderLayout.NORTH);
        groupSouth.add(statusBar, BorderLayout.SOUTH);

        add(groupSouth, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(width, height)); // Minimum size of the frame
    }
}
