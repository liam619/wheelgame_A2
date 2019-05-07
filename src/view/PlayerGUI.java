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

import controller.PlayerActionListener;
import controller.PlayerItemListener;
import controller.PlayerKeyListener;
import model.ConstantVariable;
import model.StoreValue;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlayerGUI implements ConstantVariable {

    private JPanel plyTablePanel;
    private JPanel contentPanel;
    private GameEngine gameEngine;
    private StoreValue st;
    
    public PlayerGUI(GameEngine gameEngine, StoreValue st) {
        this.gameEngine = gameEngine;
        this.st = st;
        
        JFrame jframe = new JFrame();
        contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton addNewPlayerBtn = new JButton("Add New Player");
        addNewPlayerBtn.setActionCommand(NEW_PLAYER);
        addNewPlayerBtn.addActionListener(new PlayerActionListener(gameEngine, st, this));
        
        JButton setBetBtn = new JButton("Place Bet");
        setBetBtn.setActionCommand(PLACE_BET);
        setBetBtn.addActionListener(new PlayerActionListener(gameEngine, st));
        
        JButton closeBtn = new JButton("Close");
        closeBtn.setActionCommand(CLOSE_FRAME);
        closeBtn.addActionListener(new PlayerActionListener(jframe));
        
        btnPanel.add(addNewPlayerBtn);
        btnPanel.add(setBetBtn);
        btnPanel.add(closeBtn);
        
        contentPanel.add(initPlayerTable());
        contentPanel.add(btnPanel);
        
        jframe.add(contentPanel);
        jframe.setVisible(true);
        jframe.setTitle("Player GUI");
        // setResizable(false);
        jframe.setBounds(100, 100, 800, 90);
    }

    public JPanel initPlayerTable() {
        plyTablePanel = new JPanel();
        Collection<Player> playerList = gameEngine.getAllPlayers();

        if (playerList.size() > 0) {
            plyTablePanel.setLayout(new GridLayout(playerList.size(), 8));

            for (Player ply : playerList) {
                plyTablePanel.add(new JLabel("ID : " + ply.getPlayerId()));
                plyTablePanel.add(new JLabel("Name : " + ply.getPlayerName()));
                plyTablePanel.add(new JLabel("Points : " + String.valueOf(ply.getPoints())));

                plyTablePanel.add(new JLabel("Bet type : "));
                JComboBox<BetType> comboBox = new JComboBox<BetType>(BetType.values());
                comboBox.setSelectedItem(ply.getBetType());
                plyTablePanel.add(comboBox);
                comboBox.addItemListener(new PlayerItemListener(ply, st));

                plyTablePanel.add(new JLabel("Place bet : "));
                JTextField jTextF = new JTextField();
                jTextF.setText(String.valueOf(ply.getBet()));
                plyTablePanel.add(jTextF);
                jTextF.addKeyListener(new PlayerKeyListener(ply, jTextF, st));
            }
        } else {
            plyTablePanel.add(new JLabel("No player in game."));
        }
        
        return plyTablePanel;
    }
    
    public void redraw() {
        contentPanel.remove(plyTablePanel);
        contentPanel.add(initPlayerTable(), 0, 0);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
