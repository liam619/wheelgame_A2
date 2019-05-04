package view;

import javax.swing.JLabel;

public class WheelDisplay extends JLabel{
    
    public WheelDisplay() {
        
        WheelImg img = new WheelImg();
        JLabel imgLabel = new JLabel(img);
        
        imgLabel.setVisible(true);
        imgLabel.setBounds(10, 10, 400, 400);
        add(imgLabel);
    }

}
