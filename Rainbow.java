import javax.swing.*;
import java.awt.*;

public class Rainbow extends JPanel {

    private static final Color[] RAINBOW_COLORS = {
        Color.RED,
        Color.ORANGE,
        Color.YELLOW,
        Color.GREEN,
        Color.BLUE,
        new Color(75, 0, 130),    // INDIGO
        new Color(238, 130, 238)  // VIOLET
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight();

        int bandWidth = 40;
        int maxRadius = RAINBOW_COLORS.length * bandWidth;

        // Draw outermost (RED) first, then smaller arcs on top
        for (int i = 0; i < RAINBOW_COLORS.length; i++) {
            int radius = maxRadius - (i * bandWidth);
            g2d.setColor(RAINBOW_COLORS[i]);
            g2d.fillArc(
                centerX - radius,
                centerY - radius,
                radius * 2,
                radius * 2,
                0, 180   // startAngle=0, arcAngle=180 (top semicircle)
            );
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rainbow 🌈");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.add(new Rainbow());
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
    }
}