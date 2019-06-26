package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ExitListener;
import controller.NewPlayerListener;
import controller.RemovePlayerListener;
import controller.SpinListener;
import model.StoreValue;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

    private JMenuItem spin;
    private JMenuItem addPlayer;
    private JMenu removePlayer;
    
    private GameEngine gameEngine;
    private StoreValue storeValue;

    public MenuBar(GameEngine gameEngine, StoreValue storeValue) {
        this.gameEngine = gameEngine;
        this.storeValue = storeValue;

        JMenu fileMenu = new JMenu("File");
        
        /** Added Spin to menu item **/
        spin = new JMenuItem("Spin");
        spin.addActionListener(new SpinListener(gameEngine));
        
        /** Added Add Player to menu item **/
        addPlayer = new JMenuItem("Add Player");
        addPlayer.addActionListener(new NewPlayerListener(gameEngine, storeValue));
        
        /** Added Remove Player to menu item **/
        removePlayer = new JMenu("Remove Player");

        /** Just exit the application **/
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ExitListener());

        fileMenu.add(addPlayer);
        fileMenu.add(removePlayer);
        fileMenu.add(exit);

        add(fileMenu);
    }
    
    /** Disable menu item when spinning **/
    public void setDisableMenu() {
        addPlayer.setEnabled(false);
        removePlayer.setEnabled(false);
    }
    
    /** Enable menu item when not spinning **/
    public void setEnableMenu() {
        addPlayer.setEnabled(true);
        removePlayer.setEnabled(true);
    }

    /** Update menu item when there is new player **/
    public void redraw() {
        removePlayer.removeAll();
        removePlayer.revalidate();

        for (Player ply : gameEngine.getAllPlayers()) {
            JMenuItem item = new JMenuItem(ply.getPlayerName());
            item.addActionListener(new RemovePlayerListener(ply, storeValue, gameEngine));
            removePlayer.add(item);
        }
    }
}
