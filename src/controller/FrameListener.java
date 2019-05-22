package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FrameListener implements ActionListener {

    private JFrame jframe;

    public FrameListener(JFrame jframe) {
        this.jframe = jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jframe.setVisible(false);
    }
}
