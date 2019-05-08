package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PlayerActionListener;
import model.ConstantVariable;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;

public class DisplayResult implements ConstantVariable {

    private Slot winningSlot;
    private GameEngine gameEngine;
    private DefaultTableModel model;

    public DisplayResult(Slot winningSlot, GameEngine gameEngine) {
        this.winningSlot = winningSlot;
        this.gameEngine = gameEngine;
    }

    public void initFrame() {

        JFrame jframe = new JFrame();
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel resultPanel = new JPanel(new GridLayout(0, 6));
        JPanel btnPanel = new JPanel();

        resultPanel.add(new JLabel("Position : "));
        resultPanel.add(new JLabel(String.valueOf(winningSlot.getPosition())));
        resultPanel.add(new JLabel("Color : "));
        resultPanel.add(new JLabel(String.valueOf(winningSlot.getColor())));
        resultPanel.add(new JLabel("Number : "));
        resultPanel.add(new JLabel(String.valueOf(winningSlot.getNumber())));

        if (gameEngine.getAllPlayers().size() > 0) {
            
            String[] colName = { "ID", "Name", "Bet Amount", "Bet Colour", "Points" };
            
            model = new DefaultTableModel();
            model.setColumnIdentifiers(colName);
            JTable jtable = new JTable(model);
            
            getTableData();
            
            contentPanel.add(new JScrollPane(jtable), BorderLayout.CENTER);
        }

        JButton closeBtn = new JButton("Close");
        closeBtn.setActionCommand(CLOSE_FRAME);
        closeBtn.addActionListener(new PlayerActionListener(jframe));
        btnPanel.add(closeBtn);

        contentPanel.add(resultPanel, BorderLayout.PAGE_START);
        contentPanel.add(btnPanel, BorderLayout.PAGE_END);
        jframe.add(contentPanel);
        
        jframe.pack();
        jframe.setVisible(true);
        jframe.setTitle(DISPLAYRESULT_TITLE);
        jframe.setResizable(true);
        jframe.setLocationRelativeTo(null);
     }

    public void getTableData() {

        for (Player ply : gameEngine.getAllPlayers()) {
            Vector<String> vec = new Vector<String>();
            vec.add(ply.getPlayerId());
            vec.add(ply.getPlayerName());
            vec.add(String.valueOf(ply.getBet()));
            vec.add(String.valueOf((ply.getBetType() == null)? "-" : ply.getBetType()));
            vec.add(String.valueOf(ply.getPoints()));
            
            model.addRow(vec);
        }
    }
}
