import javax.swing.*;
import processing.core.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Terje on 25.03.2015.
 */
public class Application {
    public static void main(String[] args) {
        final myPApplet applet = new myPApplet();
        applet.init();



        PathManager.startUp(applet);


        final JFrame frame = new JFrame();
        PGraphics pg = applet.createGraphics(applet.getWidth(),applet.getHeight());
        //applet.setPg(pg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JButton btnUp = new JButton("Speed Up");
        btnUp.addActionListener(new ActionListener() {
                                    @Override
                                public void actionPerformed(ActionEvent e){
                                        StatMan.incStepsPerDraw();
                                    }
                                });

        JButton btnDown = new JButton("Speed Down");

        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                StatMan.decStepsPerDraw();
            }
        });

        panel1.add(applet);
        frame.setLayout(new FlowLayout());
        frame.add(panel1);
        frame.add(btnUp);
        frame.add(btnDown);
        frame.setSize(applet.getWidth(), applet.getHeight() + 100);

        frame.setVisible(true);







    }


}
