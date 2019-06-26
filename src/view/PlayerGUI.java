package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.FrameListener;
import controller.NewPlayerListener;
import controller.PlaceBetListener;
import controller.PlayerKeyListener;
import controller.RemovePlayerListener;
import model.ConstantVariable;
import model.StoreValue;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlayerGUI implements ConstantVariable {

    private JFrame jframe;
    private JPanel plyTablePanel;
    private JPanel contentPanel;
    
    private GameEngine gameEngine;
    private StoreValue storeValue;

    /** Main frame of the player view **/
    public PlayerGUI(GameEngine gameEngine, StoreValue storeValue) {
        this.gameEngine = gameEngine;
        this.storeValue = storeValue;

        jframe = new JFrame();
        contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        /** Allow add new player **/
        JButton addNewPlayerBtn = new JButton("Add New Player");
        addNewPlayerBtn.addActionListener(new NewPlayerListener(gameEngine, storeValue));

        /** Close the current frame **/
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new FrameListener(jframe, storeValue));

        btnPanel.add(addNewPlayerBtn);
        btnPanel.add(closeBtn);

        contentPanel.add(initPlayerTable());
        contentPanel.add(btnPanel);
        jframe.add(contentPanel);

        jframe.pack();
        jframe.setVisible(true);
        jframe.setTitle(PLAYERGUI_TITLE);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
    }

    /** After add player, will display this part, for bet type, bet amount and player info with removable function **/
    public JPanel initPlayerTable() {
        plyTablePanel = new JPanel();
        Collection<Player> playerList = gameEngine.getAllPlayers();

        if (playerList.size() > 0) {
            plyTablePanel.setLayout(new GridLayout(playerList.size(), 10));

            for (Player ply : playerList) {
                plyTablePanel.add(new JLabel("ID : " + ply.getPlayerId()));
                plyTablePanel.add(new JLabel("Name : "));
                plyTablePanel.add(new JLabel(ply.getPlayerName()));
                plyTablePanel.add(new JLabel("Points : "));
                plyTablePanel.add(new JLabel(String.valueOf(ply.getPoints())));

                plyTablePanel.add(new JLabel("Bet type : "));
                JComboBox<BetType> comboBox = new JComboBox<BetType>(BetType.values());
                comboBox.setSelectedItem(ply.getBetType());
                plyTablePanel.add(comboBox);

                plyTablePanel.add(new JLabel("Place bet : "));
                JTextField jTextF = new JTextField();
                jTextF.setText(String.valueOf(ply.getBet()));
                plyTablePanel.add(jTextF);
                jTextF.addKeyListener(new PlayerKeyListener());
                
                JButton betBtn = new JButton("BET");
                betBtn.addActionListener(new PlaceBetListener(ply, gameEngine, comboBox, jTextF, storeValue));
                plyTablePanel.add(betBtn);
                
                JButton removeBtn = new JButton("REMOVE");
                removeBtn.addActionListener(new RemovePlayerListener(ply, this.storeValue, gameEngine, this));
                plyTablePanel.add(removeBtn);
            }
        } else {
            plyTablePanel.add(new JLabel("No player in game."));
        }

        return plyTablePanel;
    }

    /** Redraw after add or remove player **/
    public void redraw() {
        contentPanel.remove(plyTablePanel);
        contentPanel.add(initPlayerTable(), 0, 0);
        contentPanel.revalidate();
        contentPanel.repaint();
        jframe.pack();
        jframe.setLocationRelativeTo(null);
    }
    
    /** Close this frame upon all player placed bet **/
    public void closeFrame() {
        jframe.setVisible(false);
    }
}
