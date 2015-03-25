import javax.swing.*;

/**
 * Created by Terje on 25.03.2015.
 */
public class Application {
    public static void main(String[] args) {
        final myPApplet applet = new myPApplet();
        applet.init();
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();

        panel1.add(applet);
        frame.add(panel1);
        frame.setSize(applet.getWidth(), applet.getHeight() + 100);

        frame.setVisible(true);

    }
}
