import javax.swing.*;
import java.awt.*;

/**
 * @author Lucas Copque - 816112862 (CCP4BN-MCA1) / Denilson Medrano - 816122383 (CCP4BN-MCA2)
 * @version 1.0
 * @since 12/09/2019
 */
public class BresenhamDrawXTemplate extends JPanel{

    private void brasenhamAllSquad(Graphics g, Point p1, Point p2) {
        // Set values
        int x1 = p1.x, y1 = p1.y, x2 = p2.x, y2 = p2.y;
        int dx = x2 - x1, dy = y2 - y1, slope = 0, p;

        // Reverses the point values if deltaX is negative.
        if (dx < 0) {
            brasenhamAllSquad(g, new Point(x2, y2), new Point(x1, y1));
            return;
        }

        // Checks the slope of the line.
        if (dy < 0) {
            slope = -1;
        } else {
            slope = 1;
        }

        // Draw the first spot.
        draw(g, new Point(x1, y1));

        // Runs the algorithm below if the slope of the line is less than or equal to 0.
        if (dx >= (slope * dy)) {
            // If y1 > y2
            if (dy < 0) {
                p = 2 * dy + dy;
                while (x1 < x2) {
                    if (p < 0) {
                        p = p + 2 * dy + dx;
                        x1++;
                        y1--;
                    } else {
                        p = p + 2 * dy;
                        x1++;
                    }
                    draw(g, new Point(x1, y1));
                }
            }
            // if y1 < y2
            else {
                p = 2 * dy - dx;
                while (x1 < x2) {
                    if (p < 0) {
                        p = p + 2 * dy;
                        // varies in x
                        x1++;
                    } else {
                        p = p + 2 * dy - dx;
                        x1++;
                        y1++;
                    }
                    draw(g, new Point(x1, y1));
                }
            }
        }
        // Runs the algorithm below if the slope of the line is greater than or equal to 0
        else {
            // If y1 > y2
            if (dy < 0) {
                p = dy + 2 * dx;
                while (y1 > y2) {
                    if (p < 0) {
                        p = p + 2 * dx;
                        // Varies in y
                        y1--;
                    } else {
                        p = p + 2 * dy + dx;
                        x1++;
                        y1--;
                    }
                    draw(g, new Point(x1, y1));
                }
            }
            // If y1 < y2
            else {
                p = dy - 2 * dx;
                while (y1 < y2) {
                    if (p < 0) {
                        p = p + (-2 * dy - dx);
                        x1++;
                        y1++;
                    } else {
                        p = p + (-2 * dx);
                        //Varies in y
                        y1++;
                    }
                    draw(g, new Point(x1, y1));
                }
            }
        }
        draw(g, new Point(x1, y1));
    }

    private void draw(Graphics g, Point spot) {
        g.fillOval(spot.x, spot.y, 5, 5);
    }

    public void paint(Graphics g) {
        brasenhamAllSquad(g, new Point(200, 200), new Point(350, 50));
        brasenhamAllSquad(g, new Point(200, 200), new Point(50, 50));
        brasenhamAllSquad(g, new Point(200, 200), new Point(50, 350));
        brasenhamAllSquad(g, new Point(200, 200), new Point(350, 350));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new BresenhamDrawXTemplate());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Template: Bresenham Draw X");
    }
}
