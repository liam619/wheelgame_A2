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

import controller.FrameListener;
import model.ConstantVariable;
import model.StoreValue;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class DisplayResult implements ConstantVariable {

    private StoreValue storeValue;
    private GameEngine gameEngine;
    private DefaultTableModel model;

    public DisplayResult(StoreValue storeValue, GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.storeValue = storeValue;
    }

    public void initFrame() {

        JFrame jframe = new JFrame();
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel resultPanel = new JPanel(new GridLayout(0, 6));
        JPanel btnPanel = new JPanel();
        
        String position = "";
        String color = "";
        String number = "";
        
        /** The result of spin regardless if there is player or bet **/
        if(storeValue.getWinningSlot() != null) {
            position = String.valueOf(storeValue.getWinningSlot().getPosition());
            color = String.valueOf(storeValue.getWinningSlot().getColor());
            number = String.valueOf(storeValue.getWinningSlot().getNumber());
        }

        resultPanel.add(new JLabel("Position : "));
        resultPanel.add(new JLabel(position));
        resultPanel.add(new JLabel("Color : "));
        resultPanel.add(new JLabel(color));
        resultPanel.add(new JLabel("Number : "));
        resultPanel.add(new JLabel(number));

        /** If player exist, then will model the table **/
        if (gameEngine.getAllPlayers().size() > 0) {
            
            /** Column name for player table **/
            String[] colName = { "ID", "Name", "Bet Amount", "Bet Colour", "Points" };
            
            model = new DefaultTableModel();
            model.setColumnIdentifiers(colName);
            JTable jtable = new JTable(model);
            
            getTableData();
            
            contentPanel.add(new JScrollPane(jtable), BorderLayout.CENTER);
        }

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new FrameListener(jframe));
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

    /** Display table in the result frame **/
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
