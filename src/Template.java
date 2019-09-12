import javax.swing.*;
import java.awt.*;

/**
 * @author Lucas Copque - 816112862 (CCP4BN-MCA1) / Denilson Medrano - 816122383 (CCP4BN-MCA2)
 * @version 1.0
 * @since 05/09/2019
 */
public class Template extends JPanel {

    private void chess(Graphics g) {
        g.fillRect(100, 100, 400, 400);
        for (int i = 100; i <= 400; i += 100) {
            for (int j = 100; j <= 400; j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }
        for (int i = 150; i <= 450; i += 100) {
            for (int j = 150; j <= 450; j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }
    }

    public void paint(Graphics g) {
        chess(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new Template());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Template: Computação Gráfica 2019.2");
    }

}
