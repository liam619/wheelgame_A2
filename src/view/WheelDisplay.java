package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.ConstantVariable;
import model.interfaces.GameEngine;
import model.interfaces.Slot;

@SuppressWarnings("serial")
public class WheelDisplay extends JPanel implements ConstantVariable {

    private Image image;
    private int position = 0;

    public WheelDisplay(GameEngine gameEngine) {
        ImageIcon icon = new ImageIcon(IMAGE_LOCATION);
        image = icon.getImage();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int circleDiameter = Math.min(getWidth(), getHeight());
        double circleRadius = circleDiameter / HALF;
        int offSetX = (getWidth() - circleDiameter) / HALF;
        int offSetY = (getHeight() - circleDiameter) / HALF;
        
        g2d.drawImage(image, offSetX, offSetY, circleDiameter, circleDiameter, this);
        
        g2d.setColor(Color.BLUE);
        int ballDiameter = (int) (circleDiameter * BALL_SIZE);
        int ballRadius =  ballDiameter / HALF;

        float degress = (totalDegree * ((float) this.position /  Slot.WHEEL_SIZE));
        
        double rads = Math.toRadians(degress - 90);
        
        // Calculate the outter point of the line
        int xCordinate = Math.round((float) (circleRadius + Math.cos(rads) * (circleRadius * BALL_POSITION)));
        int yCordinate = Math.round((float) (circleRadius + Math.sin(rads) * (circleRadius * BALL_POSITION)));
        
        int valueX = offSetX + xCordinate - ballRadius;
        int valueY = offSetY + yCordinate - ballRadius;
        
        g2d.fillOval(valueX, valueY, ballDiameter, ballDiameter);
        
        g2d.dispose();
    }
    
    /** Redraw the frame to animate the ball spinning **/
    public void redraw(int pos) {
        this.position = pos;
        this.repaint();
    }
}
