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

import controller.BetTypeListener;
import controller.FrameListener;
import controller.NewPlayerListener;
import controller.PlaceBetListener;
import controller.PlayerKeyListener;
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
    private StoreValue st;

    public PlayerGUI(GameEngine gameEngine, StoreValue st) {
        this.gameEngine = gameEngine;
        this.st = st;

        jframe = new JFrame();
        contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton addNewPlayerBtn = new JButton("Add New Player");
        addNewPlayerBtn.addActionListener(new NewPlayerListener(gameEngine, this));

        JButton setBetBtn = new JButton("Place Bet");
        setBetBtn.addActionListener(new PlaceBetListener(gameEngine, st));

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new FrameListener(jframe));

        btnPanel.add(addNewPlayerBtn);
        btnPanel.add(setBetBtn);
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
                comboBox.addItemListener(new BetTypeListener(ply, st));

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
        jframe.pack();
        jframe.setLocationRelativeTo(null);
    }
}
