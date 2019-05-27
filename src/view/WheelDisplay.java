package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.ConstantVariable;
import model.interfaces.GameEngine;
import model.interfaces.Slot;

@SuppressWarnings("serial")
public class WheelDisplay extends JPanel implements ConstantVariable {

    private Image image;
    private ImageObserver imageObserver;
    private float degrees = 1;
    private int post = 0;
    HashMap<Integer, Integer> de = new HashMap<Integer, Integer>();
    private GameEngine gameEngine;

    public WheelDisplay(GameEngine gameEngine) {
        ImageIcon icon = new ImageIcon(IMAGE_LOCATION);
        image = icon.getImage();
        imageObserver = icon.getImageObserver();
        this.gameEngine = gameEngine;
//        setDegree();
    }

    /** Credit to stackoverflow forum : https://stackoverflow.com/questions/25923480/simple-circle-rotation-simulate-motion **/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int circleDiameter = Math.min(getWidth(), getHeight());
        double circleRadius = circleDiameter / HALF;
        int offSetX = (getWidth() - circleDiameter) / HALF;
        int offSetY = (getHeight() - circleDiameter) / HALF;
        
        g2d.drawImage(image, offSetX, offSetY, circleDiameter, circleDiameter, imageObserver);
        
        g2d.setColor(Color.BLUE);
        int ballDiameter = (int) (circleDiameter * BALL_SIZE);
        int ballRadius =  ballDiameter / HALF;

        Point p = getPointOnCircle(this.degrees, circleRadius * BALL_POSITION, circleRadius);

        int valueX = offSetX + p.x - ballRadius;
        int valueY = offSetY + p.y - ballRadius;
        g2d.fillOval(valueX, valueY, ballDiameter, ballDiameter);

        g2d.dispose();
    }
    
    private Point getPointOnCircle(float degress, double circleRadius, double innerCircleRadius) {
        
//        double rads = Math.toRadians(degress - 90); //  --> [Math.PI / 180 * (0 - 90);]
        
//        double rads =  ((Math.PI  * degrees) / Slot.WHEEL_SIZE); // <Formula for ball sitting on middle>
        double rads =  ((Math.PI  * degress) / Slot.WHEEL_SIZE);
        
//        System.out.println("radians : " + rads);
//        System.out.println("degress : " + degress);
        
        // Calculate the outter point of the line
        int xCordinate = Math.round((float) (innerCircleRadius + Math.cos(rads) * circleRadius));
        int yCordinate = Math.round((float) (innerCircleRadius + Math.sin(rads) * circleRadius));
        
        return new Point(xCordinate, yCordinate);
    }
    
//    public void setDegree() {
//        ArrayList<Slot> list = new ArrayList<Slot>();
//        list = (ArrayList<Slot>) this.gameEngine.getWheelSlots();
//        int k = 1;
//        Collections.rotate(list, -10);
//        
//        for(int x = 0; x < 38; x++) {
////            System.out.println(list.get(x).getPosition() +"|"+ list.get(x).getNumber() +"|"+ k);
//            de.put(list.get(x).getPosition(), k);
//            k += 2;
//        }
//    }
    
    public void setDegree(int x) {
        this.degrees += 2;
        this.post = x;
    }
}
