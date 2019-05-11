package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.ConstantVariable;

@SuppressWarnings("serial")
public class WheelDisplay extends JPanel implements ConstantVariable {

    private Image image;
    private ImageObserver imageObserver;
    private float degrees = 1;

    public WheelDisplay() {
        ImageIcon icon = new ImageIcon(IMAGE_LOCATION);
        image = icon.getImage();
        imageObserver = icon.getImageObserver();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // radius = diameter / 2
        int diameter = Math.min(getWidth(), getHeight());
        int bigX = (getWidth() - diameter) / 2;
        int bigY = (getHeight() - diameter) / 2;
        
        g2d.drawImage(image, bigX, bigY, diameter, diameter, imageObserver);
        
        /** fix this part onward **/
        g2d.setColor(Color.BLUE);
        float innerDiameter = diameter * 2 / 100;
        
        Point p = getPointOnCircle(this.degrees, (diameter / 2f) * 90 / 100, diameter);
        
        int valueX = bigX + p.x - (int) (innerDiameter / 2);
        int valueY = bigY + p.y - (int) (innerDiameter / 2);
        g2d.fillOval(valueX, valueY, (int) innerDiameter, (int) innerDiameter);
        
        g2d.dispose();
    }

    private Point getPointOnCircle(float degress, float radius, int diameter) {
        
        int x = Math.round(diameter / 2);
        int y = Math.round(diameter / 2);

//        double rads = Math.toRadians(degress - 90); // 0 becomes the top
        double rads =  Math.PI * degress / 38;
        
        System.out.println("radians : " + rads);
        System.out.println("degress : " + degress);
         
        // Calculate the outter point of the line
        int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
        int yPosy = Math.round((float) (y + Math.sin(rads) * radius));
        
        return new Point(xPosy, yPosy);
    }
    
    /** need to adjust **/
    public void setDegree() {
        this.degrees += 2;
    }
}
