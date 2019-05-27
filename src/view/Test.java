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
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Slot;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Test extends JFrame {

    int x = 1;

    public static void main(String[] args) {
        
        
        
        int de = 1;
        
        for(int x=0; x <= 360; x++) {
            double rads = ((Math.PI * de) / Slot.WHEEL_SIZE);
            System.out.println("Rads : " + rads +"| Degree : "+ de);
            System.out.println("Cos : " +Math.cos(rads) +"| Sin : "+ Math.sin(rads));
            
            de += 2;
        }
        
        
        
    }
    
}
