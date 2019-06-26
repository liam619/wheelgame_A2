package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {
    
    private JTextArea textArea;

    public SummaryPanel() {
        
        setLayout(new GridLayout(1,1));
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(50, 100));
        
        add(scrollPane);
    }
    
    /** Append the message when event happen **/
    public void setTextArea(String message) {
        DateFormat dateF = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
        textArea.append(dateF.format(new Date()).concat(message.concat("\n")));
    }
    
    /** Clear old message **/
    public void clearPreviousText() {
        textArea.setText("");
    }
    
    /** Loop all player info every time there is update **/
    public void displayPlayerSummary(GameEngine gameEngine) {
        clearPreviousText();
        setTextArea("Player Summary");
        for(Player ply : gameEngine.getAllPlayers()) {
            setTextArea(ply.toString());
        }
    }
}
