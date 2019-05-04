package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import model.GameEngineImpl;
import model.interfaces.GameEngine;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Test extends JFrame {

    int x = 1;

    public static void main(String[] args) {
        Test t = new Test();
        
        t.meth();
    }
    
    public void meth() {
        GameEngine ge = new GameEngineImpl();
        int y = 1;
         x = (y != 0)? ++x : 1;
        
        System.out.println(x);
    }
}
