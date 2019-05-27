package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.StoreValue;

public class FrameListener implements ActionListener {

    private JFrame jframe;
    private StoreValue st;

    public FrameListener(JFrame jframe, StoreValue st) {
        this.jframe = jframe;
        this.st = st;
    }

    public FrameListener(JFrame jframe) {
        this.jframe = jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jframe.setVisible(false);
        
        if (st != null) {
            st.setPlayerGUI(null);
            st.setNewPlayerForm(null);
        }
    }
}
