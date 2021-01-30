package com.dstu.laba7.ux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class  Frame extends JPanel implements ActionListener {

    private static final DisplayWorker displayWorker = new DisplayWorker();

    private static final int WINDOW_CENTER_POS_X = displayWorker.getWindowCenter().get("POS_X");

    private static final int WINDOW_CENTER_POS_Y = displayWorker.getWindowCenter().get("POS_Y");

    public Frame()
    {
        setBackground(Color.GRAY);
        setVisible(true);

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        int x = 300;
        int y = 300;
        Rectangle rect2 = new Rectangle(WINDOW_CENTER_POS_X-x/2, WINDOW_CENTER_POS_Y-y/2, x, y);

        g2d.rotate(Math.toRadians(45),WINDOW_CENTER_POS_X,WINDOW_CENTER_POS_Y);

        g2d.drawOval(WINDOW_CENTER_POS_X-x/2, WINDOW_CENTER_POS_Y-y/2, x, y);

        g2d.draw(rect2);
        g2d.scale(5,5);
        g2d.draw(rect2);

    }


    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
}
