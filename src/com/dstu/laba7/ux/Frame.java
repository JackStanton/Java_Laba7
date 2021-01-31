package com.dstu.laba7.ux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class  Frame extends JPanel implements ActionListener {

    private static final DisplayWorker displayWorker = new DisplayWorker();

    private static final int WINDOW_CENTER_POS_X = displayWorker.getWindowCenter().get("POS_X");

    private static final int WINDOW_CENTER_POS_Y = displayWorker.getWindowCenter().get("POS_Y");

    private final Timer timer = new Timer(25, this);

    private static int x = 300;
    private static int y = 300;
    private static int step = 1;


    private static int flag = 0;

    public Frame(int sizeX, int sizeY, int step)
    {
        x = sizeX;
        y = sizeY;
        Frame.step = step;


        timer.start();
        setVisible(true);


    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

//        Rectangle rect2 = new Rectangle(WINDOW_CENTER_POS_X-x/2, WINDOW_CENTER_POS_Y-y/2, x, y);

        g2d.rotate(Math.toRadians(45),WINDOW_CENTER_POS_X,WINDOW_CENTER_POS_Y);

        g2d.drawOval(WINDOW_CENTER_POS_X-x/2, WINDOW_CENTER_POS_Y-y/2, x, y);

//        g2d.draw(rect2);
        g.dispose();


    }


    public void actionPerformed(ActionEvent e)
    {
        if (flag == 0){
            if(x<450){
                x += step;
                y += step;
            } else flag = 1;
        }
        if (flag == 1){
            if(x>300){
                x -= step;
                y -= step;
            } else flag = 0;
        }

        repaint();
    }
}
