import javax.swing.*;
import java.awt.*;

/**
 * @author Lucas Copque - 816112862 (CCP4BN-MCA1) / Denilson Medrano - 816122383 (CCP4BN-MCA2)
 * @version 1.0
 * @since 05/09/2019
 */
public class PolylinesTemplate extends JPanel {

    private void dda(Graphics g, Point p1, Point p2) {
        float len;

        // Checks whether the absolute value of deltaX is greater than or equal to the absolute value of deltaY.
        if (Math.abs(p2.x - p1.x) >= Math.abs(p2.y - p1.y)) {
            len = Math.abs(p2.x - p1.x);
        } else {
            len = Math.abs(p2.y - p1.y);
        }

        // Set values
        float deltaX = (p2.x - p1.x) / len;
        float deltaY = (p2.y - p1.y) / len;
        float x = p1.x;
        float y = p1.y;

        // Draws the line with, traversing a vector with module size between the points.
        for (int i = 0; i < len; i++) {
            draw(g, new Point((int) Math.floor(x), (int) Math.floor(y)));
            x += deltaX;
            y += deltaY;
        }
        // Draw the last point
        draw(g, new Point((int) Math.floor(x), (int) Math.floor(y)));
    }

    private void draw(Graphics g, Point spot) {
        g.fillOval(spot.x, spot.y, 5, 5);
    }

    public void paint(Graphics g) {
        dda(g, new Point(10, 10), new Point(400, 400));
        dda(g, new Point(400, 400), new Point(400, 500));
        dda(g, new Point(400, 500), new Point(30, 500));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new PolylinesTemplate());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Template: Draw Polylines");
    }
}
