package model;

import view.MenuBar;
import view.NewPlayerForm;
import view.PlayerGUI;
import view.StatusBar;
import view.SummaryPanel;
import view.ToolBar;
import view.WheelDisplay;

public class StoreValue {
    
    private PlayerGUI playerGUI;
    private NewPlayerForm newPlayerForm;
    
    private SummaryPanel summaryPanel;
    private StatusBar statusBar;
    private WheelDisplay wheelDisplay;
    private MenuBar menuBar;
    private ToolBar toolBar;
    
    /** Prevent multiple playerGUI **/
    public void setPlayerGUI(PlayerGUI playerGUI) {
        this.playerGUI = playerGUI;
    }
    
    public PlayerGUI getPlayerGUI() {
        return this.playerGUI;
    }
    
    /** Prevent multiple add new player form **/
    public void setNewPlayerForm(NewPlayerForm newPlayerForm) {
        this.newPlayerForm = newPlayerForm;
    }
    
    public NewPlayerForm getNewPlayerForm() {
        return this.newPlayerForm;
    }
    
    /** For multiplace usage **/
    public void setSummaryPanel(SummaryPanel summaryPanel) {
        this.summaryPanel = summaryPanel;
    }
    
    public SummaryPanel getSummaryPanel() {
        return this.summaryPanel;
    }
    
    public void setStatusBar(StatusBar statusBar) {
        this.statusBar = statusBar;
    }
    
    public StatusBar getStatusBar() {
        return this.statusBar;
    }

    public void setWheelDisplay(WheelDisplay wheelDisplay) {
        this.wheelDisplay = wheelDisplay;
    }
    
    public WheelDisplay getWheelDisplay() {
        return this.wheelDisplay;
    }
    
    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }
    
    public MenuBar getMenuBar() {
        return this.menuBar;
    }
    
    public void setToolBar(ToolBar toolBar) {
        this.toolBar = toolBar;
    }
    
    public ToolBar getToolBar() {
        return this.toolBar;
    }
}
