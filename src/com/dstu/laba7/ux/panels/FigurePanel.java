package com.dstu.laba7.ux.panels;

import com.dstu.laba7.ux.DisplayWorker;
import com.dstu.laba7.ux.figures.CustomRectangle;
import com.dstu.laba7.ux.figures.Figure;
import com.dstu.laba7.ux.figures.CustomRound;
import com.dstu.laba7.ux.threads.FigureRunnable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FigurePanel extends JPanel implements ActionListener{
    private final DisplayWorker displayWorker = new DisplayWorker();
    private final int WINDOW_CENTER_POS_X = displayWorker.getWindowCenter().get("POS_X");
    private final int WINDOW_CENTER_POS_Y = displayWorker.getWindowCenter().get("POS_Y");

    private final int x = 400;
    private final int y = 400;
    public static Figure rectangle;
    public static Figure managedRectangle;
    public static Figure round;

    public FigurePanel() {
        Timer timer = new Timer(25, this);
        timer.start();
        rectangle = new CustomRectangle(x,y);
        managedRectangle = new CustomRectangle(500,500);
        round = new CustomRound(300);
        Runnable rectangleRun = new FigureRunnable(rectangle,this,1);
        Runnable roundRun = new FigureRunnable(round, this,2);
        Thread rectangleThread = new Thread(rectangleRun);
        Thread roundThread = new Thread(roundRun);
        rectangleThread.start();
        roundThread.start();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(managedRectangle.getShape());
        g2d.rotate(Math.toRadians(45),WINDOW_CENTER_POS_X,WINDOW_CENTER_POS_Y);
        g2d.setPaint(round.getColor());
        g2d.draw(round.getShape());
        g2d.setPaint(rectangle.getColor());
        g2d.draw(rectangle.getShape());
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}