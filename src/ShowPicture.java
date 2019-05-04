import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
class ShowPicture {
 public static void main(String args[]) {
  JFrame frame = new JFrame();
  ImageIcon icon = new ImageIcon("img/Basic_roulette_wheel_1024x1024.png");
  JLabel label = new JLabel(icon);
  frame.add(label);
  frame.setDefaultCloseOperation
         (JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
 }
}