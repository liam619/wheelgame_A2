package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WheelDisplay extends JPanel {

    private Image image;
    private ImageObserver imageObserver;

    public WheelDisplay() {
        ImageIcon icon = new ImageIcon("img/Basic_roulette_wheel_1024x1024.png");
        image = icon.getImage();
        imageObserver = icon.getImageObserver();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), imageObserver);
    }
}
