package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AppFrame extends JFrame{

    public AppFrame() {
        super("Wheel Game");
        
        MenuBar mb = new MenuBar();
        StatusBar sb = new StatusBar();
        ToolBar tb = new ToolBar();
        
        setJMenuBar(mb);
        add(tb, BorderLayout.NORTH);
        add(sb, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        setBounds(100, 100, 650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
