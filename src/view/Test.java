package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Test extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Test frame = new Test();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(317, 39, 117, 29);
        panel.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));
        
        JLabel lblNewLabel = new JLabel("New label");
        panel_1.add(lblNewLabel);
        
        JLabel label_4 = new JLabel("");
        panel_1.add(label_4);
        
        JLabel label = new JLabel("");
        panel_1.add(label);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        panel_1.add(lblNewLabel_1);
        
        JLabel label_1 = new JLabel("");
        panel_1.add(label_1);
        
        JLabel label_2 = new JLabel("");
        panel_1.add(label_2);
    }
}
