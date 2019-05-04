package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AddPlayers;
import controller.GetAllPlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlayerGUI extends JFrame {

    JPanel contentPanel;
    JPanel listPlayerPanel;

    public PlayerGUI(GameEngine gameEngine) {
        contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        initPlayerTable(gameEngine);

        JButton addNewPlayerBtn = new JButton("Add New Player");
        addNewPlayerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNewPlayer(gameEngine);
            }
        });

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        panel.add(addNewPlayerBtn);
        panel.add(closeBtn);

        contentPanel.add(panel);
        add(contentPanel);
        
        setTitle("Player GUI");
        setResizable(false);
        setBounds(100, 100, 400, 150);
    }

    public void initPlayerTable(GameEngine gameEngine) {

        GetAllPlayer get = new GetAllPlayer(gameEngine);
        Collection<Player> playerList = get.getAllPlayer();

        listPlayerPanel= new JPanel();

        if (playerList.size() > 0) {
            listPlayerPanel.setLayout(new GridLayout(playerList.size(), 6));

            for (Player ply : playerList) {
                listPlayerPanel.add(new JLabel("ID:"));
                listPlayerPanel.add(new JLabel(ply.getPlayerId()));
                listPlayerPanel.add(new JLabel("Name:"));
                listPlayerPanel.add(new JLabel(ply.getPlayerName()));
                listPlayerPanel.add(new JLabel("Points:"));
                listPlayerPanel.add(new JLabel(String.valueOf(ply.getPoints())));
            }
        } else {
            listPlayerPanel.add(new JLabel("No player in game."));
        }

        contentPanel.add(listPlayerPanel);
    }

    private void addNewPlayer(GameEngine gameEngine) {

        JFrame jframe = new JFrame();
        JPanel contentPanel = new JPanel(new GridLayout(2, 0));
        JPanel panel1 = new JPanel(new GridLayout(2, 2));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        panel1.add(new JLabel("Player Name:"));
        JTextField name = new JTextField();
        panel1.add(name);
        panel1.add(new JLabel("Initial Points:"));
        JTextField point = new JTextField();
        panel1.add(point);

        point.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                    getToolkit().beep();
                }
            }
        });

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new AddPlayers(name, point, jframe, gameEngine));
        panel2.add(okBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
            }
        });
        panel2.add(cancelBtn);

        contentPanel.add(panel1);
        contentPanel.add(panel2);

        jframe.setVisible(true);
        jframe.add(contentPanel);
        jframe.setResizable(false);
        jframe.setBounds(100, 100, 400, 150);
    }
}
