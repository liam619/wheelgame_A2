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

    JPanel contentPanel;
    JPanel listPlayerPanel;
    
    public PlayerGUI(GameEngine gameEngine, StoreValue st) {
        JFrame jframe = new JFrame();
        contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        initPlayerTable(gameEngine, st);

        JButton addNewPlayerBtn = new JButton("Add New Player");
        addNewPlayerBtn.setActionCommand(NEW_PLAYER);
        addNewPlayerBtn.addActionListener(new PlayerActionListener(gameEngine, st));
        
        JButton setBetBtn = new JButton("Place Bet");
        setBetBtn.setActionCommand(PLACE_BET);
        setBetBtn.addActionListener(new PlayerActionListener(gameEngine, st));
        
        JButton closeBtn = new JButton("Close");
        closeBtn.setActionCommand(CLOSE_FRAME);
        closeBtn.addActionListener(new PlayerActionListener(jframe));
        
        panel.add(addNewPlayerBtn);
        panel.add(setBetBtn);
        panel.add(closeBtn);

        contentPanel.add(panel);
        jframe.add(contentPanel);
        jframe.setVisible(true);
        jframe.setTitle("Player GUI");
        // setResizable(false);
        jframe.setBounds(100, 100, 800, 90);
    }

    public void initPlayerTable(GameEngine gameEngine, StoreValue st) {
        
        Collection<Player> playerList = gameEngine.getAllPlayers();

        listPlayerPanel = new JPanel();

        if (playerList.size() > 0) {
            listPlayerPanel.setLayout(new GridLayout(playerList.size(), 8));

            for (Player ply : playerList) {
                listPlayerPanel.add(new JLabel("ID : " + ply.getPlayerId()));
                listPlayerPanel.add(new JLabel("Name : " + ply.getPlayerName()));
                listPlayerPanel.add(new JLabel("Points : " + String.valueOf(ply.getPoints())));

                listPlayerPanel.add(new JLabel("Bet type : "));
                JComboBox<BetType> comboBox = new JComboBox<BetType>(BetType.values());
                comboBox.setSelectedItem(ply.getBetType());
                listPlayerPanel.add(comboBox);
                comboBox.addItemListener(new PlayerItemListener(ply, st));

                listPlayerPanel.add(new JLabel("Place bet : "));
                JTextField jTextF = new JTextField();
                jTextF.setText(String.valueOf(ply.getBet()));
                listPlayerPanel.add(jTextF);
                jTextF.addKeyListener(new PlayerKeyListener(ply, jTextF, st));
            }
        } else {
            listPlayerPanel.add(new JLabel("No player in game."));
        }

        contentPanel.add(listPlayerPanel);
    }
}
