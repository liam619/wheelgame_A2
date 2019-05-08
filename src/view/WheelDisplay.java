package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.ConstantVariable;

@SuppressWarnings("serial")
public class WheelDisplay extends JPanel implements ConstantVariable {

    private Image image;
    private ImageObserver imageObserver;

    public WheelDisplay() {
        ImageIcon icon = new ImageIcon(IMAGE_LOCATION);
        image = icon.getImage();
        imageObserver = icon.getImageObserver();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), imageObserver);
    }
}
