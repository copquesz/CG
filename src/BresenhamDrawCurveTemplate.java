import javax.swing.*;
import java.awt.*;

/**
 * @author Lucas Copque - 816112862 (CCP4BN-MCA1) / Denilson Medrano - 816122383 (CCP4BN-MCA2)
 * @version 1.0
 * @since 20/09/2019
 */
public class BresenhamDrawCurveTemplate extends JPanel {

    private void brasenhamAllSquad(Graphics g, Point p1, Point p2) {
        // Set values
        int x, y;
        int dx, dy;
        int slopeX, slopeY;
        int p;

        // Sets the slope of the lines according to delta X.
        if (p2.x >= p1.x) {
            dx = Math.abs(p2.x - p1.x);
            slopeX = 1;
        } else {
            dx = Math.abs(p1.x - p2.x);
            slopeX = -1;
        }

        // Sets the slope of the lines according to delta Y.
        if (p2.y >= p1.y) {
            dy = Math.abs(p2.y - p1.y);
            slopeY = 1;
        } else {
            dy = Math.abs(p1.y - p2.y);
            slopeY = -1;
        }

        x = p1.x;
        y = p1.y;

        if (dx >= dy) {
            dy <<= 1;
            p = dy - dx;
            dx <<= 1;

            while (x != p2.x) {
                draw(g, new Point(x, y));
                if (p >= 0) {
                    y += slopeY;
                    p -= dx;
                }
                p += dy;
                x += slopeX;
            }
            draw(g, new Point(x, y));
        } else {
            dx <<= 1;
            p = dx - dy;
            dy <<= 1;

            while (y != p2.y) {
                draw(g, new Point(x, y));
                if (p >= 0) {
                    x += slopeX;
                    p -= dy;
                }
                p += dx;
                y += slopeY;
            }
            draw(g, new Point(x, y));
        }
    }

    private void draw(Graphics g, Point spot) {
        g.fillOval(spot.x, spot.y, 2, 2);
    }

    public void paint(Graphics g) {

        int increment = 0;
        while(increment <= 500){
            brasenhamAllSquad(g, new Point(1, increment), new Point(increment, 500));
            increment = increment + 5;
        }





    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new BresenhamDrawCurveTemplate());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Template: Bresenham Draw Curve");
    }
}
