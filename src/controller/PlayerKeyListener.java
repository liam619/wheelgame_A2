package controller;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import model.StoreValue;
import model.interfaces.Player;

public class PlayerKeyListener implements KeyListener {

    private Player ply;
    private JTextField jTextF;
    private StoreValue st;

    public PlayerKeyListener(Player ply, JTextField jTextF, StoreValue st) {
        this.ply = ply;
        this.jTextF = jTextF;
        this.st = st;
    }
    
    public PlayerKeyListener() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        JTextField jtf = (JTextField) e.getSource();
        if (jtf.getText().length() > 0 && ply != null && st != null) {
            st.setBetAmt(ply, jTextF.getText());
        }
    }
}
